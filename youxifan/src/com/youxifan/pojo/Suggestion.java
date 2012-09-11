package com.youxifan.pojo;

import java.io.Serializable;



public class Suggestion implements Serializable {
	private static final long serialVersionUID = 1L;


	private long sugid;
	private long uppersugid;
	private long userid;
	private String contact  ;
	private String content  ;
	private String bsflag = "1";
	private String sugtype = "1";
	public long getSugid() {
		return sugid;
	}
	public void setSugid(long sugid) {
		this.sugid = sugid;
	}
	public long getUppersugid() {
		return uppersugid;
	}
	public void setUppersugid(long uppersugid) {
		this.uppersugid = uppersugid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBsflag() {
		return bsflag;
	}
	public void setBsflag(String bsflag) {
		this.bsflag = bsflag;
	}
	public String getSugtype() {
		return sugtype;
	}
	public void setSugtype(String sugtype) {
		this.sugtype = sugtype;
	} 
	
	
	
}
