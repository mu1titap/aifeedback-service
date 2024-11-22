package com.multitap.feedback.application.port.in;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptResponseVo;
import com.multitap.feedback.application.port.in.dto.in.PromptRequestDto;

public interface PromptUseCase {

    PromptResponseVo sendRequestPrompt (PromptRequestDto promptRequestDto);
}
