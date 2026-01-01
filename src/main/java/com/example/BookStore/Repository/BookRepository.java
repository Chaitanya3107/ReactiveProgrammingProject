package com.example.BookStore.Repository;

import com.example.BookStore.Models.Book;
import io.r2dbc.spi.Parameter;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {

    Mono<Book> findByName(String name); // used to find by name of author

    Flux<Book> findByAuthor(String author);

    Flux<Book> findByPublisher(String publisher);

    Flux<Book> findByNameAndAuthor(String name, String author);

    @Query("select * from book_details where name = :name")
    Flux<Book> getAllBooksByAuthor(String name);

    @Query("SELECT * FROM book_details WHERE name LIKE CONCAT('%', :title, '%')")
    Flux<Book> searchBookByTitle(String title);







}
