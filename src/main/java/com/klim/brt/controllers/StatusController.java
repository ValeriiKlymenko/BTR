package com.klim.brt.controllers;

import com.klim.brt.entity.Authors;
import com.klim.brt.entity.Status;
import com.klim.brt.repository.BookRepository;
import com.klim.brt.repository.StatusRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StatusController {

    private StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/add-status")
    public String statusAdd(Model model){
        return "add-status";
    }
    @PostMapping("/add-status")
    public String statusPostAdd(@RequestParam String name_status, Model model){

        Status status = new Status(name_status);
        statusRepository.save(status);
        return "redirect:/add";
    }
}
