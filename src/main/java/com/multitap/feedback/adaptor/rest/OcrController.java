package com.multitap.feedback.adaptor.rest;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.in.OcrUseCase;
import com.multitap.feedback.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
@Slf4j
public class OcrController {

    private final OcrUseCase ocrUseCase;

    @PostMapping("/submit")
    public BaseResponse<OcrResponseVo> submit(@ModelAttribute OcrRequestVo ocrRequestVo) {
        return new BaseResponse<>(ocrUseCase.analyzeImage(ocrRequestVo));
    }

}
