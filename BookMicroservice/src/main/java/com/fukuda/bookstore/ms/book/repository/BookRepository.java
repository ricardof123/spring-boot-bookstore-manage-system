package com.fukuda.bookstore.ms.book.repository;

import com.fukuda.bookstore.ms.book.entity.Author;
import com.fukuda.bookstore.ms.book.entity.Book;
import com.fukuda.bookstore.ms.book.enums.BookCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findAllByBookCategory(BookCategory bookCategory);
    List<Book> findAllByAuthors(Author author);
}
