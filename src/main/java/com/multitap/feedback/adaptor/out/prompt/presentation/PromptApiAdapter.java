package com.multitap.feedback.adaptor.out.prompt.presentation;

import com.multitap.feedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.feedback.application.port.in.dto.in.RetrievePromptRequestVo;
import com.multitap.feedback.application.port.out.PromptApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@Slf4j
public class PromptApiAdapter implements PromptApiPort {

    private final RestTemplate promptRestTemplate;

    @Value("${prompt.api.url}")
    private String apiURL;

    public PromptApiAdapter(@Qualifier("promptRestTemplate") RestTemplate promptRestTemplate) {
        this.promptRestTemplate = promptRestTemplate;
    }

    @Override
    public PromptDetailsResponseVo callPromptApi(RetrievePromptRequestVo retrievePromptRequestVo) {

        ResponseEntity<PromptDetailsResponseVo> response = promptRestTemplate.exchange(
                apiURL,
                HttpMethod.POST,
                new HttpEntity<>(retrievePromptRequestVo),
                PromptDetailsResponseVo.class
        );
        log.info("응답 성공 : {}", response.getStatusCode());
        log.info("프롬프트 왜 널인지 모르겠는 값: {}", (response.getBody().getReplyFormat()));

        return response.getBody();
    }
}
