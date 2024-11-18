package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.vo.GptResponseVo;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    GptResponseVo callGptApi(GptRequestVo gptRequestVo);
}
