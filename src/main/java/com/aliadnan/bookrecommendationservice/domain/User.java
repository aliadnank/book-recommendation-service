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
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull(message = "field.null.message")
    private String userName;
    @NotNull(message = "field.null.message")
    private String password;

    public User(@NotNull String userName, @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
