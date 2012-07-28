package com.youxifan.dao;

import java.util.List;

import com.youxifan.pojo.Vote;

public interface VoteDao {
	public List<Vote> queryVote( );
	public Vote save(final Vote model);
	public void update(final Vote model);
	public void delete(final Vote model);
}
