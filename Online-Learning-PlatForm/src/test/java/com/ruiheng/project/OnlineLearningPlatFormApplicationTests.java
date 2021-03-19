package com.ruiheng.project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruiheng.project.entity.User;
import com.ruiheng.project.mapper.UserMapper;

//inject mapper

@SpringBootTest
class OnlineLearningPlatFormApplicationTests {
	
	
	@Autowired	
	private UserMapper userMapper;
	
	
	//Query all user data
	@Test
	public void queryAll() {
		List<User> users= userMapper.selectList(null);
		System.out.println(users);
		
	}

}
