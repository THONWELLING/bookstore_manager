package com.thonwelling.bookstoremanager.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthorDto {

  private Long id;
  @NotEmpty(message = "Preencha o campo.")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String name;

  @NotNull(message = "Preencha o campo .")
  private Integer age;
}