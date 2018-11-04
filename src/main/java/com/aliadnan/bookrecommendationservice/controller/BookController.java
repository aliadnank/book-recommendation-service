package com.aliadnan.bookrecommendationservice.controller;

import com.aliadnan.bookrecommendationservice.domain.Book;
import com.aliadnan.bookrecommendationservice.service.BookService;
import com.aliadnan.bookrecommendationservice.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Controller
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/recommendations")
    public ResponseEntity<Response<List<Book>>> getRecommendations(){
    List<Book> books = bookService.getRecommendations();
    Response<List<Book>> response = new Response<>(books, Response.Status.SUCCESS);
    return ResponseEntity.ok(response);
    }
}
