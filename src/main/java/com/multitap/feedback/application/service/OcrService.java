package com.multitap.feedback.application.service;

import com.multitap.feedback.application.mapper.OcrDtoMapper;
import com.multitap.feedback.application.port.in.dto.in.OcrImageDto;
import com.multitap.feedback.application.port.in.dto.in.OcrRequestDto;
import com.multitap.feedback.application.port.in.OcrUseCase;
import com.multitap.feedback.application.port.in.dto.out.OcrResponseDto;
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
    public List<OcrResponseDto> analyzeImage(OcrRequestDto ocrRequestDto) throws IOException {

        return ocrApiPort.callOcrApi(convertPdfToImages(ocrRequestDto));

        // todo 1: 위에서 리턴받은 List<OcrResponseDto> 을 파싱
        // todo 2: 파싱된 텍스트를  GPT 이용하는 아웃포트에 요청
        // todo 3: gpt에게 받은 피드백 내용을 리턴
     }

    public OcrImageDto convertPdfToImages(OcrRequestDto ocrRequestDto) throws IOException {

        List<File> imageFiles = new ArrayList<>();

        // 임시 디렉토리 생성
        Path tempDir = Files.createTempDirectory("ocr-");
        PDDocument document = PDDocument.load(ocrRequestDto.getFile().getInputStream());
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

        return OcrDtoMapper.from(imageFiles);
    }


}