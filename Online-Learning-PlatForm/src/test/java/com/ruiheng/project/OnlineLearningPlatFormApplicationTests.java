package com.ruiheng.project;

import java.util.Date;
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
	
	@Test
	public void addUser() {
		User user = new User();
		
		user.setName("CaaaaCC");
		user.setAge(12);
		user.setEmail("CCCCCcc@qq.com");
		
		/*
		 * user.setCreateTime(new Date()); user.setUpdateTime(new Date());
		 */
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}
	
	@Test
	public void updateUser() {
		
		User user = new User();
		user.setId(1373018507472830465L);
		user.setAge(120);
		
		
		int row = userMapper.updateById(user);
		System.out.println(row);
	}
	

}
