package com.example.BookStore.Services.impl;

import com.example.BookStore.Models.Book;
import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll().delayElements(Duration.ofSeconds(2));
    }

    @Override
    public Mono<Book> get(Integer bookId) {
        bookRepository.findById(bookId);
        return null;
    }

    @Override
    public Mono<Book> update(Book book, Integer bookId) {
        Mono<Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(newBook -> {
            newBook.setName(book.getName());
            newBook.setAuthor(book.getAuthor());
            newBook.setPublisher(book.getPublisher());
            newBook.setDescription(book.getDescription());
            return bookRepository.save(newBook);
        });
    }

    @Override
    public Mono<Void> delete(Integer bookId) {
        return bookRepository.findById(bookId).flatMap(bookRepository::delete);
    }

    @Override
    public Flux<Book> search(String title) {
        return bookRepository.searchBookByTitle(title);
    }
}
