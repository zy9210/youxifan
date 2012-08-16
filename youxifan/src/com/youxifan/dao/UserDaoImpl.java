package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	

	public List<User> query( ) {
		List<User> userList = (List<User>) getSqlSession()
			.selectList("User.queryUser");
		return userList;

	}
	
	public List<User> followedUsers(Map  map ) {
		List<User> userList = (List<User>) getSqlSession()
			.selectList("User.userFollowedUser",map);
		return userList;

	}
	public List<User> userSearch(Map  map ) {
		List<User> userList = (List<User>) getSqlSession()
		.selectList("User.userSearch",map);
		return userList;
	
	}
	
	public List<User> usersFans(Map  map ) {
		List<User> userList = (List<User>) getSqlSession()
			.selectList("User.usersFans",map);
		return userList;

	}
	
	
	public User getUserByEmail(String email) {
		return (User)getSqlSession().selectOne("User.getUserByEmail",email);
	}
	
	public User getUserByID(Map map){
		return (User)getSqlSession().selectOne("User.getUserByID",map);
	}
	
	
	public void changePassword(Map param){
		getSqlSession().update("User.changePassword", param);
	}
	
	
	public User save(User model) {
		int row = getSqlSession().insert("User.insertUser",model);
		return model;
	}
	
	public void setUserImageUrl(User model) {
		int row = getSqlSession().insert("User.updateHeadUrl",model);
	}

	public void delete(User model) {
		int row = getSqlSession().insert("User.delUser",model);
	}
	
	
	public void updateinfo(User model) {
		int row = getSqlSession().insert("User.updateinfo",model);
	}

	public void update(User model) {
		int row = getSqlSession().update("User.updateUser",model);
	}


	
	
	
	
}
