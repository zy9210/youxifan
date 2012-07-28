package com.youxifan.dao;

import com.youxifan.pojo.Follow;
 
public interface FollowDao { 
	public Follow save(final Follow model); 
	public void delete(final Follow model);
}
