package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.BookModel;
import com.example.fitnessapp.repository.IBookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BookController {

    private final IBookRepository bookRepository;

    public BookController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/getBooks")
    public Iterable<BookModel> getBookById() {
        return bookRepository.findAll();
    }


}

