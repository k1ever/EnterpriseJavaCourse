package com.mvc.library.controller;

import com.mvc.library.model.BookEntity;
import com.mvc.library.service.BookService;
import com.mvc.library.service.StatisticService;
import com.mvc.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value = "/allbooks", method = RequestMethod.GET)
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getBooksList());
        model.addAttribute("popularBook", statisticService.getMostPopularBook());
        return "allBooks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBookForm(Model model){
        BookEntity book = new BookEntity();
        model.addAttribute("book", book);
        return "addBookForm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") BookEntity book){
        bookService.addBook(book);
        return "redirect:/books/allbooks";
    }

    @RequestMapping(value = "/setholderform", method = RequestMethod.POST)
    public String setHolderForm(Model model, @RequestParam("bookId") int bookId) {

        BookEntity bookEntity = bookService.getBookById(bookId);
        model.addAttribute("book", bookEntity);

        Map<String, String> usersMap = userService.getUsersMap();
        model.addAttribute("usersMap", usersMap);

        return "setHolderForm";
    }

    @RequestMapping(value = "/setholdername", method = RequestMethod.POST)
    public String takeBook(@ModelAttribute("book") BookEntity book){
        bookService.setTaken(book);
        statisticService.setTaken(book);

        return "redirect:/books/allbooks";
    }

    @RequestMapping(value = "/returnbook", method = RequestMethod.POST)
    public String returnBook(@RequestParam("bookId") int bookId){
        BookEntity book = bookService.getBookById(bookId);
        statisticService.setReturnDate(book);
        bookService.setFree(book);

        return "redirect:/books/allbooks";
    }

}
