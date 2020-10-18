package com.fukuda.bookstore.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableZuulProxy
@EnableWebMvc
@EnableEurekaClient
@ComponentScan(basePackages = "com.fukuda.bookstore.zuul.*")
public class BookstoreZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreZuulServerApplication.class, args);
    }
}

