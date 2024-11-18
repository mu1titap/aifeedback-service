package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.in.OcrUseCase;
import com.multitap.feedback.application.port.out.OcrApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OcrService implements OcrUseCase {

    private final OcrApiPort ocrApiPort;

    @Override
    public OcrResponseVo analyzeImage(OcrRequestVo ocrRequestVo) {
        return ocrApiPort.callOcrApi(ocrRequestVo);
    }

}
