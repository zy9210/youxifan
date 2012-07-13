package com.youxifan.dao;

 


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class GetpwdDaoImpl extends SqlSessionDaoSupport implements GetpwdDao{
	


	
	public Object query(String getpwdstr){
		Object o =  getSqlSession().selectOne("Getpwd.queryGetpwd", getpwdstr);
		return o; 
	}

	public void delete(String getpwdstr) {
		int row = getSqlSession().update("Getpwd.delGetpwd",getpwdstr);
	}


	public Object save(Object model) {
		int row = getSqlSession().insert("Getpwd.insertGetpwd",model);
		return model;
	}


	public void update(Object model) {
		int row = getSqlSession().update("Getpwd.updateGetpwd",model);
	}

	
	
	
}
