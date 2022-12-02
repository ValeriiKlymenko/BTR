package com.klim.brt.controllers;

import com.klim.brt.repository.AuthorRepository;
import com.klim.brt.repository.BookRepository;
import com.klim.brt.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

//    @Autowired
    private AuthorRepository authorRepository;
//    @Autowired
    private BookRepository bookRepository;
//    @Autowired
    private StatusRepository statusRepository;
//
//    //Замість @Autowired
    public BookController(AuthorRepository authorRepository, BookRepository bookRepository, StatusRepository statusRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.statusRepository = statusRepository;
    }
}
