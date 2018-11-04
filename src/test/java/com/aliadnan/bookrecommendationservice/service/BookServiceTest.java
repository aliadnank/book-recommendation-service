package com.aliadnan.bookrecommendationservice.service;

import com.aliadnan.bookrecommendationservice.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Ali
 * @createdOn 2018/10/29
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    public BookServiceTest() {
    }
    @Test
    public void testGetRecommendations() {
        List<Book> books = bookService.getRecommendations();
        Assert.assertEquals(20, books.size());
        Book book = books.get(0);
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getAsin());
        Assert.assertNotNull(book.getAuthor());
        Assert.assertNotNull(book.getGenre());
        Assert.assertNotNull(book.getTitle());

    }
}
