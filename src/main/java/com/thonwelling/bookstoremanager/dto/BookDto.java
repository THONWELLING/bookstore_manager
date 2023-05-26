package com.thonwelling.bookstoremanager.dto;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
public class BookDto {

  private Long id;
  @NotBlank
  @Size(max = 200)
  private String name;
  @NotNull
  private Integer pages;
  @NotNull
  private Integer chapters;
  @NotBlank
  @Size(max = 200)
  private String isbn;
  @NotBlank
  @Size(max = 200)
  private String publisherName;
  @Valid
  @NotNull
  private AuthorDto author;
}