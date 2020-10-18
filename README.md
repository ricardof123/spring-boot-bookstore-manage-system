## DEMO SpringBoot Bookstore Management System

Java implementation demo featuring:
* Spring Boot;
* Spring Data (Hibernate, Mysql);
* Spring Cloud Netflix (Eureka, Feign, Ribbon and Zuul);
* Spring Cloud Streams;
* CQEngine;

### Overview of the architecture:
***Book Microservice:*** This microservice provides a couple of RESTful endpoints to allows basic operations like create and edit books. Everytime a new book is created, an Observer class listens to the event and broadcast the change by sending a message through kafka topic.

***Stock Microservice:***  This microservice will be responsible to consume the book creation kafka message and might execute other logics (In this example, it just logs the event). Also, this microservice will use the service discovery functionality provided by Feign + Ribbon + Eureka to perform http requests to get book details from the book microservice.

### Used Technologies:
- ***Spring Boot:*** Pre-configured Spring Framework.
- ***Spring Data:*** Allows easy CRUD operations against database Entity repository and provides better integration with Hibernate (ORM) + MySQL.
- ***Spring Cloud Netflix:***
    - ***Eureka Server:*** Allows Service Discovery between microservices. Everytime a microservice starts it automatically register itself against the eureka server and all the service details becomes available to other microservices.
    - ***Feign Client + Ribbon:*** By using Feign together with Eureka + Ribbon, it allows automatic Service Discovery functionality and client-side load balance to make sure the communication between microservices works seamless without boilerplate host/port configurations.
    - ***Zuul Server:*** Provides reverse proxy functionality working like a single point of entry for the application architecture, it’s like a gateway to control and redirect http traffic to different microservices. In this demo, the request path is responsible to define the target microservice. Example: All /book/** requests are redirected to the BookMicroservice.
- ***Spring Cloud Streams - Kafka:*** Uses Kafka Consumer/Producer to broadcast book creation events between microservices. When one of the microservices needs to be informed about a book creation event, it just needs to consume from the topic. The serialization and deserialization process is done by Confluent Avro schema and registry.
- ***CQEngine:*** In this demo, It’s reponsible to cache created book event consumed from one of the kafka topics.
- ***MySQL:*** The database in this demo.
- ***MyBatis:*** Library and utility to allow automatic mysql database rollout and rollback migration.

