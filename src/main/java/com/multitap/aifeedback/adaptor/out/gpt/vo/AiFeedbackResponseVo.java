package com.multitap.aifeedback.adaptor.out.gpt.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AiFeedbackResponseVo {

    private String improvements;
    private String strengths;

    @Builder
    public AiFeedbackResponseVo(String improvements, String strengths) {
        this.improvements = improvements;
        this.strengths = strengths;
    }

    public static AiFeedbackResponseVo from(String content) {
        try {
            if (content == null || content.trim().isEmpty()) {
                return createEmptyResponse();
            }

            // 문자열 정규화: 여러 줄바꿈을 단일 줄바꿈으로 변환
            content = content.replaceAll("\\n+", "\n").trim();

            // 개선할 점과 장점 섹션 추출
            String improvements = extractSection(content, "개선할 점:", "장점:");
            String strengths = extractSection(content, "장점:", null);

            return AiFeedbackResponseVo.builder()
                    .improvements(improvements)
                    .strengths(strengths)
                    .build();
        } catch (Exception e) {
            return createEmptyResponse();
        }
    }

    private static String extractSection(String content, String startMarker, String endMarker) {
        try {
            // 1. 시작 위치 찾기
            int startIdx = content.indexOf(startMarker);
            if (startIdx == -1) {
                return "";
            }
            startIdx += startMarker.length();

            // 2. 끝 위치 찾기
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
                return "";
            }

            // 3. 내용 추출 및 정제
            String extractedContent = content.substring(startIdx, endIdx).trim();

            // 4. 텍스트 정제
            return cleanText(extractedContent);
        } catch (Exception e) {
            return "";
        }
    }

    private static String cleanText(String text) {
        return text
                .replaceAll("(?m)^\\s*-\\s*", "") // 줄 시작 부분의 불렛 포인트 제거
                .replaceAll("\\n\\s*", " ") // 줄바꿈과 그 뒤의 공백 제거
                .replaceAll("\\s+", " ") // 연속된 공백을 하나로 통합
                .trim();
    }

    private static AiFeedbackResponseVo createEmptyResponse() {
        return AiFeedbackResponseVo.builder()
                .improvements("")
                .strengths("")
                .build();
    }
}