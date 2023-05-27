package com.thonwelling.bookstoremanager.utils;

import com.github.javafaker.Faker;
import com.thonwelling.bookstoremanager.dto.AuthorDto;
import com.thonwelling.bookstoremanager.models.Author;

public class AuthorUtils {
  private static final Faker faker = Faker.instance();

  public static AuthorDto createFakeAuthorDto() {
    return AuthorDto.builder()
        .id(faker.number().randomNumber())
        .name(faker.book().author())
        .age(faker.number().numberBetween(0, 100))
        .build();
  }

  public static Author createFakeAuthor() {
    return Author.builder()
        .id(faker.number().randomNumber())
        .name(faker.book().author())
        .age(faker.number().numberBetween(0, 100))
        .build();
  }

  public static Author createFakeAuthorFrom(AuthorDto authorDto) {
    return Author.builder()
        .id(authorDto.getId())
        .name(authorDto.getName())
        .age(authorDto.getAge())
        .build();
  }

}
