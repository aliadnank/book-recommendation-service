package com.aliadnan.bookrecommendationservice.controller;

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
 * @createdOn 2018/11/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegister() throws Exception {
        mockMvc.perform(post("/users/register").param("userName","Test").param("password","Test"))
                .andExpect(status().isOk()).andExpect(content().string(containsString("User registered Successfully")));
    }

    @Test
    public void testLogin() throws Exception {
        testRegister();
        mockMvc.perform(post("/users/login").param("userName","Test").param("password","Test"))
                .andExpect(status().isOk()).andExpect(content().string(containsString("Logged in Successfully")));
    }
}
