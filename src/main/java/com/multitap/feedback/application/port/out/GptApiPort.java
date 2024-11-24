package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    GptResponseVo callGptApi(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest, PromptDetailsResponseVo promptDetailsResponseVo);
    GptResponseVo completions(GptRequestVo gptRequestVo);
}
