package org.server.localshop;


import org.server.localshop.core.boot.AbstractApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan("org.server.localshop")
public class LocalshopApplication {
	
	/*@Import({ EmbeddedTomcatConfiguration.class})*/
	private static class Configuration extends AbstractApplicationConfiguration { }	
	
	public static void main(String[] args) throws Exception	{
		SpringApplication.run(LocalshopApplication.class, args);
		
	}
}

