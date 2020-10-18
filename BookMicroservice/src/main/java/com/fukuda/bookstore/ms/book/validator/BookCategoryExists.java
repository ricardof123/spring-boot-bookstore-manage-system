package com.fukuda.bookstore.ms.book.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BookCategoryExistsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BookCategoryExists {
    String message() default "Book Category doesn't exist";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}