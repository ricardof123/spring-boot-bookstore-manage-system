package com.fukuda.bookstore.ms.book.validator;

import com.fukuda.bookstore.ms.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ListAuthorsExistsValidator implements ConstraintValidator<ListAuthorsExists, List<Integer>> {
    @Autowired
    private AuthorService authorService;

    @Override
    public void initialize(ListAuthorsExists authorExists) {
    }

    @Override
    public boolean isValid(List<Integer> list, ConstraintValidatorContext context) {
        if(list != null){
            System.out.println(list);
            return list.stream().map((id) -> authorService.findById(id).isPresent()).noneMatch((present) -> !present);
        }
        return false;
    }
}