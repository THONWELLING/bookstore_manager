package com.thonwelling.bookstoremanager.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.thonwelling.bookstoremanager.dto.BookDto;
import com.thonwelling.bookstoremanager.models.Book;

import static com.thonwelling.bookstoremanager.utils.AuthorUtils.*;


public class BookUtils {

  private static final Faker faker = Faker.instance();

    public static BookDto createFakeBookDto() {
      return BookDto.builder()
          .id(faker.number().randomNumber())
          .name(faker.book().title())
          .pages(faker.number().numberBetween(0, 200))
          .chapters(faker.number().numberBetween(1, 20))
          .isbn("0-596-52068-9")
          .publisherName(faker.book().publisher())
          .author(createFakeAuthorDto())
          .build();
    }

    public static Book createFakeBook() {
      return Book.builder()
          .id(faker.number().randomNumber())
          .name(faker.book().title())
          .pages(faker.number().numberBetween(0, 200))
          .chapters(faker.number().numberBetween(1, 20))
          .isbn("0-596-52068-9")
          .publisherName(faker.book().publisher())
          .author(createFakeAuthor())
          .build();
    }

    public static Book createFakeBookFrom(BookDto bookDto) {
      return Book.builder()
          .id(bookDto.getId())
          .name(bookDto.getName())
          .pages(bookDto.getPages())
          .chapters(bookDto.getChapters())
          .isbn(bookDto.getIsbn())
          .publisherName(bookDto.getPublisherName())
          .author(createFakeAuthorFrom(bookDto.getAuthor()))
          .build();
    }

    public static String asJsonString(BookDto bookDTO) {
      try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModules(new JavaTimeModule());

        return objectMapper.writeValueAsString(bookDTO);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
}
