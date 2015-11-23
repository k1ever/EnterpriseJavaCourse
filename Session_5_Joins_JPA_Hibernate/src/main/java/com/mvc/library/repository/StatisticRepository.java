package com.mvc.library.repository;

import com.mvc.library.model.BookEntity;
import com.mvc.library.model.StatisticEntity;
import com.mvc.library.model.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by svoitenko on 23 Nov 2015.
 */
@Repository
public class StatisticRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<UserEntity> getStatistics(){
        Query query = entityManager.createQuery("from StatisticEntity");
        return query.getResultList();
    }

    @Transactional
    public void addStatistic(StatisticEntity statistic){
        entityManager.persist(statistic);
        entityManager.flush();
    }

    @Transactional
    public void updateStatistic(StatisticEntity statistic){
        entityManager.merge(statistic);
    }

    public StatisticEntity getStatisticRecordByIds(BookEntity book){
        Query query = entityManager.createQuery("from StatisticEntity where s.book_id = :bookId and s.user_id = :userId" +
                " and s.returned_date = :returnDate");
        query.setParameter("bookId", book.getId());
        query.setParameter("userId", book.getUser().getId());
        query.setParameter("returnDate", null);

        List<StatisticEntity> statisticEntities = query.getResultList();
        if (statisticEntities.isEmpty()) {
            return null;
        }

        return statisticEntities.get(0);
    }

}
