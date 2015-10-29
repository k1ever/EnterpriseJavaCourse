package com.mvc.library;

import com.mvc.library.dao.BooksRepository;
import com.mvc.library.model.BooksEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books")
public class UserController {

    @Autowired
    private BooksRepository booksRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/allbooks")
    public String getAllBooks(Model model) {
        model.addAttribute("books",booksRepository.getBooksList());
        return "allBooks";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addbookform")
    public String goToAddBook(){
        return "addBookPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addbookaction")
    public String addBook(@RequestParam("bookTitle") String title, @RequestParam("author") String author){
        booksRepository.addBook(title, author);
        return "redirect:/books/allbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setholdernameform")
    public String goToAddHolderName(Model model, @RequestParam("bookId") int bookId){
        model.addAttribute("bookId", bookId);
        return "setHolderName";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setholdernameaction")
    public String setHolderNameAndTakeBook(@RequestParam("bookId") int bookId, @RequestParam("holderName") String holderName){
        booksRepository.takeBook(bookId, holderName);
        return "redirect:/books/allbooks";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/returnbook")
    public String returnBook(@RequestParam("bookId") int bookId){
        booksRepository.returnBook(bookId);
        return "redirect:/books/allbooks";
    }


}
