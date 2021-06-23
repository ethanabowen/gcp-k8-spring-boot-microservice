package com.reindeer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.reindeer")
public class ReindeerApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder()
		.sources(ReindeerApplication.class)
		.profiles("local")
		.run(args);
	}

}
