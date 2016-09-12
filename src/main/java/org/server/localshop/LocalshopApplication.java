package org.server.localshop;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class LocalshopApplication {

	public static void main(String[] args) throws Exception
	{
		System.out.println("Tu dois marcher stp avec l'aide de Dieu");
		SpringApplication.run(LocalshopApplication.class, args);
	}
}
