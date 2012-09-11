package com.youxifan.pojo;

import java.io.Serializable;
import java.sql.Date;



public class Invite implements Serializable {
	private static final long serialVersionUID = 1L;


	private long inviteid;
	private long ownerid;
	private String invitestr;
	private long userid;
	private Date usedate;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public long getInviteid() {
		return inviteid;
	}
	public void setInviteid(long inviteid) {
		this.inviteid = inviteid;
	}
	public long getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}
	public String getInvitestr() {
		return invitestr;
	}
	public void setInvitestr(String invitestr) {
		this.invitestr = invitestr;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public Date getUsedate() {
		return usedate;
	}
	public void setUsedate(Date usedate) {
		this.usedate = usedate;
	}
	
	

}
