package com.multitap.aifeedback.adaptor.out.gpt.presentation;

import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
import com.multitap.aifeedback.application.port.in.dto.in.GptRequestDto;
import com.multitap.aifeedback.application.port.in.dto.out.GptResponseDto;
import com.multitap.aifeedback.application.port.out.GptApiPort;
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
    private String apiUrl;


    @Override
    public GptResponseVo callGptApi(CombinedPromptRequestDto combinedPromptRequestDto) {
        GptResponseDto gptResponseDto = gptRestTemplate.postForObject(apiUrl,GptRequestDto.from(model,combinedPromptRequestDto.getRequest() + combinedPromptRequestDto.getPromptDetails().getRequest() + combinedPromptRequestDto.getPromptDetails().getReplyFormat()), GptResponseDto.class);
        log.info("gpt 응답 : {} ", gptResponseDto.getChoices().get(0).getMessage().getContent());
        return GptResponseVo.from(gptResponseDto.getChoices().get(0).getMessage().getContent());
        //todo: 응답 양식이 다를 수 있으니까 이걸 리턴값을 오브젝트로 받아야 하나?
    }
}