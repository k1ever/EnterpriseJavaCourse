package com.mvc.library.repository;

import com.mvc.library.model.BookEntity;
import com.mvc.library.model.StatisticEntity;
import com.mvc.library.model.UserEntity;
import com.mvc.library.report.BookReport;
import com.mvc.library.report.UserReport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by svoitenko on 23 Nov 2015.
 */
@Repository
public class StatisticRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<StatisticEntity> getStatistics(){
        Query query = entityManager.createQuery("from StatisticEntity");
        return query.getResultList();
    }

    @Transactional
    public void addStatistic(StatisticEntity statistic){
        entityManager.persist(statistic);
        entityManager.flush();
    }

    @Transactional
    public void setReturnDate(BookEntity book){

        Query query = entityManager.createQuery("update StatisticEntity " +
                "set returnDate = :date " +
                "where book = :bookId and user = :userId and returnDate is null");

        query.setParameter("date", new Date());
        query.setParameter("bookId", book);
        query.setParameter("userId", book.getUser());

        query.executeUpdate();
        
    }

    public List<UserReport> getUserReport(int userId){
        Query query = entityManager.createNamedQuery(StatisticEntity.USER_REPORT);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    public List<BookReport> getBookReport(int bookId){
        Query query = entityManager.createNamedQuery(StatisticEntity.BOOK_REPORT);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    public BookEntity getMostPopularBook(){
        Query query = entityManager.createNamedQuery(StatisticEntity.MOST_POPULAR_BOOK);
        query.setMaxResults(1);
        if (query.getResultList().isEmpty()){
            return null;
        }
        return (BookEntity) query.getSingleResult();
    }


}
