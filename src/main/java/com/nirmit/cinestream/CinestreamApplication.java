package com.nirmit.cinestream;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinestreamApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load() ;

        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });

		SpringApplication.run(CinestreamApplication.class, args);
	}

}
