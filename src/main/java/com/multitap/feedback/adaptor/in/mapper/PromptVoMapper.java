package com.multitap.feedback.adaptor.in.mapper;

import com.multitap.feedback.adaptor.in.vo.PromptRequestVo;
import com.multitap.feedback.application.port.in.dto.in.PromptRequestDto;
import org.springframework.stereotype.Component;

@Component
public class PromptVoMapper {

    public static PromptRequestDto from(PromptRequestVo promptRequestVo) {
        return PromptRequestDto.builder()
                .industry(promptRequestVo.getIndustry())
                .documentType(promptRequestVo.getDocumentType())
                .build();

    }

}
