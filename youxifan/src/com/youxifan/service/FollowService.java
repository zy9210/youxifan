package com.youxifan.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.FollowDao; 
import com.youxifan.pojo.Follow;

@Service
public class FollowService {
	
	@Autowired
	private FollowDao followDao;
	
	@Transactional
	public List<Object> getUserList(){ 
		return null;
	}
	
	public void save(Follow follow){
		followDao.save(follow);
	}
	
	
	public void delete(Object obj){
		followDao.delete(obj);
	}
}