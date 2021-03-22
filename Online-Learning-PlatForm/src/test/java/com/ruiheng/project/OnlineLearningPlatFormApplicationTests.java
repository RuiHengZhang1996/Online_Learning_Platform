package com.ruiheng.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
		
		user.setName("DaBaobei");
		user.setAge(122);
		user.setEmail("asdqerewqf@qq.com");
		user.setDeleted(0);
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
	
	@Test
	public void TestPagination() {
		
		//create config object(current page, records per page)
		Page<User> page = new Page<>(1, 3);
		
		userMapper.selectPage(page, null);
		
		//get pagination with page();
		
		System.out.println(page.getCurrent()); //get current page
		System.out.println(page.getRecords()); //get list 
		System.out.println(page.getSize());
		System.out.println(page.getTotal());
		System.out.println(page.getPages());
		
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
	}
	
	@Test
	public void physicalDelte() {
		
		int res = userMapper.deleteById(1373018507472830468L);
		System.out.println(res);
	}
	
	@Test
	public void batchDelte() {
		
		int res = userMapper.deleteBatchIds(Arrays.asList(1373018507472830465L,1373018507472830466L));
	}
	
	@Test
	public void logicDelete() {
		//same as physicaldelte()
	}
	
	@Test
	public void selectQuery() {
		//create queryWrapper
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		
		//use queryWrapper setting the conditions 
		//ge,gt,le,lt
		
		//age>=30
		wrapper.ge("age", 30);
		
		List<User> users = userMapper.selectList(wrapper);
		System.out.println(users);
		
		//eq. ne
		wrapper.ne("name", "Andy");
		List<User> user2 = userMapper.selectList(wrapper);
		System.out.println(user2);
		//between
		
		//like
		
		//orderby
		
		//last
		
		//selected column
		
	}
	
}
