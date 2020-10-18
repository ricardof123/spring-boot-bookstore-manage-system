package com.fukuda.bookstore.ms.book.validator;

import com.fukuda.bookstore.ms.book.enums.BookCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookCategoryExistsValidator implements ConstraintValidator<BookCategoryExists, Integer> {
    @Override
    public void initialize(BookCategoryExists categoryExists) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && BookCategory.getById(value) != null;
    }
}