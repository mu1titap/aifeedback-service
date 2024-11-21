package com.multitap.feedback.adaptor.out.gpt.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GptResponseVo {

    private String gptResponseContent;

    @Builder
    public GptResponseVo(String gptResponseContent) {
        this.gptResponseContent = gptResponseContent;
    }

    public static GptResponseVo from(String gptResponseContent) {
        return GptResponseVo.builder()
               .gptResponseContent(gptResponseContent)
               .build();
    }

}


