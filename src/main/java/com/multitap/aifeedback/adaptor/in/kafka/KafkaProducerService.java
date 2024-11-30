package com.multitap.aifeedback.adaptor.in.kafka;

import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;

public interface KafkaProducerService {
    void sendFeedbackScoreGptResponse(GptResponseVo gptResponseVo);
}
