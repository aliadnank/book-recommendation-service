package com.aliadnan.bookrecommendationservice.service.impl;

import com.aliadnan.bookrecommendationservice.dal.FeedbackRepository;
import com.aliadnan.bookrecommendationservice.domain.Feedback;
import com.aliadnan.bookrecommendationservice.service.BookService;
import com.aliadnan.bookrecommendationservice.service.FeedbackService;
import com.aliadnan.bookrecommendationservice.service.UserService;
import com.aliadnan.bookrecommendationservice.util.PropsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ali
 * @createdOn 2018/10/29
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserService userService;
    private final BookService bookService;
    private final PropsUtils propsUtils;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, UserService userService, BookService bookService,
                               PropsUtils propsUtils) {
        this.feedbackRepository = feedbackRepository;
        this.userService = userService;
        this.bookService = bookService;
        this.propsUtils = propsUtils;
    }

    @Override
    public Feedback saveUserFeedback(Feedback feedback) {
        if(!userService.isUserExists(feedback.getUserId())){
            throw new RuntimeException(propsUtils.getValue("error.msg.userid.not.found"));
        }
        if(!bookService.findById(feedback.getBookId()).isPresent()){
            throw new RuntimeException(propsUtils.getValue("error.msg.book.not.found"));
        }
        return feedbackRepository.save(feedback);
    }
}
