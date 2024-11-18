package com.multitap.feedback.application.port.dto.in;

import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
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

    public static GptRequestDto from(GptRequestVo gptRequestVo, String model) {
        return GptRequestDto.builder()
                .model(model)
                .prompt(gptRequestVo.getPrompt())
                .build();
    }

}
