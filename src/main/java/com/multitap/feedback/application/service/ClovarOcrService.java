package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.in.ClovarOcrUseCase;
import com.multitap.feedback.application.port.out.ClovaOcrApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClovarOcrService implements ClovarOcrUseCase {

    private final ClovaOcrApiPort clovaOcrApiPort;

    @Override
    public OcrResponseVo analyzeImage(OcrRequestVo ocrRequestVo) {
        return clovaOcrApiPort.callClovarOcrApi(ocrRequestVo);
    }
}
