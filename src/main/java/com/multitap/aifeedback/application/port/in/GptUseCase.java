package com.multitap.aifeedback.application.port.in;

import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;

public interface GptUseCase {

    GptResponseVo sendFeedbackRequestToGpt(CombinedPromptRequestDto combinedPromptRequestDto);
}

