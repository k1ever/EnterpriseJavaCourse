package com.mvc.library.report;

import java.util.Date;

/**
 * Created by svoitenko on 25 Nov 2015.
 */
public class BookReport {

    private String userFirstName;
    private String userLastName;
    private Date takenDate;
    private Date returnedDate;

    public BookReport(String userFirstName, String userLastName, Date takenDate, Date returnedDate) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.takenDate = takenDate;
        this.returnedDate = returnedDate;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
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
