package com.fukuda.bookstore.ms.book.service;

import com.fukuda.bookstore.ms.book.entity.Author;
import com.fukuda.bookstore.ms.book.form.AuthorForm;
import com.fukuda.bookstore.ms.book.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseCrudServiceImpl<Author, AuthorForm, AuthorRepository> implements AuthorService {
    @Override
    public Author create(AuthorForm form) {
        return null;
    }

    @Override
    public Author update(Integer id, AuthorForm form) {
        return null;
    }
}
