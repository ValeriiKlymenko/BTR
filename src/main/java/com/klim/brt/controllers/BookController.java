package com.klim.brt.controllers;

import com.klim.brt.entity.Authors;
import com.klim.brt.entity.Books;
import com.klim.brt.entity.Status;
import com.klim.brt.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BookController {
    private BookRepository bookRepository;
//    //Замість @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/reading")
    public String home(Model model){
        Iterable<Books> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "reading";
    }
    @GetMapping("/add-book")
    public String bookAdd(Model model){
        return "add-book";
    }

    @PostMapping("/add-book")
    public String bookPostAdd(@RequestParam String title,
                              @RequestParam String subtitle,
                              @RequestParam int page,
                              @RequestParam String notes,
//                              @RequestParam Image image,
//                              @RequestParam Data start,
//                              @RequestParam Data finished,
                              @RequestParam Authors authors,
                              @RequestParam Status status,
                              Model model){
        Books books = new Books(title, subtitle, page,notes,authors, status);// потрібно створити конструктор в Books
        bookRepository.save(books);
        return "redirect:/";
    }
    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable(value = "id") long id, Model model){

        if (!bookRepository.existsById(id)){ // якщо немає такого id
            return "redirect:/home";
        }
        Optional<Books> books = bookRepository.findById(id);
        ArrayList<Books> res = new ArrayList<>();
        books.ifPresent(res::add);
        model.addAttribute("books", res);
        return "book-details";
    }
    @GetMapping("/book/{id}/edit")
    public String bookEdit(@PathVariable(value = "id") long id, Model model){

        if (!bookRepository.existsById(id)){ // якщо немає такого id
            return "redirect:/";
        }
        Optional<Books> books = bookRepository.findById(id);
        ArrayList<Books> res = new ArrayList<>();
        books.ifPresent(res::add);
        model.addAttribute("books", res);
        return "book-edit";
    }
    @PostMapping("/book/{id}/edit")
    public String bookPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String title,
                                 @RequestParam String subtitle,
                                 @RequestParam int page,
                                 @RequestParam String notes,
//                              @RequestParam Image image,
//                              @RequestParam Data start,
//                              @RequestParam Data finished,
                                 @RequestParam Authors authors,
                                 @RequestParam Status status,
                                 Model model){
       Books books = bookRepository.findById(id).orElseThrow(); // виключення, якщо запись була не найдена
        books.setTitle(title);
        books.setSubtitle(subtitle);
        books.setPage(page);
        books.setNotes(notes);
        books.setAuthors(authors);
        books.setStatus(status);
        bookRepository.save(books);
        return "redirect:/";
    }
    @PostMapping("/book/{id}/remove")
    public String bookPostDelete(@PathVariable(value = "id") long id, Model model){
        Books books = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(books);

        return "redirect:/";
    }
}
