package com.mvc.library.dao;

import com.mvc.library.model.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by svoitenko on 22 Oct 2015.
 */

@Repository
public class BookRepository {

    List<BookEntity> books;

    public BookRepository(){
        this.books = new ArrayList<BookEntity>();

        BookEntity book1 = new BookEntity("Core Java", "Hostmann" );
        BookEntity book2 = new BookEntity("Spring for Dummies", "Kravchenko/Parkhomenko");
        book2.setIsTaken(true);

        books.add(book1);
        books.add(book2);
    }

    public List<BookEntity> getBooks(){
        return books;
    }

    public void addBook(BookEntity book){
        books.add(book);
    }
}
