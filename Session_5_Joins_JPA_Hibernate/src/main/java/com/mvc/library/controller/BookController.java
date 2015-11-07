package com.mvc.library.controller;

import com.mvc.library.model.BookEntity;
import com.mvc.library.repository.BookRepository;
import com.mvc.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/allbooks", method = RequestMethod.GET)
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getBooksList());
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
    public String setHolderForm(Model model, @RequestParam("bookId") int bookId){
        model.addAttribute("bookId", bookId);
        return "setHolderForm";
    }

    @RequestMapping(value = "/setholdername", method = RequestMethod.POST)
    public String takeBook(@RequestParam("bookId") int bookId, @RequestParam("holderName") String holderName){
        bookService.takeBook(bookId, holderName);
        return "redirect:/books/allbooks";
    }

    @RequestMapping(value = "/returnbook", method = RequestMethod.POST)
    public String returnBook(@RequestParam("bookId") int bookId){
        bookService.returnBook(bookId);
        return "redirect:/books/allbooks";
    }

}
