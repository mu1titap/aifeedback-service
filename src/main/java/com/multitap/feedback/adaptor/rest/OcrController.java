package com.multitap.feedback.adaptor.rest;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.in.OcrUseCase;
import com.multitap.feedback.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/ai-feedback")
@RequiredArgsConstructor
@Slf4j
public class OcrController {

    private final OcrUseCase ocrUseCase;

    @PostMapping(value = "/submit", consumes = "multipart/form-data")
    public BaseResponse<List<OcrResponseVo>> submit(@RequestParam("file") MultipartFile file) throws IOException {
        return new BaseResponse<>(ocrUseCase.analyzeImage(OcrRequestVo.from(file)));
    }

}
