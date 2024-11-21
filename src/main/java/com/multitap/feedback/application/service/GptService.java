package com.multitap.feedback.application.service;

import com.multitap.feedback.adaptor.out.gpt.dto.GptResponseVo;
import com.multitap.feedback.application.port.in.GptUseCase;
import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.feedback.application.port.out.GptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GptService implements GptUseCase {

    private final GptApiPort gptApiPort;

    @Override
    public GptResponseVo sendFeedbackRequestToGpt(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest) {
        return gptApiPort.callGptApi(ocrProcessedFeedbackRequest);
    }
}
