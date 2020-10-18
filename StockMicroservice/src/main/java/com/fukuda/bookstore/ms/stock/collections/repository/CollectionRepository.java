package com.fukuda.bookstore.ms.stock.collections.repository;

import java.util.List;

public interface CollectionRepository<E> {
    List<E> getAll();
    void add(E dto);
}
