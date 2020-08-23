package com.nearby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class SearchNearByApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchNearByApplication.class, args);
	}

}
