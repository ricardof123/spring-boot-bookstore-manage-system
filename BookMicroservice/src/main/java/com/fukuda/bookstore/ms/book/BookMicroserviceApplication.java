package com.fukuda.bookstore.ms.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableEurekaClient
@EnableTransactionManagement
@ComponentScan(basePackages = "com.fukuda.bookstore.ms.book.*")
@EntityScan(basePackages = "com.fukuda.bookstore.ms.book.entity")
@EnableJpaRepositories(basePackages = "com.fukuda.bookstore.ms.book.repository")
public class BookMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookMicroserviceApplication.class, args);
    }
}
