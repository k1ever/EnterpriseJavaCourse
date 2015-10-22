package com.mvc.library;

import com.mvc.library.dao.BookRepository;
import com.mvc.library.model.BookEntity;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class UserController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/allbooks")
    public String getAllBooks(Model model) throws JSONException {
        model.addAttribute("books",bookRepository.getBooks());
        return "allBooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addbookform")
    public String goToAddBook(Model model){
        return "addBookPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addbookaction")
    public String addBook(@RequestParam("bookTitle") String title, @RequestParam("author") String author){
        bookRepository.addBook(new BookEntity(title, author));
        return "redirect:/books/allbooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/takebook/{id}")
    public String takeBook(@PathVariable("id") int id){
        bookRepository.takeBook(id);
        return "redirect:/books/allbooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/returnbook/{id}")
    public String returnBook(@PathVariable("id") int id){
        bookRepository.returnBook(id);
        return "redirect:/books/allbooks";
    }
}
