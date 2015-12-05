package com.mvc.library.service;

import com.mvc.library.model.BookEntity;
import com.mvc.library.model.UserEntity;
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

    @Autowired
    private UserService userService;

    @Autowired
    StatisticService statisticService;

    public List<BookEntity> getBooksList(){
        return bookRepository.getBooksList();
    }
    public BookEntity getBookById(int id){
        return bookRepository.getBookById(id);
    }

    @Transactional
    public void addBook(BookEntity book) {
        bookRepository.addBook(book);
    }

    @Transactional
    public void setTaken(BookEntity book) {
        book.setUser(userService.getCurrentUser());
        bookRepository.setTaken(book);
        statisticService.setTaken(book);
    }

    @Transactional
    public void setFree(BookEntity book) {
        statisticService.setReturnDate(book);
        bookRepository.setFree(book);
    }

    @Transactional
    public void updateBook(BookEntity newBook) {
        BookEntity oldBook = getBookById(newBook.getId());
        boolean isStatusChanged = !newBook.getStatus().equals(oldBook.getStatus());

        if (isStatusChanged){
            if (newBook.getStatus().equals("taken")){
                statisticService.setTaken(newBook);
            } else {
                statisticService.setReturnDate(oldBook);
            }
        } else {
            if (newBook.getStatus().equals("taken") && newBook.getUser().getId() != oldBook.getUser().getId()){
                statisticService.setReturnDate(oldBook);
                statisticService.setTaken(newBook);
            }
        }

        bookRepository.updateBook(newBook);
    }

    @Transactional
    public void deleteBook(int bookId){
        bookRepository.deleteBook(bookId);
    }
}
