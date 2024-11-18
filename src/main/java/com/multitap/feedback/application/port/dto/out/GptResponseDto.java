package com.multitap.feedback.application.port.dto.out;

import com.multitap.feedback.application.port.dto.in.Message;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
public class GptResponseDto {

    private List<Choice> choices;

    @Builder
    public GptResponseDto(List<Choice> choices) {
        this.choices = choices;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Choice {
        private int index;
        private Message message;
    }
}
