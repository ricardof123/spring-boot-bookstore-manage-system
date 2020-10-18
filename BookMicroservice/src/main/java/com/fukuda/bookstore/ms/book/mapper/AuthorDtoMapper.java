package com.fukuda.bookstore.ms.book.mapper;

import com.fukuda.bookstore.base.dto.AuthorDto;
import com.fukuda.bookstore.ms.book.entity.Author;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AuthorDtoMapper {
    public AuthorDto toDto(Author author){
        AuthorDto dto = new AuthorDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        return dto;
    }

    public Set<AuthorDto> toDto(Set<Author> authors) {
        HashSet<AuthorDto> authorDtos = new HashSet<>();
        authors.stream().forEach((author) -> {
            authorDtos.add(this.toDto(author));
        });
        return authorDtos;
    }
}
