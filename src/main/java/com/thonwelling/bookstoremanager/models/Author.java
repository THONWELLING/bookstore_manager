package com.thonwelling.bookstoremanager.models;

import jakarta.persistence.*;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false)
  private Integer age;
}
