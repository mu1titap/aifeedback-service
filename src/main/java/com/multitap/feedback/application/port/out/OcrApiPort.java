package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import com.multitap.feedback.application.port.dto.in.OcrRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OcrApiPort {

    List<OcrResponseVo> callOcrApi(OcrRequestDto ocrRequestDto);
}
