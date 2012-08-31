package com.youxifan.dao;

import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Vote;

public class VoteDaoImpl extends SqlSessionDaoSupport implements VoteDao{
	

	public List<Vote> queryVote( ) {
		List<Vote> selectList = (List<Vote>) getSqlSession()
			.selectList("Vote.queryVote");
		return selectList;

	}
	
	public int getVoteNum(Map map){
		return (Integer) getSqlSession().selectOne("Vote.getVoteNum", map);
	}

	public void delete(Vote model) {
		int row = getSqlSession().insert("Vote.delVote",model);
	}


	public void save(Vote model) {
		int row = getSqlSession().insert("Vote.insertVote",model); 
	}


	public void update(Vote model) {
		int row = getSqlSession().update("Vote.updateVote",model);
	} 
	
	
	
	
}
