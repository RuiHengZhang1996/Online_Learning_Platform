package com.ruiheng.project.entity;

import org.mybatis.spring.annotation.MapperScan;

import lombok.Data;

@Data
public class User {
	
	private Long id;
    private String name;
    private Integer age;
    private String email;
}
