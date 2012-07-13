package com.youxifan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youxifan.dao.GetpwdDao;
import com.youxifan.pojo.Getpwd;

@Service
public class GetpwdService {
	
	@Autowired
	private GetpwdDao entityDao;
	
	
	public Getpwd queryGetpwd(String getpwdstr){
		Getpwd getpwd = null;
		getpwd = (Getpwd) entityDao.query(getpwdstr);
		return getpwd;
	}
	
	public void save(Getpwd Getpwd){
		entityDao.save(Getpwd);
	}
	
	public void delete(String getpwdstr){
		entityDao.delete(getpwdstr);
	}
}
