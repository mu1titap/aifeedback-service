package com.multitap.feedback.application.port.in.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;


@Getter
@NoArgsConstructor
public class OcrImageDto {
    private List<File> imageFiles;

    @Builder
    public OcrImageDto(List<File> imageFiles) {
        this.imageFiles = imageFiles;
    }

}
