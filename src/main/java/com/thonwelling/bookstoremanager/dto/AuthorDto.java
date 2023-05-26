package com.thonwelling.bookstoremanager.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class AuthorDto {

  private Long id;
  @NotBlank(message = "Preecha o Nome")
  @Size(max = 200)
  private String name;

  @NotNull
  @Size(max = 100)
  private Integer age;
}