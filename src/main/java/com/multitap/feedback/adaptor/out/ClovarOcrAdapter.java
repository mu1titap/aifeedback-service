package com.multitap.feedback.adaptor.out;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.out.ClovaOcrApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ClovarOcrAdapter implements ClovaOcrApiPort {

    private final RestTemplate clovaRestTemplate;

    public ClovarOcrAdapter(@Qualifier("clovaRestTemplate") RestTemplate clovarRestTemplate) {
        this.clovaRestTemplate = clovarRestTemplate;
    }

    @Value("${clova.api.url}")
    private String apiURL;

    @Override
    public OcrResponseVo callClovarOcrApi(OcrRequestVo ocrRequestVo) {

    }
}
