package com.youxifan.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TagDaoImpl extends SqlSessionDaoSupport implements TagDao{
	

	public List<Object> queryTag( ) {
		List<Object> selectList = (List<Object>) getSqlSession()
			.selectList("Tag.queryTag");
		return selectList;

	}


	public void delete(Object model) {
		int row = getSqlSession().insert("Tag.delTag",model);
	}


	public Object save(Object model) {
		int row = getSqlSession().insert("Tag.insertTag",model);
		return model;
	}


	public void update(Object model) {
		int row = getSqlSession().update("Tag.updateTag",model);
	} 
	
	
	
	
}
