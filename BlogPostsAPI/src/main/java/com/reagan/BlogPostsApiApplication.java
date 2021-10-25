package com.reagan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogPostsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogPostsApiApplication.class, args);
		System.out.println("App is loaded");
	}

}
