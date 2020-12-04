package br.com.guaranisistemas.guaranisistemasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class GuaranisistemasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuaranisistemasApiApplication.class, args);
	}

}
