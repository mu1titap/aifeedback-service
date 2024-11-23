package com.multitap.feedback.application.port.in;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.dto.in.RetrievePromptRequestVo;

public interface PromptUseCase {

    PromptDetailsResponseVo sendRequestPrompt (RetrievePromptRequestVo retrievePromptRequestVo);
}
