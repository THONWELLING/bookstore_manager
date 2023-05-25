package com.thonwelling.bookstoremanager.service;

import com.thonwelling.bookstoremanager.dto.MessageResponseDto;
import com.thonwelling.bookstoremanager.models.Book;
import com.thonwelling.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {
  @Autowired
  BookRepository repository;

  public MessageResponseDto creteBook(Book book) {
    Book savedBook = repository.save(book);
    return MessageResponseDto.builder().message("Book Created With ID " + savedBook.getId()).build();
  }
}
