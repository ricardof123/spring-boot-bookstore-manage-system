package com.fukuda.bookstore.ms.book.form;

import com.fukuda.bookstore.ms.book.entity.Book;
import com.fukuda.bookstore.ms.book.validator.BookCategoryExists;
import com.fukuda.bookstore.ms.book.validator.ListAuthorsExists;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/* Using some custom form validators */
public class BookForm extends BaseForm<Book> {
    @Length(min = 3, max = 128)
    protected String name;

    @BookCategoryExists
    protected Integer bookCategory;

    @ListAuthorsExists
    protected List<Integer> authors;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Integer bookCategory) {
        this.bookCategory = bookCategory;
    }

    public List<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Integer> authors) {
        this.authors = authors;
    }
}
