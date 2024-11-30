package com.multitap.aifeedback.adaptor.in.kafka;


import com.multitap.aifeedback.adaptor.in.kafka.messagein.FeedbackScorePromptDto;
import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
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

    @KafkaListener(topics = "create-category-prompt-topic", groupId = "feedback-consumer-group", containerFactory = "feedbackScorePromptDtoListener")
    public void processFeedbackScorePrompt(FeedbackScorePromptDto feedbackScorePromptDto) {
        log.info("Received feedbackPromptDto :{}", feedbackScorePromptDto.getFeedbackScoreDto().getUuid());
        Object gptResponseVo = gptUseCase.sendFeedbackRequestToGpt(CombinedPromptRequestDto.of(feedbackScorePromptDto.getFeedbackScoreDto(),feedbackScorePromptDto.getPromptDetails()));

    }

}
