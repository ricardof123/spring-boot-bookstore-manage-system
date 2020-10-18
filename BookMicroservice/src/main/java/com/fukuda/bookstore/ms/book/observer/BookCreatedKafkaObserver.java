package com.fukuda.bookstore.ms.book.observer;
import com.fukuda.bookstore.ms.book.entity.Book;
import com.fukuda.bookstore.ms.book.kafka.BookEventsKafkaProducer;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* This observer will be notified about created Books and will send a kafka message to a topic */
@Component
public class BookCreatedKafkaObserver extends BookCreatedObserver {
    private static Logger log = Logger.getLogger(BookCreatedKafkaObserver.class);

    @Autowired
    private BookEventsKafkaProducer bookEventsKafkaProducer;

    @Override
    public void update(Book book) {
        log.info(String.format("BookCreatedKafkaObserver: '%s'", book.getName()));

        com.fukuda.bookstore.avro.Book avroBook = new com.fukuda.bookstore.avro.Book();
        avroBook.setId(book.getId());
        avroBook.setName(book.getName());
        bookEventsKafkaProducer.send(avroBook);
    }
}
