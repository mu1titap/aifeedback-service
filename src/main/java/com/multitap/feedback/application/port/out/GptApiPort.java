package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.out.gpt.dto.GptResponseVo;
import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import org.springframework.stereotype.Component;

@Component
public interface GptApiPort {

    GptResponseVo callGptApi(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest);
}
