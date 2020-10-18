package com.fukuda.bookstore.ms.book.service;

import com.fukuda.bookstore.ms.book.entity.Author;
import com.fukuda.bookstore.ms.book.entity.Book;
import com.fukuda.bookstore.ms.book.enums.BookCategory;
import com.fukuda.bookstore.ms.book.form.BookForm;

public interface BookService extends BaseCrudService<Book,BookForm>{
    Iterable<Book> findAllByBookCategory(BookCategory bookCategory);
    Iterable<Book> findAllByAuthors(Author authors);
}
