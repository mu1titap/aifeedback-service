package com.multitap.feedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PromptRequestDto {

    private String industry;
    private String documentType;

    @Builder
    public PromptRequestDto(String industry, String documentType) {
        this.industry = industry;
        this.documentType = documentType;
    }
}
