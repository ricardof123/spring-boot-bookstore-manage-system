package com.fukuda.bookstore.ms.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = "com.fukuda.bookstore.ms.stock.*")
public class StockMicroserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockMicroserviceApplication.class, args);
    }
}
