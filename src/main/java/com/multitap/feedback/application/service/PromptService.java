package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.PromptUseCase;
import com.multitap.feedback.application.port.in.dto.in.RetrievePromptRequestVo;
import com.multitap.feedback.application.port.out.PromptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromptService implements PromptUseCase {

    private final PromptApiPort promptApiPort;

    @Override
    public PromptDetailsResponseVo sendRequestPrompt(RetrievePromptRequestVo retrievePromptRequestVo) {
        return promptApiPort.callPromptApi(retrievePromptRequestVo);
    }
}
