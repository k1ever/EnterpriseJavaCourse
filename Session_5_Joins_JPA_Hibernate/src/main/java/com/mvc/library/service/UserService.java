package com.mvc.library.service;

import com.mvc.library.model.UserEntity;
import com.mvc.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by svoitenko on 20 Nov 2015.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getUsers(){
        return userRepository.getUsers();
    }
}
