package com.fukuda.bookstore.ms.book.service;

import com.fukuda.bookstore.ms.book.entity.BaseEntity;
import com.fukuda.bookstore.ms.book.form.BaseForm;

import java.util.Optional;

public interface BaseCrudService<E extends BaseEntity, F extends BaseForm<E>> {
    Optional<E> findById(Integer id);
    Iterable<E> findAll();
    void deleteById(Integer id);
    E create(F form);
    E update(Integer bookId, F form);
}
