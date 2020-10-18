package com.fukuda.bookstore.ms.book.mapper;

import com.fukuda.bookstore.base.dto.BookCategoryDto;
import com.fukuda.bookstore.ms.book.enums.BookCategory;
import org.springframework.stereotype.Component;

@Component
public class BookCategoryDtoMapper {
    public BookCategoryDto toDto(BookCategory e){
        BookCategoryDto dto = new BookCategoryDto();
        dto.setId(e.ordinal());
        dto.setName(e.getName());
        return dto;
    }
}
