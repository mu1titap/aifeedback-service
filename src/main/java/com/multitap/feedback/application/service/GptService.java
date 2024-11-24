package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.GptUseCase;
import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.feedback.application.port.out.GptApiPort;
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
