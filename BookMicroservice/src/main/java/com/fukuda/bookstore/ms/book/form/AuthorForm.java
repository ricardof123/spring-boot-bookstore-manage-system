package com.fukuda.bookstore.ms.book.form;

import com.fukuda.bookstore.ms.book.entity.Author;
import org.hibernate.validator.constraints.Length;

public class AuthorForm extends BaseForm<Author> {
    @Length(min = 3, max = 64)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
