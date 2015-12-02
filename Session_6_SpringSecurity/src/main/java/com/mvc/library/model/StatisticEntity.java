package com.mvc.library.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by svoitenko on 23 Nov 2015.
 */
@Entity
@Table(name = "statistics")
@NamedQueries({
        @NamedQuery(name = StatisticEntity.USER_REPORT, query =
                "select new com.mvc.library.report.UserReport(b.title, s.takeDate, s.returnDate) " +
                        "from StatisticEntity s, BookEntity b " +
                        "where s.book.id = b.id and s.user.id = :userId " +
                        "order by s.takeDate desc"),
        @NamedQuery(name = StatisticEntity.BOOK_REPORT, query =
                "select new com.mvc.library.report.BookReport(u.firstName, u.lastName, s.takeDate, s.returnDate) " +
                        "from StatisticEntity s, UserEntity u " +
                        "where s.user.id = u.id and s.book.id = :bookId " +
                        "order by s.takeDate desc"),
        @NamedQuery(name = StatisticEntity.MOST_POPULAR_BOOK, query =
                "select s.book from StatisticEntity s " +
                        "group by s.book.id " +
                        "order by count(s) desc")
})
public class StatisticEntity {

    public static final String USER_REPORT = "user_report";
    public static final String BOOK_REPORT = "book_report";
    public static final String MOST_POPULAR_BOOK = "most_popular_book";

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
