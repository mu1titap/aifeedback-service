package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.dto.in.RetrievePromptRequestVo;
import org.springframework.stereotype.Component;

@Component
public interface PromptApiPort {

    PromptDetailsResponseVo callPromptApi(RetrievePromptRequestVo retrievePromptRequestVo);

}
