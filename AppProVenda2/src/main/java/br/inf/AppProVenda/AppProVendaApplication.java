package br.inf.AppProVenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class AppProVendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppProVendaApplication.class, args);
	}

}
