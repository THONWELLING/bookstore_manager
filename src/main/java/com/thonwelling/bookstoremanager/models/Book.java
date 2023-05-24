package com.thonwelling.bookstoremanager.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false)
  private Integer pages;
  @Column(nullable = false)
  private Integer chapters;
  @Column(nullable = false)
  private String isbn;
  @Column(name =  "publisher_name", nullable = false, unique = true)
  private String publisherName;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "author_id")
  private Author author;
}