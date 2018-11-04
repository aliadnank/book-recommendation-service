package com.aliadnan.bookrecommendationservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "field.null.message")
    private String title;
    @NotNull(message = "field.null.message")
    private String author;
    @NotNull(message = "field.null.message")
    private String asin;
    @NotNull(message = "field.null.message")
    private String genre;

    public Book(@NotNull String title, @NotNull String author, @NotNull String asin, @NotNull String genre) {
        this.title = title;
        this.author = author;
        this.asin = asin;
        this.genre = genre;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
