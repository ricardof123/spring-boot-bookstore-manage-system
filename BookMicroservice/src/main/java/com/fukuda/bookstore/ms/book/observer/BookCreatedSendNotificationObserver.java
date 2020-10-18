package com.fukuda.bookstore.ms.book.observer;

import com.fukuda.bookstore.ms.book.entity.Book;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

/* This observer will be notified about created Books and will send notification to somewhere else */
@Component
public class BookCreatedSendNotificationObserver extends BookCreatedObserver {
    private static Logger log = Logger.getLogger(BookCreatedSendNotificationObserver.class);

    @Override
    public void update(Book book) {
        // TODO logic to send book created notification to somewhere else
        log.info(String.format("BookCreatedSendNotificationObserver: '%s'", book.getName()));
    }
}
