package br.com.zup.dojaoorquestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DojaoOrquestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojaoOrquestratorApplication.class, args);
	}

}
