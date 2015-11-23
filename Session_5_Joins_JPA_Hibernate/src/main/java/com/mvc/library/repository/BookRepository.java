package com.mvc.library.repository;

import com.mvc.library.model.BookEntity;
import com.mvc.library.model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by svoitenko on 28 Oct 2015.
 */
@Repository
public class BookRepository {

    private static final String BOOK_STATUS_TAKEN = "taken";
    private static final String BOOK_STATUS_FREE = "";

    @PersistenceContext(name = "NewPersistenceUnit")
    private EntityManager entityManager;

    public List<BookEntity> getBooksList() {
        Query query = entityManager.createQuery("from BookEntity");
        return query.getResultList();
    }

    @Transactional
    public void addBook(BookEntity book){
        entityManager.persist(book);
        entityManager.flush();
    }

    public BookEntity getBookById(int id){
        BookEntity book = entityManager.find(BookEntity.class, id);
        return book;
    }

    @Transactional
    public void setTaken(BookEntity book) {
        book.setStatus(BOOK_STATUS_TAKEN);
        entityManager.merge(book);
    }

    @Transactional
    public void setFree(BookEntity book) {
        book.setStatus(BOOK_STATUS_FREE);
        book.setUser(null);
        entityManager.merge(book);
    }
}











