package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
import com.multitap.feedback.adaptor.out.vo.GptResponseVo;
import com.multitap.feedback.application.port.in.GptUseCase;
import com.multitap.feedback.application.port.out.GptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class APIService implements GptUseCase {

    private final GptApiPort gptApiPort;

    @Override
    public GptResponseVo handleChat(GptRequestVo gptRequestVo) {
        return gptApiPort.callGptApi(gptRequestVo);
    }
}
