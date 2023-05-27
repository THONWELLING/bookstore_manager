package com.thonwelling.bookstoremanager.controller;

import com.thonwelling.bookstoremanager.dto.BookDto;
import com.thonwelling.bookstoremanager.service.BookService;
import com.thonwelling.bookstoremanager.utils.BookUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
  public static final String BOOK_API_URL_PATH = "/api/v1/books";
  MockMvc mockMvc;
  @Mock
  private BookService bookService;
  @InjectMocks
  private BookController bookController;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(bookController)
        .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
        .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
        .build();
  }

  @Test
  void testWhenPostIsCalledThenABookShoudBeCreated() throws Exception {
    var bookDto = BookUtils.createFakeBookDto();
    var expectedBookDto = BookDto.builder().build();

    doReturn(expectedBookDto).when(bookService).createBook(any(BookDto.class));
    mockMvc.perform(post(BOOK_API_URL_PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .content(BookUtils.asJsonString(bookDto)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", Is.is(expectedBookDto.getName())))
        .andExpect(jsonPath("$.author", Is.is(expectedBookDto.getAuthor())))
        .andExpect(jsonPath("$.isbn", Is.is(expectedBookDto.getIsbn())))
        .andExpect(jsonPath("$.publisherName", Is.is(expectedBookDto.getPublisherName())))
    ;
  }

  @Test
  void testWhenPOSTWithInvalidISBNIsCalledThenBadRequestShouldBeReturned() throws Exception {
    var bookDto = BookUtils.createFakeBookDto();
    var expectedBookDto = BookDto.builder().build();
    bookDto.setIsbn("Invalid ISBN");

    mockMvc.perform(post("/api/v1/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(BookUtils.asJsonString(bookDto)))
        .andExpect(status().isBadRequest());
  }
}