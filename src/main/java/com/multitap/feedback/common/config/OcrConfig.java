package com.multitap.feedback.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class OcrConfig extends BaseRestTemplateConfig {

    @Value("${ocr.api.key}")
    private String ocrKey;

    @Bean(name = "ocrRestTemplate")
    public RestTemplate ocrRestTemplate() {
        log.info("Initializing Clova OCR RestTemplate...");
        return createRestTemplate("X-OCR-SECRET", ocrKey);
    }
}


