package com.fukuda.bookstore.ms.book.validator;

import com.fukuda.bookstore.ms.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthorExistsValidator implements ConstraintValidator<AuthorExists, Integer> {
    @Autowired
    private AuthorService authorService;

    @Override
    public void initialize(AuthorExists authorExists) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && authorService.findById(value).isPresent();
    }
}