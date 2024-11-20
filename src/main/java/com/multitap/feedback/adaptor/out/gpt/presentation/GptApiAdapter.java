package com.multitap.feedback.adaptor.out.gpt.presentation;

import com.multitap.feedback.adaptor.out.gpt.dto.GptResponseVo;
import com.multitap.feedback.application.port.in.dto.in.GptRequestDto;
import com.multitap.feedback.application.port.in.dto.out.GptResponseDto;
import com.multitap.feedback.application.port.out.GptApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@Slf4j
public class GptApiAdapter implements GptApiPort {

    private final RestTemplate gptRestTemplate;

    public GptApiAdapter(@Qualifier("gptRestTemplate") RestTemplate gptRestTemplate) {
        this.gptRestTemplate = gptRestTemplate;
    }

    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiURL;

    @Override
    public GptResponseVo callGptApi(GptRequestDto gptRequestDto) {
        GptResponseDto gptResponseDto = gptRestTemplate.postForObject(apiURL, GptRequestDto.from(model), GptResponseDto.class);
        return GptResponseVo.from(gptResponseDto.getChoices().get(0).getMessage().getContent());
    }

}