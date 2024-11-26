package com.multitap.aifeedback.application.port.in.dto.in;

import com.multitap.aifeedback.adaptor.out.prompt.vo.PromptDetailsResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CombinedPromptRequestDto {

    private Object request;
    private PromptDetailsResponseVo promptDetails;

    @Builder
    public CombinedPromptRequestDto(Object request, PromptDetailsResponseVo promptDetails) {
        this.request = request;
        this.promptDetails = promptDetails;
    }

    public static CombinedPromptRequestDto of(Object request, PromptDetailsResponseVo promptDetailsResponseVo) {
        return CombinedPromptRequestDto.builder()
                .request(request)
                .promptDetails(promptDetailsResponseVo)
                .build();
    }
}
