package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.Vote;

public interface VoteDao {
	public List<Vote> queryVote( );
	public void save(final Vote model);
	public void update(final Vote model);
	public void delete(final Vote model);
	public int getVoteNum(Map map); 
}
