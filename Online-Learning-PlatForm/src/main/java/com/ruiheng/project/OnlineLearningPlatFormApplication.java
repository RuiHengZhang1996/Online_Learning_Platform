package com.ruiheng.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
@MapperScan("com.ruiheng.project.mapper")
public class OnlineLearningPlatFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineLearningPlatFormApplication.class, args);
	}

}
