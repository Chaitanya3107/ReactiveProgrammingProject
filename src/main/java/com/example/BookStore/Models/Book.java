package com.example.BookStore.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("book_details")
public class Book {
    @Id
    private Integer bookId;

    private String name;

    private String description;

    private String publisher;

    private String author;

}
