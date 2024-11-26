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
        try {
            // content가 null이거나 빈 문자열인 경우 처리
            if (content == null || content.trim().isEmpty()) {
                return GptResponseVo.builder()
                        .improvements("")
                        .strengths("")
                        .build();
            }

            String improvements = extractContent(content, "개선할 점:", "장점:");
            String strengths = extractContent(content, "장점:", null);

            return GptResponseVo.builder()
                    .improvements(improvements)
                    .strengths(strengths)
                    .build();
        } catch (Exception e) {
            // 파싱 실패시 빈 문자열 반환
            return GptResponseVo.builder()
                    .improvements("")
                    .strengths("")
                    .build();
        }
    }

    private static String extractContent(String content, String startMarker, String endMarker) {
        try {
            int startIdx = content.indexOf(startMarker);
            if (startIdx == -1) {
                return ""; // 시작 마커를 찾지 못한 경우
            }

            startIdx += startMarker.length();

            int endIdx;
            if (endMarker == null) {
                endIdx = content.length();
            } else {
                endIdx = content.indexOf(endMarker, startIdx);
                if (endIdx == -1) {
                    endIdx = content.length();
                }
            }

            if (startIdx >= endIdx) {
                return ""; // 유효하지 않은 인덱스 범위
            }

            return content.substring(startIdx, endIdx)
                    .replaceAll("\n", " ")  // 개행문자 제거
                    .replaceAll("- ", "")   // 불렛 포인트 제거
                    .trim();
        } catch (Exception e) {
            return ""; // 예외 발생시 빈 문자열 반환
        }
    }
}