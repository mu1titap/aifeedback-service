package com.multitap.aifeedback.adaptor.out.gpt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GptResponseVo {

    private String improvements;
    private String strengths;

    @Builder
    public GptResponseVo(String improvements, String strengths) {
        this.improvements = improvements;
        this.strengths = strengths;
    }

    public static GptResponseVo from(String content) {

        String improvements = extractContent(content, "개선할 점:", "장점:");
        String strengths = extractContent(content, "장점:", null);

        return GptResponseVo.builder()
                .improvements(improvements)
                .strengths(strengths)
                .build();
    }

    private static String extractContent(String content, String startMarker, String endMarker) {
        int startIndex = content.indexOf(startMarker) + startMarker.length();
        int endIndex = endMarker != null ? content.indexOf(endMarker) : content.length();

        return content.substring(startIndex, endIndex)
                .replaceAll("\n", " ")  // 개행문자 제거
                .replaceAll("- ", "")   // 불렛 포인트 제거
                .trim();

    }
}


