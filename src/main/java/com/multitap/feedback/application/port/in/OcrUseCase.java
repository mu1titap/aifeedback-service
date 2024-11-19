package com.multitap.feedback.application.port.in;

import com.multitap.feedback.adaptor.in.vo.OcrRequestVo;
import com.multitap.feedback.adaptor.out.vo.OcrResponseVo;

import java.io.IOException;
import java.util.List;

public interface OcrUseCase {
    List<OcrResponseVo> analyzeImage(OcrRequestVo ocrRequestVo) throws IOException;
}
