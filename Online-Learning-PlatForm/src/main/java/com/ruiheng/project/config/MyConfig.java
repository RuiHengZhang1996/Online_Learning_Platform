package com.ruiheng.project.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;


@Configuration
@MapperScan("com.ruiheng.project.mapper")
public class MyConfig {
	
	@Bean
	public OptimisticLockerInterceptor optimisticLockInterceptor() {
		 
		return new OptimisticLockerInterceptor();
		
	}
	
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		
		return new PaginationInterceptor();
	}
	
}	
