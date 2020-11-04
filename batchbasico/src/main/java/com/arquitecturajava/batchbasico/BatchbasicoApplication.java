package com.arquitecturajava.batchbasico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(JobConfiguration.class)
public class BatchbasicoApplication {


	public static void main(String[] args) {
		SpringApplication.run(BatchbasicoApplication.class, args);
	}

}
