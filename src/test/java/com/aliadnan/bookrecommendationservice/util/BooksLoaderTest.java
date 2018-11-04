package com.aliadnan.bookrecommendationservice.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * @author Ali
 * @createdOn 2018/10/29
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BooksLoaderTest {

    @Autowired
    private BooksLoader booksLoader;

    @Test
    public void testLoad() {
        booksLoader.loadBooks();
        Assert.assertEquals(Optional.of(2198), Optional.of(booksLoader.getTotalRecords()));
    }
}
