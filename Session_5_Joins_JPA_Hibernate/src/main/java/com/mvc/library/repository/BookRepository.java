package com.mvc.library.repository;

import com.mvc.library.model.BookEntity;
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

    @Transactional
    public void takeBook(int id, String holder){
        BookEntity book = entityManager.find(BookEntity.class, id);
        book.setStatus("taken");
        book.setHolder(holder);
    }

    @Transactional
    public void returnBook(int id){
        BookEntity book = entityManager.find(BookEntity.class, id);
        book.setStatus("");
        book.setHolder("");
    }

}











