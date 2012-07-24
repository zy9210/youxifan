package com.youxifan.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FollowDaoImpl extends SqlSessionDaoSupport implements FollowDao{
	 

	public void delete(Object model) {
		int row = getSqlSession().insert("Follow.delFollow",model);
	}


	public Object save(Object model) {
		int row = getSqlSession().insert("Follow.insertFollow",model);
		return model;
	}
 
	
	
	
	
}
