package com.multitap.aifeedback.application.port.in;

import com.multitap.aifeedback.adaptor.in.vo.GptRequestVo;
import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.application.port.in.dto.in.TextRequestDto;

public interface GptUseCase {

    GptResponseVo sendFeedbackRequestToOcr(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest, PromptDetailsResponseVo promptDetailsResponseVo);
    GptResponseVo sendFeedbackRequestToText(TextRequestDto textRequestDto);
}

