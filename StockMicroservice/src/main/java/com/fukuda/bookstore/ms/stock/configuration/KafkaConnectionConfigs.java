package com.fukuda.bookstore.ms.stock.configuration;

import com.fukuda.bookstore.avro.Book;
import com.fukuda.bookstore.avro.BookKey;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@ConditionalOnProperty(name = "enable.kafka.feature")
public class KafkaConnectionConfigs {

    @Value("${kafka.bootstrap.servers}")
    private String bootstraps;

    @Value("${kafka.properties.schema.registry.url}")
    private String schemaRegistry;

    public KafkaConnectionConfigs() {
    }

    @Bean
    public Map<String, Object> defaultKafkaProducerConfigs(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstraps);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, this.schemaRegistry);
        return props;
    }

    @Bean
    public ProducerFactory<BookKey, Book> producerFactory(){
        return new DefaultKafkaProducerFactory<>(this.defaultKafkaProducerConfigs());
    }

    @Bean
    public KafkaTemplate<BookKey, Book> createKafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public Map<String, Object> defaultKafkaConsumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstraps);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, this.schemaRegistry);
        return props;
    }

    @Bean
    public ConsumerFactory<BookKey, Book> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(defaultKafkaConsumerConfigs());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<BookKey, Book>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<BookKey, Book> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
