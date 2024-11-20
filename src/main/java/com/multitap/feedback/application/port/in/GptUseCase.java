package com.multitap.feedback.application.port.in;

import com.multitap.feedback.application.port.in.dto.in.GptRequestDto;

public interface GptUseCase {

    void sendFeedbackRequestToPort(GptRequestDto gptRequestDto);
}
