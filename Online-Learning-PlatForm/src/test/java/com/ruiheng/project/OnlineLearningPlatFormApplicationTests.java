package com.ruiheng.project;

import java.util.Arrays;
import java.util.HashMap;
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
		
		user.setName("Xiaokeai");
		user.setAge(25);
		user.setEmail("assdddfff@qq.com");
		
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
	
	//test optimisticLock
	@Test
	public void TestOptimisticLock() {
		
		//query the data
		User user = userMapper.selectById(1373018507472830467L);
		
		user.setAge(200);
		
		userMapper.updateById(user);
	}
	
	//multiple id batch query
	@Test
	public void TestBatchQuery() {
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1L,2L,3L));
		 System.out.println(users);
	}
	
	@Test //Not much use
	public void TestHashQuery() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Helen");
		map.put("age", 18);
		
		List<User> users = userMapper.selectByMap(map);
		
		users.forEach(System.out::println);
	}
	
	
}
