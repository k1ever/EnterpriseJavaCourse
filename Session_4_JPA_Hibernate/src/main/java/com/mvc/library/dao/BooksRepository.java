package com.mvc.library.dao;

import com.mvc.library.model.BooksEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by svoitenko on 28 Oct 2015.
 */
@Repository
public class BooksRepository {

    @PersistenceContext(name = "NewPersistenceUnit")
    private EntityManager entityManager;

    @Transactional
    public List<BooksEntity> getBooksList() {
        return entityManager.createQuery("from BooksEntity ").getResultList();
    }

    @Transactional
    public void addBook(String title, String author){
        BooksEntity book = new BooksEntity();
        book.setTitle(title);
        book.setAuthor(author);
        entityManager.persist(book);
    }

    @Transactional
    public void takeBook(int id, String holderName){
        BooksEntity book = entityManager.find(BooksEntity.class, id);
        book.setStatus("taken");
        book.setHolder(holderName);
        entityManager.merge(book);
    }

    @Transactional
    public void returnBook(int id){
        BooksEntity book = entityManager.find(BooksEntity.class, id);
        book.setStatus("");
        book.setHolder("");
        entityManager.merge(book);
    }

}











