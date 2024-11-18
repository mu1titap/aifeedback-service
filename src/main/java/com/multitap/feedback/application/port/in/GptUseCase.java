package com.multitap.feedback.application.port.in;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.vo.GptResponseVo;

public interface GptUseCase {

    GptResponseVo handleChat(GptRequestVo gptRequestVo);
}
