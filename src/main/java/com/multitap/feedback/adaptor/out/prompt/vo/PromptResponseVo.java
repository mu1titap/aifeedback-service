package com.multitap.feedback.adaptor.out.prompt.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromptResponseVo {

    private String replyFormat;
    private String request;

}
