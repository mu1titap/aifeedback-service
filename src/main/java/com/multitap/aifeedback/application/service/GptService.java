package com.multitap.aifeedback.application.service;

import com.multitap.aifeedback.adaptor.in.vo.GptRequestVo;
import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.application.port.out.GptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GptService implements GptUseCase {

    private final GptApiPort gptApiPort;

    @Override
    public GptResponseVo sendFeedbackRequestToGpt(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest, PromptDetailsResponseVo promptDetailsResponseVo) {
        return gptApiPort.callGptApi(ocrProcessedFeedbackRequest, promptDetailsResponseVo);
    }

    @Override
    public GptResponseVo completionToGpt(GptRequestVo gptRequestVo) {
        return gptApiPort.completions(gptRequestVo);
    }
}
