package com.youxifan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;


public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;


	private long tagid;
	private long fatherid = 0;
	private String tagname;
	private BigDecimal tagpoint;
	private String tagtype;
	private long  followers;
	private String bsflag = "1";
	private int followed;
	
	
	public int getFollowed(){
		return this.followed;
	}
	
	public void setFollowed(int followed){
		this.followed = followed;
	}
	
	public long getTagid() {
		return tagid;
	}
	public void setTagid(long tagid) {
		this.tagid = tagid;
	}
	public long getFatherid() {
		return fatherid;
	}
	public void setFatherid(long fatherid) {
		this.fatherid = fatherid;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public BigDecimal getTagpoint() {
		return tagpoint;
	}
	public void setTagpoint(BigDecimal tagpoint) {
		this.tagpoint = tagpoint;
	}
	public String getTagtype() {
		return tagtype;
	}
	public void setTagtype(String tagtype) {
		this.tagtype = tagtype;
	}
	public long getFollowers() {
		return followers;
	}
	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	public String getBsflag() {
		return bsflag;
	}
	public void setBsflag(String bsflag) {
		this.bsflag = bsflag;
	}
	
	
}
