package com.multitap.aifeedback.application.service;

import com.multitap.aifeedback.adaptor.out.gpt.vo.GptResponseVo;
import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import com.multitap.aifeedback.application.port.in.GptUseCase;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.application.port.in.dto.in.TextRequestDto;
import com.multitap.aifeedback.application.port.out.GptApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GptService implements GptUseCase {

    private final GptApiPort gptApiPort;

    @Override
    public GptResponseVo sendFeedbackRequestToOcr(OcrProcessedFeedbackRequest ocrProcessedFeedbackRequest, PromptDetailsResponseVo promptDetailsResponseVo) {
        return gptApiPort.callGptApi(ocrProcessedFeedbackRequest, promptDetailsResponseVo);
    }

    //todo: 공통직인 callGptApi 에 파라미터 객체를 새로 만들어서 사용하는 방식으로 코드 수정 필요함
    @Override
    public GptResponseVo sendFeedbackRequestToText(TextRequestDto textRequestDto) {
        return gptApiPort.callGptApit(textRequestDto);
    }


}
