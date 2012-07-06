package com.youxifan.pojo;

import java.io.Serializable;



public class Vote implements Serializable {
	private static final long serialVersionUID = 1L;


	private long voteid;
	private long voterid;
	private long bevotedid;
	private String vote_type;
	
	public long getVoteid() {
		return voteid;
	}
	public void setVoteid(long voteid) {
		this.voteid = voteid;
	}
	public long getVoterid() {
		return voterid;
	}
	public void setVoterid(long voterid) {
		this.voterid = voterid;
	}
	public long getBevotedid() {
		return bevotedid;
	}
	public void setBevotedid(long bevotedid) {
		this.bevotedid = bevotedid;
	}
	public String getVote_type() {
		return vote_type;
	}
	public void setVote_type(String vote_type) {
		this.vote_type = vote_type;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	

}
