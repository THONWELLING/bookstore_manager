package com.thonwelling.bookstoremanager.service;

import com.thonwelling.bookstoremanager.dto.BookDto;
import com.thonwelling.bookstoremanager.mapper.BookMapper;
import com.thonwelling.bookstoremanager.models.Book;
import com.thonwelling.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  BookRepository repository;

  public BookDto createBook(BookDto book) {
    var entity = BookMapper.parseObject(book, Book.class);
    return BookMapper.parseObject(repository.save(entity), BookDto.class);
  }
}
