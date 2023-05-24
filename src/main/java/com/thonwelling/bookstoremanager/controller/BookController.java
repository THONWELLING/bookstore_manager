package com.thonwelling.bookstoremanager.controller;

import com.thonwelling.bookstoremanager.dto.MessageResponseDto;
import com.thonwelling.bookstoremanager.models.Book;
import com.thonwelling.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
  @Autowired
  BookRepository repository;

  @PostMapping
  public MessageResponseDto creteBook(@RequestBody Book book) {
    Book savedBook = repository.save(book);
    return MessageResponseDto.builder().message("Book Created With ID " + savedBook.getId()).build();
  }
}
