package com.mvc.library.repository;

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

    public UserEntity getUserById(int id){
        UserEntity user = entityManager.find(UserEntity.class, id);
        return user;
    }
}
