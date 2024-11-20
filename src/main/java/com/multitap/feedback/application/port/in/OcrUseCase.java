package com.multitap.feedback.application.port.in;

import com.multitap.feedback.application.port.in.dto.in.OcrRequestDto;
import com.multitap.feedback.application.port.in.dto.out.OcrResponseDto;

import java.io.IOException;
import java.util.List;

public interface OcrUseCase {
    List<OcrResponseDto> analyzeImage(OcrRequestDto ocrRequestDto) throws IOException;
}
