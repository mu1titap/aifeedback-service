package com.multitap.feedback.adaptor.in.rest;

import com.multitap.feedback.adaptor.in.mapper.OcrVoMapper;
import com.multitap.feedback.adaptor.out.gpt.dto.GptResponseVo;
import com.multitap.feedback.adaptor.out.ocr.presentation.OcrProcessingService;
import com.multitap.feedback.application.port.out.GptApiPort;
import com.multitap.feedback.application.service.OcrService;
import com.multitap.feedback.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/ai-feedback")
@RequiredArgsConstructor
@Slf4j
public class OcrController {

    private final GptApiPort gptApiPort;
    private final OcrService ocrService;
    private final OcrProcessingService ocrProcessingService;

    @PostMapping(value = "/submit", consumes = "multipart/form-data")
    public BaseResponse<GptResponseVo> submit(@RequestParam("file") MultipartFile file) throws IOException {

        // GptApiPort 직접 호출
        GptResponseVo gptResponseVo = gptApiPort.callGptApi(ocrProcessingService.parseOcrResponses((ocrService.analyzeImage(OcrVoMapper.from(file)))));

        return new BaseResponse<>(gptResponseVo);
    }
