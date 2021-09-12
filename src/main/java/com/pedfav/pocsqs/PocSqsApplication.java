package com.pedfav.pocsqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PocSqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSqsApplication.class, args);
	}

}
