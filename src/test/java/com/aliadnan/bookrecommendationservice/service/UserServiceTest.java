package com.aliadnan.bookrecommendationservice.service;

import com.aliadnan.bookrecommendationservice.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ali
 * @createdOn 2018/10/29
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User newUser = new User("Test", "Test");
        User registeredUser = userService.register(newUser);
        Assert.assertNotNull(registeredUser);
    }

    @Test(expected = RuntimeException.class)
    public void testLoginInvalidDetails() {
        User user = new User("Test1", "Test1");
        User loggedinUser = userService.authenticate(user);
        Assert.assertNotNull(loggedinUser);
    }
}
