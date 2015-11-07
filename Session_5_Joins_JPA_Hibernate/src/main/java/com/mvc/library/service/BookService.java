package com.mvc.library.service;

import com.mvc.library.model.BookEntity;
import com.mvc.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Klever on 07.11.15.
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getBooksList(){
        return bookRepository.getBooksList();
    }
    @Transactional
    public void addBook(BookEntity book) {
        bookRepository.addBook(book);
    }

    @Transactional
    public void takeBook(int id, String holder){
        bookRepository.takeBook(id, holder);
    }

    @Transactional
    public void returnBook(int id) {
        bookRepository.returnBook(id);
    }
}
