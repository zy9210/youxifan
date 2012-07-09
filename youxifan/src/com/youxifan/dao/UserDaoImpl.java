package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	

	public List<Object> query( ) {
		List<Object> userList = (List<Object>) getSqlSession()
			.selectList("User.queryUser");
		return userList;

	}
	
	public Object getUserByEmail(String email) {
		return getSqlSession().selectOne("User.getUserByEmail",email);
	} 
	public void changePassword(Map param){
		getSqlSession().update("User.changePassword", param);
	}
	
	
	public Object save(Object model) {
		int row = getSqlSession().insert("User.insertUser",model);
		return model;
	}
	
	public void setUserImageUrl(Object model) {
		int row = getSqlSession().insert("User.updateHeadUrl",model);
	}

	public void delete(Object model) {
		int row = getSqlSession().insert("User.delUser",model);
	}


	public void update(Object model) {
		int row = getSqlSession().update("User.updateUser",model);
	}


	
	
	
	
}
