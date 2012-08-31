package com.youxifan.dao;

import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Follow;

public class FollowDaoImpl extends SqlSessionDaoSupport implements FollowDao{
	 

	public void delete(Follow model) {
		int row = getSqlSession().insert("Follow.delFollow",model);
	}


	public Follow save(Follow model) {
		try {
			 int row = getSqlSession().insert("Follow.insertFollow",model);
		} catch (Exception e) {
			// TODO: 已经follow该标签 
		}
		
		return model;
	}
 
	
	public int countFollower(Map map){
		return  (Integer) getSqlSession().selectOne("Follow.countFollower",map);
		 
	}
	
	public int countUpper(Map map){
		return  (Integer) getSqlSession().selectOne("Follow.countUpper",map);
	}
	
	
}
