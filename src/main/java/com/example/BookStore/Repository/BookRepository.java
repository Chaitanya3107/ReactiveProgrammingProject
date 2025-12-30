package com.example.BookStore.Repository;

import com.example.BookStore.Models.Book;
import io.r2dbc.spi.Parameter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {



}
