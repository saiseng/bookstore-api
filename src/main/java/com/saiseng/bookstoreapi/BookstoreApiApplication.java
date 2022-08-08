package com.saiseng.bookstoreapi;

import com.saiseng.bookstoreapi.controller.BookController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.saiseng.bookstoreapi")
public class BookstoreApiApplication {
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApiApplication.class);


	public static void main(String[] args) {
		logger.info("init app");

		SpringApplication.run(BookstoreApiApplication.class, args);
	}
}
