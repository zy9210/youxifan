package com.youxifan.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao{
	

	public List<Object> queryStudent( ) {
		List<Object> selectList = (List<Object>) getSqlSession()
			.selectList("Student.queryStudent");
		return selectList;

	}


	public void delete(Object model) {
		int row = getSqlSession().insert("Student.delStudent",model);
	}


	public Object save(Object model) {
		int row = getSqlSession().insert("Student.insertStudent",model);
		return model;
	}


	public void update(Object model) {
		int row = getSqlSession().update("Student.updateStudent",model);
	} 
	
	
	
	
}
