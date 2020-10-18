package com.fukuda.bookstore.ms.stock.kafka;

import com.fukuda.bookstore.avro.Book;
import com.fukuda.bookstore.avro.BookKey;
import com.fukuda.bookstore.base.dto.BookDto;
import com.fukuda.bookstore.ms.stock.collections.repository.CollectionRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "enable.kafka.feature")
@Configuration
public class BookEventsKafkaConsumer {
    private final Logger log = Logger.getLogger(BookEventsKafkaConsumer.class);

    @Autowired
    private CollectionRepository<BookDto> bookCollectionRepository;

    /* Consuming created book Kafka topic messages produced by Book Microservice and using BookCollectionRepository to cache them inside CQEngine */
    @KafkaListener(topics = "${kafka.topic.book.events}", groupId = "book_events")
    public void consume(ConsumerRecord<BookKey, Book> record) {
        System.out.println(String.format("Consumed Book Event Kafka message -> %s", record.value()));

        Book book = record.value();
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());

        bookCollectionRepository.add(bookDto);
    }
}
