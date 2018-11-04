package com.aliadnan.bookrecommendationservice.domain;

import com.aliadnan.bookrecommendationservice.util.FeedbackEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Ali
 * @createdOn 2018/10/28
 */
@Entity
public class Feedback {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "field.null.message")
    private Long userId;
    @NotNull(message = "field.null.message")
    private Long bookId;
    @NotNull(message = "field.null.message")
    @Enumerated(EnumType.STRING)
    private FeedbackEnum message;

    public Feedback(@NotNull(message = "field.null.message") Long userId,
                    @NotNull(message = "field.null.message") Long bookId,
                    @NotNull(message = "field.null.message") FeedbackEnum message) {
        this.userId = userId;
        this.bookId = bookId;
        this.message = message;
    }

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public FeedbackEnum getMessage() {
        return message;
    }

    public void setMessage(FeedbackEnum message) {
        this.message = message;
    }
}
