package com.youxifan.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Follow;

public class FollowDaoImpl extends SqlSessionDaoSupport implements FollowDao{
	 

	public void delete(Follow model) {
		int row = getSqlSession().insert("Follow.delFollow",model);
	}


	public Follow save(Follow model) {
		int row = getSqlSession().insert("Follow.insertFollow",model);
		return model;
	}
 
	
	
	
	
}
