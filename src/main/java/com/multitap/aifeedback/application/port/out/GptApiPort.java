package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    GptResponseVo callGptApi(CombinedPromptRequestDto combinedPromptRequestDto);
}
