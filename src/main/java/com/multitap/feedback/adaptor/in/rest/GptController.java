//package com.multitap.feedback.adaptor.in.rest;
//
//import com.multitap.feedback.adaptor.in.vo.GptRequestVo;
//import com.multitap.feedback.adaptor.out.gpt.dto.GptResponseVo;
//import com.multitap.feedback.application.port.in.GptUseCase;
//import com.multitap.feedback.common.response.BaseResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/feedback")
//@RequiredArgsConstructor
//@Slf4j
//public class GptController {
//
//    private final GptUseCase gptUseCase;
//
//    @GetMapping("/gpt")
//    public BaseResponse<GptResponseVo> chat(@RequestParam(name = "prompt") String prompt) {
//        log.info("GPT API 호출 : {}", prompt);
//        return new BaseResponse<>(gptUseCase.sendFeedbackRequestToPort());
//    }
//
//
//}
