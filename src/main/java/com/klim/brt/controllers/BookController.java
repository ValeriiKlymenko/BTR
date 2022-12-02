package com.klim.brt.controllers;

import com.klim.brt.entity.Books;
import com.klim.brt.repository.AuthorRepository;
import com.klim.brt.repository.BookRepository;
import com.klim.brt.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private StatusRepository statusRepository;
//
//    //Замість @Autowired
    public BookController(AuthorRepository authorRepository, BookRepository bookRepository, StatusRepository statusRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/reading")
    public String home(Model model){
        Iterable<Books> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "reading";
    }
}
