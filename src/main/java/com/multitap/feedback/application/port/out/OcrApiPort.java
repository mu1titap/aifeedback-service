package com.multitap.feedback.application.port.out;
import com.multitap.feedback.application.port.in.dto.in.OcrInputImageDto;
import com.multitap.feedback.application.port.in.dto.out.OcrResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface OcrApiPort {

    List<OcrResponseDto> callOcrApi(OcrInputImageDto ocrInputImageDto);
}