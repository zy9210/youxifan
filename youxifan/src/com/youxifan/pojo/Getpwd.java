package com.youxifan.pojo;

import java.io.Serializable;
import java.util.Date;



public class Getpwd implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String getpwdstr;
	private Date modifydate;
	private Date createdate;
	private String bsflag;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBsflag() {
		return bsflag;
	}
	public void setBsflag(String bsflag) {
		this.bsflag = bsflag;
	}

	public String getGetpwdstr() {
		return getpwdstr;
	}
	public void setGetpwdstr(String getpwdstr) {
		this.getpwdstr = getpwdstr;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	
	
}
