package com.example.BookStore.Controller;

import com.example.BookStore.Models.Book;
import com.example.BookStore.Services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @GetMapping
    public Flux<Book> getAll(){
        return bookService.getAll();
    }
    // GET endpoint that streams books in SSE format (text/event-stream)
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> streamBooks() {
        // Stream all books as individual SSE events
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Mono<Book> getBook(@PathVariable Integer bookId){
        return bookService.get(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> update(@RequestBody Book book,@PathVariable Integer bookId) {
        return bookService.update(book,bookId);
    }

    @DeleteMapping("/{booksId}")
    public Mono<Void> create(@PathVariable Integer bookId) {
        return bookService.delete(bookId);
    }

    @GetMapping("/search/{title}")
    public Flux<Book> searchBook(@PathVariable String title){
        return  bookService.search(title);
    }

}






