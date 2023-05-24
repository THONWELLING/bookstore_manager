package com.thonwelling.bookstoremanager.repository;

import com.thonwelling.bookstoremanager.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
