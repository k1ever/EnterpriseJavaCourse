package com.mvc.library;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/allbooks")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/allbooks")
    public String getAllBooks(Model model) throws JSONException {
//        model.addAttribute("message","Hello from controller!");
        return "allBooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addbookform")
    public String goToAddBook(Model model) throws JSONException {
        return "addBookPage";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/addbookaction")
    public String addBook(Model model) throws JSONException {
        return "allBooks";
    }

}
