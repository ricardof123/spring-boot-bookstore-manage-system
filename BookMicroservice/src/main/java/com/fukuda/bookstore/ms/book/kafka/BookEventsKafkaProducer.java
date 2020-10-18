package com.fukuda.bookstore.ms.book.kafka;

import com.fukuda.bookstore.avro.Book;
import com.fukuda.bookstore.avro.BookKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookEventsKafkaProducer {
    @Value("${kafka.topic.book.events}")
    private String mTopicName;

    @Autowired
    private KafkaTemplate<BookKey, Book> kafkaTemplate;

    public void send(Book book){
        this.kafkaTemplate.send(mTopicName, new BookKey(book.getId()), book);
    }
}
