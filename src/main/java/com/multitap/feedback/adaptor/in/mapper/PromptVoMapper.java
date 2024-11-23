package com.multitap.feedback.adaptor.in.mapper;

import com.multitap.feedback.application.port.in.dto.in.RetrievePromptRequestVo;
import org.springframework.stereotype.Component;

@Component
public class PromptVoMapper {

    public static RetrievePromptRequestVo from(String industryType, String documentType) {
        return RetrievePromptRequestVo.builder()
                .industryType(industryType)
                .documentType(documentType)
                .build();

    }

}
