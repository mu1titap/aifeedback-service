package com.multitap.feedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class GptRequestDto {

    private String model;
    private List<Message> messages;

    @Builder
    public GptRequestDto(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add((new Message("user", prompt)));
    }

    public static GptRequestDto from(String model) {
        return GptRequestDto.builder()
                .model(model)
                .build();
    }


    @Getter
    @NoArgsConstructor
    public static class Message {

        private String role;
        private String content;

        @Builder
        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}
