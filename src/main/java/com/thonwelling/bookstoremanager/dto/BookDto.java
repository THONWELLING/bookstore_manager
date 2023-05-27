package com.thonwelling.bookstoremanager.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookDto {

  private Long id;
  @NotEmpty(message = "Preencha o campo.")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String name;

  @NotNull(message = "Preencha o campo.")
  private Integer pages;

  @NotNull(message = "Preencha o campo.")
  private Integer chapters;

  @NotEmpty(message = "Preencha o campo.")
  @Pattern(regexp ="(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
      message = "ISBN format must be a valid format")
  private String isbn;

  @NotEmpty(message = "Preencha o campo.")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String publisherName;

  @Valid
  @NotNull
  private AuthorDto author;
}