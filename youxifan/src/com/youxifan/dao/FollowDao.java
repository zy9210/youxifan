package com.youxifan.dao;

import java.util.Map;

import com.youxifan.pojo.Follow;
 
public interface FollowDao { 
	public Follow save(final Follow model); 
	public void delete(final Follow model);
	public int countFollower(Map map);
	public int countUpper(Map map);
}
