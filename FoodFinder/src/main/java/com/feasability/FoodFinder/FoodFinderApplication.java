package com.feasability.FoodFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.feasability.FoodFinder"})
public class FoodFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodFinderApplication.class, args);
	}
}