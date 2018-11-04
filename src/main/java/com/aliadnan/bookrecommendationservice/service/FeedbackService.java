package com.aliadnan.bookrecommendationservice.service;

import com.aliadnan.bookrecommendationservice.domain.Feedback;

/**
 * @author Ali
 * @createdOn 2018/10/29
 */
public interface FeedbackService {
    Feedback saveUserFeedback(Feedback feedback);
}
