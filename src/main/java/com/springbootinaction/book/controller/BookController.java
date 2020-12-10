
package com.springbootinaction.book.controller;

import java.util.List;

import com.springbootinaction.book.entity.Book;
import com.springbootinaction.book.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{reader}")
    public ResponseEntity<List<Book>> get(@PathVariable("reader") String reader) {
        var books = bookRepository.findByReader(reader);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> get() {
        var books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

}
