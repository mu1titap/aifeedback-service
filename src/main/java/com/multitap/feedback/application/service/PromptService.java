package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.in.vo.PromptRequestVo;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptResponseVo;
import com.multitap.feedback.application.port.in.PromptUseCase;
import com.multitap.feedback.application.port.in.dto.in.PromptRequestDto;
import com.multitap.feedback.application.port.out.PromptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromptService implements PromptUseCase {

    private final PromptApiPort promptApiPort;

    @Override
    public PromptResponseVo sendRequestPrompt(PromptRequestDto promptRequestDto) {
        return promptApiPort.callPromptApi(promptRequestDto);
    }
}
