package com.multitap.aifeedback.application.port.in;


import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackRecordResponseVo;

public interface KafkaUseCase {
    void sendFeedbackScoreResult(FeedbackRecordResponseVo feedbackRecordResponseVo);
}
