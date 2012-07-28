package com.youxifan.dao;

 


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Getpwd;

public class GetpwdDaoImpl extends SqlSessionDaoSupport implements GetpwdDao{
	


	
	public Getpwd query(String getpwdstr){
		Getpwd o = (Getpwd) getSqlSession().selectOne("Getpwd.queryGetpwd", getpwdstr);
		return o; 
	}

	public void delete(String getpwdstr) {
		int row = getSqlSession().update("Getpwd.delGetpwd",getpwdstr);
	}


	public Getpwd save(Getpwd model) {
		int row = getSqlSession().insert("Getpwd.insertGetpwd",model);
		return model;
	}


	public void update(Getpwd model) {
		int row = getSqlSession().update("Getpwd.updateGetpwd",model);
	}

	
	
	
}
