package com.multitap.aifeedback.adaptor.in.kafka;

import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService{

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendFeedbackScoreGptResponse(GptResponseVo gptResponseVo) {
        try {
            kafkaTemplate.send("create-feedback-score-gpt-topic", gptResponseVo);
        } catch (Exception e) {
            log.info("create feedback score gpt event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }
}
