package com.youxifan.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class VoteDaoImpl extends SqlSessionDaoSupport implements VoteDao{
	

	public List<Object> queryVote( ) {
		List<Object> selectList = (List<Object>) getSqlSession()
			.selectList("Vote.queryVote");
		return selectList;

	}


	public void delete(Object model) {
		int row = getSqlSession().insert("Vote.delVote",model);
	}


	public Object save(Object model) {
		int row = getSqlSession().insert("Vote.insertVote",model);
		return model;
	}


	public void update(Object model) {
		int row = getSqlSession().update("Vote.updateVote",model);
	} 
	
	
	
	
}
