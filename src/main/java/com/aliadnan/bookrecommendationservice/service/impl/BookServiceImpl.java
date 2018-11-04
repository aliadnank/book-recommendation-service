package com.aliadnan.bookrecommendationservice.service.impl;

import com.aliadnan.bookrecommendationservice.dal.BookRepository;
import com.aliadnan.bookrecommendationservice.domain.Book;
import com.aliadnan.bookrecommendationservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.Optional;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getRecommendations() {
        return bookRepository.findRandomBooks();
    }

    @Override
    public Book insert(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Cacheable(value = "FindBookCache")
    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
