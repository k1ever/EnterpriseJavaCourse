package com.mvc.library.repository;

import com.mvc.library.model.BookEntity;
import com.mvc.library.model.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by svoitenko on 20 Nov 2015.
 */

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<UserEntity> getUsers(){
        Query query = entityManager.createQuery("from UserEntity");
        return query.getResultList();
    }

    public UserEntity getUserByLogin(String login) {
        Query query = entityManager.createQuery("from UserEntity where login = :loginParam");
        query.setParameter("loginParam", login);
        UserEntity user = (UserEntity) query.getSingleResult();
        return user;
    }
}
