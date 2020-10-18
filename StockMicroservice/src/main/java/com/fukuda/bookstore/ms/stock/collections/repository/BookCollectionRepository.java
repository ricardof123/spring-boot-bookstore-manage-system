package com.fukuda.bookstore.ms.stock.collections.repository;

import com.fukuda.bookstore.base.dto.BookDto;
import com.fukuda.bookstore.ms.stock.collections.BookCollection;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCollectionRepository implements CollectionRepository<BookDto> {
    private BookCollection bookCollection;

    public BookCollectionRepository(){
        this.bookCollection = new BookCollection();
    }

    /* We are using cqengine collection to cache created Books from the Book Microservice, this BookCollection is automatically populated by consuming a Kafka topic */
    public List<BookDto> getAll(){
        return (List<BookDto>)(bookCollection.stream().collect(Collectors.toList()));
    }

    public void add(BookDto bookDto){
        bookCollection.add(bookDto);
    }
}
