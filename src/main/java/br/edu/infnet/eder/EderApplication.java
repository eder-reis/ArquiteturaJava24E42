package br.edu.infnet.eder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EderApplication.class, args);
	}

}
