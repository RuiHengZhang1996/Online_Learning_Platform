package com.ruiheng.project.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;

@Configuration
@MapperScan("com.ruiheng.project.mapper")
public class MyConfig {
	
	@Bean
	public OptimisticLockerInterceptor optimisticLockInterceptor() {
		 
		return new OptimisticLockerInterceptor();
		
	}
}
