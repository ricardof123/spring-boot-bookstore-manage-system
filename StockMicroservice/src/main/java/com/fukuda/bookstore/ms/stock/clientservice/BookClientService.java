package com.fukuda.bookstore.ms.stock.clientservice;

import com.fukuda.bookstore.base.dto.BookDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
This client is responsible to call some Book Microservice API endpoints to get some data.
By using Feign together with Eureka + Ribbon, it actually allow automatic Service Discovery functionality and client-side Load balance.
 */
@Component
@FeignClient(name = "bookMicroservice") /* This is the name of the service (registered on Eureka) that we want to discover */
@RibbonClient() /* This one will use the service details returned from Eureka to load balance and connect to the target microservice */
@RequestMapping(path = "/api/book")
public interface BookClientService {
    @GetMapping(value = "/")
    List<BookDto> getBooks();

    @GetMapping(value = "/{bookId}")
    BookDto getBookById(@PathVariable("bookId") Long postId);
}
