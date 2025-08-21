package com.cerouno.qawadis_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cerouno.qawadis_api.repository")
@EntityScan(basePackages = "com.cerouno.qawadis_api.entity")
@ComponentScan(basePackages = "com.cerouno.qawadis_api")
public class QawadisApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QawadisApiApplication.class, args);
	}

}
