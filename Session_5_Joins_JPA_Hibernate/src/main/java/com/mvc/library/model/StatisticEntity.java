package com.mvc.library.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by svoitenko on 23 Nov 2015.
 */
@Entity
@Table(name = "statistics")
public class StatisticEntity {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private BookEntity book;

    @Column(name="taken_date")
    private Date takeDate;

    @Column(name="returned_date")
    private Date returnDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
