package com.fukuda.bookstore.base.dto;

import java.util.Set;

public class BookDto  implements Dto{
    protected Integer id;
    protected String name;
    protected BookCategoryDto bookCategory;
    protected Set<AuthorDto> authors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookCategoryDto getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategoryDto bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }
}
