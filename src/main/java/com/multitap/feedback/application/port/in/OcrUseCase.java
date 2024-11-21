package com.multitap.feedback.application.port.in;

import com.multitap.feedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.feedback.application.port.in.dto.in.OcrRequestDto;

import java.io.IOException;

public interface OcrUseCase {
    OcrProcessedFeedbackRequest uploadPdfForOcr (OcrRequestDto ocrRequestDto) throws IOException;
}
