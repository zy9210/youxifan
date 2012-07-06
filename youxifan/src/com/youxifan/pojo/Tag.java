package com.youxifan.pojo;

import java.io.Serializable;



public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;


	private long tagid;
	private String tagname;
	private long tagpoint;
	
	
	public long getTagid() {
		return tagid;
	}
	public void setTagid(long tagid) {
		this.tagid = tagid;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public long getTagpoint() {
		return tagpoint;
	}
	public void setTagpoint(long tagpoint) {
		this.tagpoint = tagpoint;
	}
	
}
