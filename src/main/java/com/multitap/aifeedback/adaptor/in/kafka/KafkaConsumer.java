package com.multitap.aifeedback.adaptor.in.kafka;


import com.multitap.aifeedback.adaptor.in.kafka.messagein.FeedbackScorePromptDto;
import com.multitap.aifeedback.adaptor.out.gpt.vo.FeedbackRecordResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.KafkaUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.CombinedPromptRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private final GptUseCase gptUseCase;
    private final KafkaUseCase kafkaUseCase;

    @KafkaListener(topics = "create-category-prompt-topic", groupId = "feedback-consumer-group", containerFactory = "feedbackScorePromptDtoListener")
    public void processFeedbackScorePrompt(FeedbackScorePromptDto feedbackScorePromptDto) {
        // gpt 피드백 요청
        Object gptResponseVo = gptUseCase.sendFeedbackRequestToGpt(CombinedPromptRequestDto.of(feedbackScorePromptDto.getFeedbackScoreDto(),feedbackScorePromptDto.getPromptDetails()));

        //kafka topic 발행
        kafkaUseCase.sendFeedbackScoreResult(FeedbackRecordResponseVo.from(feedbackScorePromptDto.getFeedbackScoreDto().getUuid(), feedbackScorePromptDto.getFeedbackScoreDto().getCategoryCode(),gptResponseVo));
    }
}
