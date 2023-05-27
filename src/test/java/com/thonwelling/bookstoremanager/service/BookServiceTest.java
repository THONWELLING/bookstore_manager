package com.thonwelling.bookstoremanager.service;

import com.thonwelling.bookstoremanager.dto.BookDto;
import com.thonwelling.bookstoremanager.models.Book;
import com.thonwelling.bookstoremanager.repository.BookRepository;
import com.thonwelling.bookstoremanager.utils.BookUtils;
import static org.junit.jupiter.api.Assertions.* ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
  @Mock
  private BookRepository bookRepository;
  @InjectMocks
  private BookService bookService;

  @Test
  void wheGivenExistingIdThenReturnThisBook() {
    Book expectedFoundBook = BookUtils.createFakeBook();

    Mockito.when(bookRepository.findById(expectedFoundBook.getId())).thenReturn(Optional.of(expectedFoundBook));
    BookDto bookDto = bookService.getBookById(expectedFoundBook.getId());

    assertEquals(expectedFoundBook.getName(), bookDto.getName());
    assertEquals(expectedFoundBook.getIsbn(), bookDto.getIsbn());
    assertEquals(expectedFoundBook.getPublisherName(), bookDto.getPublisherName());
  }
}
