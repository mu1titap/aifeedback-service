package com.multitap.feedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OcrProcessedFeedbackRequest {

    private String prompt;

    @Builder
    public OcrProcessedFeedbackRequest(String prompt) {
        this.prompt = prompt;
    }

    public static OcrProcessedFeedbackRequest from(String prompt){
        return OcrProcessedFeedbackRequest.builder()
                .prompt(prompt)
                .build();
    }

}
