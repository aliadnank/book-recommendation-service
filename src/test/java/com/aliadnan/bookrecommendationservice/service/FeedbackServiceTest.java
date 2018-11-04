package com.aliadnan.bookrecommendationservice.service;

import com.aliadnan.bookrecommendationservice.domain.Feedback;
import com.aliadnan.bookrecommendationservice.domain.User;
import com.aliadnan.bookrecommendationservice.util.BooksLoader;
import com.aliadnan.bookrecommendationservice.util.FeedbackEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ali
 * @createdOn 2018/11/1
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FeedbackServiceTest {

    @Autowired
    private BooksLoader booksLoader;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private  UserService userService;

    public FeedbackServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
    booksLoader.loadBooks();
    }

    @Test(expected = RuntimeException.class)
    public void withoutValidUser() {
        Feedback feedback = new Feedback(1255L,123L, FeedbackEnum.LIKED);
        feedbackService.saveUserFeedback(feedback);
    }

    @Test(expected = RuntimeException.class)
    public void withInvalidBook() {
        User user = new User("Test","Test");
        User registeredUser = userService.register(user);
        Feedback feedback = new Feedback(registeredUser.getId(),234444L, FeedbackEnum.LIKED);
        feedbackService.saveUserFeedback(feedback);
    }

    @Test
    public void testFeedback() {
        User user = new User("Test","Test");
        User registeredUser = userService.register(user);
        Feedback feedback = new Feedback(registeredUser.getId(),123L, FeedbackEnum.LIKED);
        feedbackService.saveUserFeedback(feedback);
    }
}
