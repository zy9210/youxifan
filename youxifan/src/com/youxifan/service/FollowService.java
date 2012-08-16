package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.FollowDao; 
import com.youxifan.pojo.Follow;

@Service
public class FollowService {
	
	@Autowired
	private FollowDao followDao;
	 
	
	public void save(Follow follow){
		followDao.save(follow);
	}
	
	
	public void delete(Follow obj){
		followDao.delete(obj);
	}
	
	public int countUserFans(long userid){
		Map map = new HashMap();
		map.put("upper", userid);
		map.put("type", "1");
		return this.countFollower(map);
	}
	
	public int countUserFollowed(long userid){
		Map map = new HashMap();
		map.put("follower", userid);
		map.put("type", "1");
		return this.countUpper(map);
	}
	
	/*
	 * upper
	 * type
	 */
	public int countFollower(Map map){
		return  followDao.countFollower(map) ;
		 
	}
	
	/*
	 * follower
	 * type
	 */
	public int countUpper(Map map){
		return  followDao.countUpper(map) ;
	}
}
