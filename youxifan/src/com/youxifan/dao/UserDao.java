package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.User;

public interface UserDao {
	public List<User> query( );
	public User save(final User model);
	public void update(final User model);
	public void setUserImageUrl(final User model);
	public void delete(final User model);
	public User getUserByEmail(String email);
	public User getUserByID(Map map);
	public void changePassword(Map param);
	public List<User> userFollowedUser(Map  map );
	public List<User> usersFans(Map  map );
}
