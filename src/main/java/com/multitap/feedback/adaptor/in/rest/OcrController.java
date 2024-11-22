package com.multitap.feedback.adaptor.in.rest;

import com.multitap.feedback.adaptor.in.mapper.OcrVoMapper;
import com.multitap.feedback.adaptor.in.mapper.PromptVoMapper;
import com.multitap.feedback.adaptor.in.vo.PromptRequestVo;
import com.multitap.feedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptResponseVo;
import com.multitap.feedback.application.port.in.GptUseCase;
import com.multitap.feedback.application.port.in.OcrUseCase;
import com.multitap.feedback.application.port.in.PromptUseCase;
import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.feedback.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
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

    private final OcrUseCase ocrUseCase;
    private final PromptUseCase promptUseCase;
    private final GptUseCase gptUseCase;

    @Operation(summary = "피드백 받을 pdf 파일(이력서,포트폴리오)를 업로드", description = "pdf 파일 용량은 10MB로 제한")
    @PostMapping(value = "/submit", consumes = "multipart/form-data")
    public BaseResponse<GptResponseVo> submit(@RequestParam("file") MultipartFile file, @RequestBody PromptRequestVo promptRequestVo) throws IOException {

        // OCR 분석
        OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest = ocrUseCase.uploadPdfForOcr(OcrVoMapper.from(file));

        // ocr 분석 값과 프롬프트 합치기
        PromptResponseVo promptResponseVo = promptUseCase.sendRequestPrompt(PromptVoMapper.from(promptRequestVo));

        // GPT 피드백 요청
        GptResponseVo gptResponseVo = gptUseCase.sendFeedbackRequestToGpt(ocrProcessedFeedbackRequest);
        log.info("GPT API 피드백 요청 값 : {}", ocrProcessedFeedbackRequest.getPrompt());

        return new BaseResponse<>(gptResponseVo);
    }
}