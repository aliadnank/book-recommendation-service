package com.aliadnan.bookrecommendationservice.dal;

import com.aliadnan.bookrecommendationservice.domain.Feedback;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
}
