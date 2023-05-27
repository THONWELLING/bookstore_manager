package com.thonwelling.bookstoremanager.controller;

import com.thonwelling.bookstoremanager.dto.BookDto;
import com.thonwelling.bookstoremanager.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
  @Autowired
  BookService service;

  @PostMapping
  public BookDto createBook(@RequestBody @Valid BookDto book) {
    return service.createBook(book);
  }
}
