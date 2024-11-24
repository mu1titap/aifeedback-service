package com.multitap.feedback.application.port.in;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;

public interface GptUseCase {

    GptResponseVo sendFeedbackRequestToGpt(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest, PromptDetailsResponseVo promptDetailsResponseVo);
    GptResponseVo completionToGpt(GptRequestVo gptRequestVo);
}

