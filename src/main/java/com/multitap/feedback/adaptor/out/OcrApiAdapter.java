package com.multitap.feedback.adaptor.out;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.out.OcrApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class OcrApiAdapter implements OcrApiPort {

    private final RestTemplate ocrRestTemplate;

    public OcrApiAdapter(@Qualifier("ocrRestTemplate") RestTemplate ocrRestTemplate) {
        this.ocrRestTemplate= ocrRestTemplate;
    }

    @Value("${ocr.api.url}")
    private String apiURL;

    @Override
    public OcrResponseVo callOcrApi(OcrRequestVo ocrRequestVo) {
        return new OcrResponseVo();
    }
}
