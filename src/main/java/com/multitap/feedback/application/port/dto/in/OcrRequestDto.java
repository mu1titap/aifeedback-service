package com.multitap.feedback.application.port.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;


@Getter
@NoArgsConstructor
public class OcrRequestDto {
    private String requestId;
    private String lang;
    private String imageName;
    private List<File> imageFiles;

    @Builder
    public OcrRequestDto(String requestId, String lang, String imageName, List<File> imageFiles) {
        this.requestId = requestId;
        this.lang = lang;
        this.imageName = imageName;
        this.imageFiles = imageFiles;
    }

    public static OcrRequestDto from(List<File> imageFiles) {
        return OcrRequestDto.builder()
               .requestId(builder().requestId)
               .lang(builder().lang)
               .imageFiles(imageFiles)
               .build();
    }
}
