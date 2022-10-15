package br.com.digitalgold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DigitalGoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalGoldApplication.class, args);
	}

}
