package com.multitap.aifeedback.application.service;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackRecordResponseVo;
import com.multitap.aifeedback.application.port.in.KafkaUseCase;
import com.multitap.aifeedback.application.port.out.KafkaPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService implements KafkaUseCase {

    private final KafkaPort kafkaPort;

    @Override
    public void sendFeedbackScoreResult(FeedbackRecordResponseVo feedbackRecordResponseVo) {
        kafkaPort.sendFeedbackRecordGptResponse(feedbackRecordResponseVo);
    }
}
