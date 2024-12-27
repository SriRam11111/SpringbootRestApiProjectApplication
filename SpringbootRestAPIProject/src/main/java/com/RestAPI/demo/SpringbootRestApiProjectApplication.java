package com.RestAPI.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan("com.RestAPI") //  tells Spring to scan the specified package (com.RestAPI) and its sub-packages for Spring-managed beans, such as components, services, controllers, and repositories, and automatically register them for dependency injection
@EnableJpaRepositories("com.RestAPI.repository") // Add this if the repository is in a separate package  ensures that Spring Data JPA is aware of your repository interfaces, allowing it to create proxy instances of these interfaces for performing CRUD)

public class SpringbootRestApiProjectApplication {

    // Create a logger instance for the class
    private static final Logger logger = LoggerFactory.getLogger(SpringbootRestApiProjectApplication.class);

    public static void main(String[] args) {
        // Log that the application is starting
        logger.info("Starting Spring Boot Application...");

        // Run the Spring Boot application
        SpringApplication.run(SpringbootRestApiProjectApplication.class, args);
        System.out.println("...........started..........");
     
    }
}
