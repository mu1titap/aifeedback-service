package com.multitap.feedback.adaptor.out.prompt.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromptDetailsResponseVo {

    private String replyFormat;

    private String request;

}
