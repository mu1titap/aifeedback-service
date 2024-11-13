package com.multitap.aifeedback.application.port.in;

import com.multitap.aifeedback.application.port.dto.PdfDocument;

public interface OcrUseCase {

    String textFromPdf(PdfDocument pdf);


}
