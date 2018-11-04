package com.aliadnan.bookrecommendationservice.dal;

import com.aliadnan.bookrecommendationservice.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);
}
