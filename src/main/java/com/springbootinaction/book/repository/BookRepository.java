package com.springbootinaction.book.repository;
import java.util.List;

import com.springbootinaction.book.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByReader(String reader);
}
