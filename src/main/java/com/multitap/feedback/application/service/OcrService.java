package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.dto.in.OcrRequestDto;
import com.multitap.feedback.application.port.in.OcrUseCase;
import com.multitap.feedback.application.port.out.OcrApiPort;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class OcrService implements OcrUseCase {

    private final OcrApiPort ocrApiPort;

    @Override
    public List<OcrResponseVo> analyzeImage(OcrRequestVo ocrRequestVo) throws IOException {

        return ocrApiPort.callOcrApi(convertPdfToImages(ocrRequestVo));

    }

    public OcrRequestDto convertPdfToImages(OcrRequestVo ocrRequestVo) throws IOException {

        List<File> imageFiles = new ArrayList<>();

        // 임시 디렉토리 생성
        Path tempDir = Files.createTempDirectory("ocr-");
        PDDocument document = PDDocument.load(ocrRequestVo.getFile().getInputStream());
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        for (int pageIndex = 0; pageIndex < document.getNumberOfPages(); pageIndex++) {
            // 페이지를 300 DPI 해상도로 이미지로 변환
            BufferedImage image = pdfRenderer.renderImageWithDPI(pageIndex, 300);  // 300 DPI로 설정

            // 임시 파일로 저장
            Path tempImagePath = tempDir.resolve("page_" + pageIndex + ".png");
            File tempImageFile = tempImagePath.toFile();
            ImageIO.write(image, "PNG", tempImageFile);  // PNG 형식으로 저장
            imageFiles.add(tempImageFile);
        }

        document.close();

        return OcrRequestDto.from(imageFiles);
    }
}