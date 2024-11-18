package com.multitap.feedback.application.port.in;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;

public interface OcrUseCase {
    OcrResponseVo analyzeImage(OcrRequestVo ocrRequestVo);

}
