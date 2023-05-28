package com.thonwelling.bookstoremanager.controller;

import com.thonwelling.bookstoremanager.dto.BookDto;
import com.thonwelling.bookstoremanager.exceptions.BookNotFoundException;
import com.thonwelling.bookstoremanager.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
  @Autowired
  BookService service;

  @PostMapping
  public BookDto createBook(@RequestBody @Valid BookDto book) {
    return service.createBook(book);
  }

  @GetMapping("/{id}")
  public BookDto getBookById(@PathVariable Long id) throws BookNotFoundException {
    return service.getBookById(id);
  }
}
