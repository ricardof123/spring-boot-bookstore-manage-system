package com.fukuda.bookstore.ms.book.repository;

import com.fukuda.bookstore.ms.book.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
