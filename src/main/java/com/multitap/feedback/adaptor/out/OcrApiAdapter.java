package com.multitap.feedback.adaptor.out;

import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.dto.in.OcrRequestDto;
import com.multitap.feedback.application.port.out.OcrApiPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class OcrApiAdapter implements OcrApiPort {

    private final RestTemplate ocrRestTemplate;

    @Value("${ocr.api.url}")
    private String apiURL;


    public OcrApiAdapter(@Qualifier("ocrRestTemplate") RestTemplate ocrRestTemplate) {
        this.ocrRestTemplate = ocrRestTemplate;
    }

    @Override
    public List<OcrResponseVo> callOcrApi(OcrRequestDto ocrRequestDto) {
        List<OcrResponseVo> responseList = new ArrayList<>();

        try {
            // 이미지 파일을 하나씩 반복하여 OCR API 호출
            for (File imageFile : ocrRequestDto.getImageFiles()) {
                // 요청 엔티티 생성 (헤더에서 X-OCR-SECRET을 자동으로 추가)
                HttpEntity<MultiValueMap<String, Object>> requestEntity = createHttpEntity(imageFile);

                // OCR API 호출
                log.info("OCR API 호출 시작: URL={}, Request Body={}", apiURL, requestEntity);
                ResponseEntity<OcrResponseVo> response = ocrRestTemplate.exchange(
                        apiURL,
                        HttpMethod.POST,
                        requestEntity,
                        OcrResponseVo.class
                );
                // 응답 추가
                log.info("OCR API 호출 성공: Response Body={}", response.getBody());
                responseList.add(response.getBody());
            }
        } catch (Exception e) {
            log.error("OCR API 호출 실패: {}", e.getMessage(), e);
            throw new RuntimeException("OCR API 호출 중 오류 발생", e);
        }

        return responseList;
    }

    private HttpEntity<MultiValueMap<String, Object>> createHttpEntity(File imageFile) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        // 파일 추가
        body.add("file", new FileSystemResource(imageFile));

        // 메시지 추가 (이미지와 관련된 정보 포함)
        body.add("message", buildMessage(imageFile));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        return new HttpEntity<>(body, headers);
    }

    // 메시지 생성 (OCR 요청에 포함될 메시지)
    private String buildMessage(File imageFile) {

        return String.format(
                "{\"version\": \"v1\", \"requestId\": \"%s\", \"timestamp\": %d, \"lang\": \"ko\", \"images\": [{\"format\": \"png\", \"name\": \"%s\"}]}",
                UUID.randomUUID().toString(),
                System.currentTimeMillis(),
                imageFile.getName()
        );
    }
}