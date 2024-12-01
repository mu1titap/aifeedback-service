package com.multitap.aifeedback.application.port.out;

import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackRecordResponseVo;
import org.springframework.stereotype.Component;

@Component
public interface KafkaPort {

    void sendFeedbackRecordGptResponse(FeedbackRecordResponseVo feedbackRecordResponseVo);
}
