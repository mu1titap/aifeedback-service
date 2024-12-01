package com.multitap.aifeedback.adaptor.out.gpt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackRecordResponseVo {

    private String uuid;
    private String categoryCode;
    private Object content;

    @Builder
    public FeedbackRecordResponseVo(String uuid, String categoryCode, Object content) {
        this.uuid = uuid;
        this.categoryCode = categoryCode;
        this.content = content;
    }

    public static FeedbackRecordResponseVo from(String uuid, String categoryCode, Object content) {
        return FeedbackRecordResponseVo.builder()
                .uuid(uuid)
                .categoryCode(categoryCode)
                .content(content)
                .build();
    }
}
