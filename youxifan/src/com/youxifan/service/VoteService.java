package com.youxifan.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.VoteDao;
import com.youxifan.pojo.Vote;

@Service
public class VoteService {
	@Autowired
	private VoteDao voteDao;
	
	
	public int getVoteNum(Map map){
		return voteDao.getVoteNum(map);
	}
	public List<Vote> getVList(){
		List<Vote> list = voteDao.queryVote();
		return list;
	}
	
	public void save(Vote vote){
		voteDao.save(vote);
	}
	
	
	public void delete(Vote obj){
		voteDao.delete(obj);
	}
}
