package com.aliadnan.bookrecommendationservice.service.impl;

import com.aliadnan.bookrecommendationservice.dal.UserRepository;
import com.aliadnan.bookrecommendationservice.domain.User;
import com.aliadnan.bookrecommendationservice.service.UserService;
import com.aliadnan.bookrecommendationservice.util.PropsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PropsUtils propsUtils;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PropsUtils propsUtils) {
        this.userRepository = userRepository;
        this.propsUtils = propsUtils;
    }

    @Override
    public User authenticate(User provided) {
        User user = userRepository.findByUserNameAndPassword(provided.getUserName(),provided.getPassword());
        if(Objects.isNull(user)){
            throw new RuntimeException(propsUtils.getValue("error.msg.invalid.username.password"));
        }
        return user;
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean isUserExists(Long userId) {
        return userRepository.findById(userId).isPresent();
    }
}
