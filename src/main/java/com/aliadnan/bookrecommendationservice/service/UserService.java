package com.aliadnan.bookrecommendationservice.service;

import com.aliadnan.bookrecommendationservice.domain.User;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
public interface UserService {
    User authenticate(User user);

    User register(User user);

    Boolean isUserExists(Long userId);
}
