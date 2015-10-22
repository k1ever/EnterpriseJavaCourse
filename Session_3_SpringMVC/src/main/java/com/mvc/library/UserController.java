package com.mvc.library;

import com.mvc.library.dao.BookRepository;
import com.mvc.library.model.BookEntity;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String goToAddBook(){
        return "addBookPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addbookaction")
    public String addBook(@RequestParam("bookTitle") String title, @RequestParam("author") String author){
        bookRepository.addBook(new BookEntity(title, author));
        return "redirect:/books/allbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setholdernameform")
    public String goToAddHolderName(Model model, @RequestParam("bookId") int bookId){
        model.addAttribute("bookId", bookId);
        return "setHolderName";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setholdernameaction")
    public String setHolderNameAndTakeBook(@RequestParam("bookId") int bookId, @RequestParam("holderName") String holderName){
        bookRepository.setHolderName(bookId, holderName);
        bookRepository.takeBook(bookId);
        return "redirect:/books/allbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/returnbook")
    public String returnBook(@RequestParam("bookId") int bookId){
        bookRepository.setHolderName(bookId, "");
        bookRepository.returnBook(bookId);
        return "redirect:/books/allbooks";
    }

}
