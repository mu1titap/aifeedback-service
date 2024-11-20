package com.multitap.feedback.application.mapper;

import com.multitap.feedback.application.port.in.dto.in.OcrImageDto;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class OcrDtoMapper {

    public static OcrImageDto from(List<File> imageFiles) {
        return OcrImageDto.builder()
                .imageFiles(imageFiles)
                .build();
    }

}
