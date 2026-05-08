package com.example.controller;

import com.example.model.Book;
import com.example.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String list(
            @RequestParam(required = false)
            String keyword,
            Model model
    ) {

        model.addAttribute(
                "books",
                bookService.search(keyword)
        );

        model.addAttribute("keyword", keyword);

        return "book-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute(
                "book",
                new Book()
        );

        return "book-form";
    }

    @PostMapping("/save")
    public String save(
            @Valid
            @ModelAttribute Book book,
            BindingResult result
    ) {

        if (result.hasErrors()) {
            return "book-form";
        }

        bookService.save(book);

        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model
    ) {

        model.addAttribute(
                "book",
                bookService.findById(id)
        );

        return "book-form";
    }

    @PostMapping("/update")
    public String update(
            @Valid
            @ModelAttribute Book book,
            BindingResult result
    ) {


        if (result.hasErrors()) {
            return "book-form";
        }

        bookService.update(book);

        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        bookService.delete(id);

        return "redirect:/books";
    }


}
