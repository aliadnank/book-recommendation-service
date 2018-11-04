package com.aliadnan.bookrecommendationservice.service;

import com.aliadnan.bookrecommendationservice.domain.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
public interface BookService {
    List<Book> getRecommendations();

    Book insert(Book book);

    Optional<Book> findById(Long bookId);
}
