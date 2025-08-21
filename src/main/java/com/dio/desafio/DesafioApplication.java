package com.dio.desafio;

import com.dio.desafio.dominio.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		Menu menu = new Menu();
		System.out.println(menu.showMenu());
	}
}
