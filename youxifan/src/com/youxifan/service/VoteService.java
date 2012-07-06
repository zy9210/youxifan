package com.youxifan.service;

import java.util.List;

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
	
	
	public List<Object> getVList(){
		List<Object> list = voteDao.queryVote();
		return list;
	}
	
	public void save(Vote vote){
		voteDao.save(vote);
	}
	
	
	public void delete(Object obj){
		voteDao.delete(obj);
	}
}
