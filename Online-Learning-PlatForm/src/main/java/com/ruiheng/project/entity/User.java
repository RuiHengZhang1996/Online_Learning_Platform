package com.ruiheng.project.entity;

import org.mybatis.spring.annotation.MapperScan;

import lombok.Data;

@Data
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class User {
	private Long id;
    private String name;
    private Integer age;
    private String email;
}
