package com.yllies.ultramorpion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yllies.ultramorpion.mapper")
public class MorpionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MorpionApplication.class, args);
	}

}
