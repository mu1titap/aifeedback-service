package com.multitap.feedback.adaptor.in.rest;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.feedback.application.port.in.GptUseCase;
import com.multitap.feedback.application.port.in.dto.in.GptRequestDto;
import com.multitap.feedback.application.port.in.dto.out.GptResponseDto;
import com.multitap.feedback.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
@Slf4j
public class GptController {

    private final GptUseCase gptUseCase;

    @Operation(summary = "GPT 학습용", description = "gpt 파인튜닝 및 설정 요청")
    @PostMapping("/completions/{prompt}")
    public BaseResponse<GptResponseVo> completions(@PathVariable String prompt) {
        GptResponseVo gptResponseVo = gptUseCase.completionToGpt(GptRequestVo.from(prompt));
        return new BaseResponse<>(gptResponseVo);
    }
}