package com.aliadnan.bookrecommendationservice.controller;

import com.aliadnan.bookrecommendationservice.domain.User;
import com.aliadnan.bookrecommendationservice.service.UserService;
import com.aliadnan.bookrecommendationservice.util.PropsUtils;
import com.aliadnan.bookrecommendationservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PropsUtils propsUtils;

    @Autowired
    public UserController(UserService userService, PropsUtils propsUtils) {
        this.userService = userService;
        this.propsUtils = propsUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<Response<String>> loginUser(@Valid @ModelAttribute User user){
    userService.authenticate(user);
    Response<String> response = new Response<>(propsUtils.getValue("response.msg.logged.in"), Response.Status.SUCCESS);
    return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Response<String>> registerUser(@Valid @ModelAttribute User user){
        User registeredUser = userService.register(user);
        Response<String> response = new Response<>(String.format(propsUtils.getValue("response.msg.user.registered"),registeredUser.getId()), Response.Status.SUCCESS);
        return ResponseEntity.ok(response);
    }
}
