package com.klim.brt.controllers;

import com.klim.brt.entity.Authors;
import com.klim.brt.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/add-author")
    public String authorAdd(Model model){
        return "add-author";
    }
    @PostMapping("/add-author")
    public String authorPostAdd(@RequestParam String name_author, Model model){
        Authors authors = new Authors(name_author);
        authorRepository.save(authors);
        return "redirect:/add";
    }
}
