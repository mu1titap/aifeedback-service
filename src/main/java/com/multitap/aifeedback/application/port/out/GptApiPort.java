package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.adaptor.in.vo.GptRequestVo;
import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    GptResponseVo callGptApi(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest, PromptDetailsResponseVo promptDetailsResponseVo);
    GptResponseVo completions(GptRequestVo gptRequestVo);
}
