package com.mvc.library.model;

/**
 * Created by svoitenko on 22 Oct 2015.
 */
public class BookEntity {

    private String title;
    private String author;
    private String holder;
    private boolean isTaken;

    public BookEntity(){
        this.title = "";
        this.author = "";
        this.holder = "";
        this.isTaken = false;
    }

    public BookEntity(String title, String author){
        this();
        this.title = title;
        this.author = author;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
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

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

}
