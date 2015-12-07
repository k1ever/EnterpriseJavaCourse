package com.mvc.library.service;

import com.mvc.library.model.UserEntity;
import com.mvc.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by svoitenko on 20 Nov 2015.
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getUsersMap() {
        List<UserEntity> users = userRepository.getUsers();

        Map<String, String> usersMap = new HashMap<String, String>();
        for (UserEntity user : users) {
            String id = String.valueOf(user.getId());
            String name = user.getFirstName() + " " + user.getLastName();
            usersMap.put(id, name);
        }

        return usersMap;
    }

    private String getCurrentUserLogin(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public UserEntity getCurrentUser(){
        String login = getCurrentUserLogin();
        UserEntity user = userRepository.getUserByLogin(login);
        return user;
    }


}
