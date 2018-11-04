package com.aliadnan.bookrecommendationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookRecommendationServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(BookRecommendationServiceApplication.class, args);
	}
}
