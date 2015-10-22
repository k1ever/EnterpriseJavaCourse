package com.mvc.library;

import com.mvc.library.model.BookEntity;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/allbooks")
    public String getAllBooks(Model model) throws JSONException {

        List<BookEntity> books = new ArrayList<BookEntity>();

        BookEntity book1 = new BookEntity("Core Java", "Hostmann" );
        BookEntity book2 = new BookEntity("Spring for Dummies", "Kravchenko/Parkhomenko");
        book2.setIsTaken(true);

        books.add(book1);
        books.add(book2);
        model.addAttribute("books",books);

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
