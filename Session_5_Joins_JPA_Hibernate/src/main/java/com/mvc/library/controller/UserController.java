package com.mvc.library.controller;

import com.mvc.library.model.UserEntity;
import com.mvc.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by svoitenko on 20 Nov 2015.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping (value = "/list", method = RequestMethod.GET)
//    public String showUsers(Model model){
//
////        List<UserEntity> users = userService.getUsers();
//
//////        UserEntity user = new UserEntity();
////        Map<String, String> usersMap = userService.getUsersMap();
////        model.addAttribute("user", user);
////        model.addAttribute("users", usersMap);
////        return "users";
////    }
//
}
