package com.fukuda.bookstore.ms.book.mapper;

import com.fukuda.bookstore.base.dto.BookDto;
import com.fukuda.bookstore.ms.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookDtoMapper {
    @Autowired
    private BookCategoryDtoMapper bookCategoryDtoMapper;

    @Autowired
    private AuthorDtoMapper authorDtoMapper;

    public BookDto toDto(Book e){
        BookDto dto = new BookDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setBookCategory(bookCategoryDtoMapper.toDto(e.getBookCategory()));
        dto.setAuthors(authorDtoMapper.toDto(e.getAuthors()));
        return dto;
    }

    public Iterable<BookDto> toDto(Iterable<Book> e){
        ArrayList<BookDto> list = new ArrayList<>();
        e.forEach((q) -> {
            list.add(this.toDto(q));
        });
        return list;
    }
}
