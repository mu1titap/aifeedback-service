package com.multitap.aifeedback.adaptor.out.Kafka;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackRecordResponseVo;
import com.multitap.aifeedback.application.port.out.KafkaPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaAdapter implements KafkaPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendFeedbackRecordGptResponse(FeedbackRecordResponseVo feedbackRecordResponseVo) {
        try {
            kafkaTemplate.send("create-feedback-record-gpt-topic", feedbackRecordResponseVo);
        } catch (Exception e) {
            log.info("create feedback record gpt event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }
}
