package com.youxifan.dao;

import java.util.List;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Vote;

public class VoteDaoImpl extends SqlSessionDaoSupport implements VoteDao{
	

	public List<Vote> queryVote( ) {
		List<Vote> selectList = (List<Vote>) getSqlSession()
			.selectList("Vote.queryVote");
		return selectList;

	}


	public void delete(Vote model) {
		int row = getSqlSession().insert("Vote.delVote",model);
	}


	public Vote save(Vote model) {
		int row = getSqlSession().insert("Vote.insertVote",model);
		return model;
	}


	public void update(Vote model) {
		int row = getSqlSession().update("Vote.updateVote",model);
	} 
	
	
	
	
}
