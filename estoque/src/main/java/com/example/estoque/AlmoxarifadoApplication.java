package com.example.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlmoxarifadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmoxarifadoApplication.class, args);
		
		
		/*server port 8080
		spring.datasource.url=jdbc:mysql://localhost/estoque?useTimezone=true&serverTimezone=UTC
		spring.datasource.username=root
		spring.datasource.password=0808greg
		spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
		spring.jpa.hibernate.ddl-auto=update*/
	}

}
