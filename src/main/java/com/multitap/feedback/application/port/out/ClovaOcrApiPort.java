package com.multitap.feedback.application.port.out;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;
import org.springframework.stereotype.Component;

@Component
public interface ClovaOcrApiPort {

    OcrResponseVo callClovarOcrApi(OcrRequestVo ocrRequestVo);
}
