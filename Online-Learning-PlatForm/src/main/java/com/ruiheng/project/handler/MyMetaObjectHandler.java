package com.ruiheng.project.handler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler{
	
	//Using mp inserting, this func exe
	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}
	
	//using mp updating this func exe
	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("updateTime", new Date(), metaObject);
		
	}
	
	
}
