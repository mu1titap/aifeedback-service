package com.multitap.feedback.application.service;
import com.multitap.feedback.application.port.in.GptUseCase;
import com.multitap.feedback.application.port.in.dto.in.GptRequestDto;
import com.multitap.feedback.application.port.out.GptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class APIService implements GptUseCase {

    private final GptApiPort gptApiPort;

    @Override
    public void sendFeedbackRequestToPort(GptRequestDto gptRequestDto) {
        gptApiPort.callGptApi(gptRequestDto);
    }
}
