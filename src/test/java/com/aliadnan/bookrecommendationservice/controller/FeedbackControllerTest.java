package com.aliadnan.bookrecommendationservice.controller;

import com.aliadnan.bookrecommendationservice.domain.User;
import com.aliadnan.bookrecommendationservice.service.UserService;
import com.aliadnan.bookrecommendationservice.util.BooksLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ali
 * @createdOn 2018/11/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BooksLoader booksLoader;
    @Autowired
    private UserService userService;

    private User registeredUser;


    @Before
    public void setUp() throws Exception {
        booksLoader.loadBooks();
        User user = new User("Test","Test");
        registeredUser = userService.register(user);
    }

    @Test
    public void testFeedback() throws Exception {
        Assert.assertNotNull(registeredUser);
        mockMvc.perform(post("/feedback/post").param("userId",String.valueOf(registeredUser.getId())).
                param("bookId","123").param("message","LIKED"))
                .andExpect(status().isOk()).andExpect(content().string(containsString("Feedback Posted Successfully")));
    }

}
