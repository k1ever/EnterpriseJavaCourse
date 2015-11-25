package com.mvc.library.report;

import java.util.Date;

/**
 * Created by svoitenko on 25 Nov 2015.
 */
public class UserReport {

    private String bookTitle;
    private Date takenDate;
    private Date returnedDate;

    public UserReport(String bookTitle, Date takenDate, Date returnedDate) {

        this.bookTitle = bookTitle;
        this.takenDate = takenDate;
        this.returnedDate = returnedDate;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takenDate) {
        this.takenDate = takenDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

}
