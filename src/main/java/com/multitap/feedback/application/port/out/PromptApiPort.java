package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.in.vo.PromptRequestVo;
import com.multitap.feedback.application.port.in.dto.in.PromptRequestDto;
import org.springframework.stereotype.Component;

@Component
public interface PromptApiPort {

    PromptRequestVo callPromptApi(PromptRequestDto promptRequestDto);

}
