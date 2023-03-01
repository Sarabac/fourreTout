package com.ultramorpion.engine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ultramorpion.engine.mapper")
public class MorpionApplication {

	public static void main(String[] args) {SpringApplication.run(MorpionApplication.class, args);}

}
