package com.ruiheng.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruiheng.project.entity.User;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User>{
	
}
