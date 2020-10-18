package com.fukuda.bookstore.ms.stock.controller;

import com.fukuda.bookstore.base.dto.BookDto;
import com.fukuda.bookstore.ms.stock.clientservice.BookClientService;
import com.fukuda.bookstore.ms.stock.collections.repository.BookCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/stock")
public class StockRestController {
    @Autowired
    private BookClientService bookClientService;

    @Autowired
    private BookCollectionRepository bookCollectionRepository;

    /* We are requesting some data from Book Microservice using the service discovery functionality (provided by Feign + Eureka + Ribbon) and just returning the data to the user. */
    @GetMapping(path = "/book")
    public List<BookDto> getBooks(){
        return bookClientService.getBooks();
    }

    @GetMapping(path = "/book/{bookId}")
    public BookDto getBook(@PathVariable(name = "bookId") Long bookId){
        return bookClientService.getBookById(bookId);
    }

    /* We are using bookCollectionRepository to return the cached created Books from the Book Microservice, this bookCollectionRepository is populated by consuming a Kafka topic */
    @GetMapping(path = "/book/recent")
    public List<BookDto> getBook(@PathVariable(name = "bookId") Integer bookId){
        return bookCollectionRepository.getAll();
    }
}