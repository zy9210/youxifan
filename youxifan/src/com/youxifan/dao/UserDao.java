package com.youxifan.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	public List<Object> query( );
	public Object save(final Object model);
	public void update(final Object model);
	public void setUserImageUrl(final Object model);
	public void delete(final Object model);
	public Object getUserByEmail(String email);
	public void changePassword(Map param);
}
