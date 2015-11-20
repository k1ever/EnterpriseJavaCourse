package com.mvc.library.model;

import javax.persistence.*;

/**
 * Created by svoitenko on 28 Oct 2015.
 */
@Entity
@Table(name = "books", schema = "", catalog = "library")
public class BookEntity {


    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String author;

    private String status;

    @ManyToOne
    private UserEntity user;

    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }

}
