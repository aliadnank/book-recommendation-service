package com.aliadnan.bookrecommendationservice.controller;

import com.aliadnan.bookrecommendationservice.config.FeedbackTypeEditor;
import com.aliadnan.bookrecommendationservice.domain.Feedback;
import com.aliadnan.bookrecommendationservice.service.FeedbackService;
import com.aliadnan.bookrecommendationservice.util.FeedbackEnum;
import com.aliadnan.bookrecommendationservice.util.PropsUtils;
import com.aliadnan.bookrecommendationservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Ali
 * @createdOn 2018/10/29
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;
    private final PropsUtils propsUtils;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, PropsUtils propsUtils) {
        this.feedbackService = feedbackService;
        this.propsUtils = propsUtils;
    }

    @PostMapping("/post")
    public ResponseEntity<Response<String>> postFeedback(@Valid @ModelAttribute Feedback userFeedback){
        feedbackService.saveUserFeedback(userFeedback);
        Response<String> response = new Response<>(propsUtils.getValue("response.msg.feedback.posted"), Response.Status.SUCCESS);
        return ResponseEntity.ok(response);
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(FeedbackEnum.class, new FeedbackTypeEditor());
    }

}
