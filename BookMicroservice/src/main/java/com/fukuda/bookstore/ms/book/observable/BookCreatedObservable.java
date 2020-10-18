package com.fukuda.bookstore.ms.book.observable;

import com.fukuda.bookstore.ms.book.entity.Book;
import org.springframework.stereotype.Component;

/*
All Observers related to created Books need to subscribe itself to this class
 */
@Component
public class BookCreatedObservable extends BaseObservable<Book> {
}
