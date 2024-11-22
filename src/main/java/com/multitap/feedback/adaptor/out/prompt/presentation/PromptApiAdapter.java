package com.multitap.feedback.adaptor.out.prompt.presentation;

import com.multitap.feedback.adaptor.in.vo.PromptRequestVo;
import com.multitap.feedback.adaptor.out.prompt.vo.PromptResponseVo;
import com.multitap.feedback.application.port.in.dto.in.PromptRequestDto;
import com.multitap.feedback.application.port.out.PromptApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class PromptApiAdapter implements PromptApiPort {

    private final RestTemplate promptRestTemplate;

    @Value("${ocr.api.url}")
    //todo: prompt url 적어서 restemplate 에 값 요청하는거 구현해야함
    private String apiURL;

    public PromptApiAdapter(@Qualifier("promptRestTemplate") RestTemplate promptRestTemplate) {
        this.promptRestTemplate = promptRestTemplate;
    }

    @Override
    public PromptRequestVo callPromptApi(PromptRequestDto promptRequestDto) {

        ResponseEntity<PromptResponseVo> response = promptRestTemplate.postForEntity(

        )

        return
    }
}
