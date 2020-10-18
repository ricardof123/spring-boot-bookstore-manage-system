package com.fukuda.bookstore.ms.book.observer;

import com.fukuda.bookstore.base.observer.BaseObserver;
import com.fukuda.bookstore.ms.book.entity.Book;

/*
All classes that would like to be notified about created Books should extend this class
 */
public abstract class BookCreatedObserver extends BaseObserver<Book> {
}
