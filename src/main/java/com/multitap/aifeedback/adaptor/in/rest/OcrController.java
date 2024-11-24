package com.multitap.aifeedback.adaptor.in.rest;

import com.multitap.aifeedback.adaptor.in.mapper.OcrVoMapper;
import com.multitap.aifeedback.adaptor.in.mapper.PromptVoMapper;
import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.OcrUseCase;
import com.multitap.aifeedback.application.port.in.PromptUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.common.response.BaseResponse;
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
    public BaseResponse<GptResponseVo> submit(@RequestParam("file") MultipartFile file, @RequestParam("industryType") String industryType,
                                              @RequestParam("documentType") String documentType) throws IOException {

        log.info("산업,문서타입: {},{}", industryType, documentType);

        // OCR 분석
        OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest = ocrUseCase.uploadPdfForOcr(OcrVoMapper.from(file));
        log.info("ocr 분석 완료 : {}", ocrProcessedFeedbackRequest.getContent());

        // ocr 분석 값과 프롬프트 합치기
        PromptDetailsResponseVo promptDetailsResponseVo = promptUseCase.sendRequestPrompt(PromptVoMapper.from(industryType,documentType));
        log.info("프롬프트 : {}", promptDetailsResponseVo.getRequest());

        // GPT 피드백 요청
        GptResponseVo gptResponseVo = gptUseCase.sendFeedbackRequestToGpt(ocrProcessedFeedbackRequest, promptDetailsResponseVo);
        log.info("GPT API 피드백 응답 값 : {}", gptResponseVo.getGptResponseContent());

        return new BaseResponse<>(gptResponseVo);
    }
}