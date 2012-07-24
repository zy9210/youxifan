package com.youxifan.pojo;

import java.io.Serializable;
import java.util.Date;

import com.youxifan.utils.CommonUtil;


 



public class Follow implements Serializable {
	private static final long serialVersionUID = 1L;


	private long followId;
	
	private long upper;
	private long follower;
	private Date createDate;
	private Date modifyDate;
	private String followType;
	
	public long getFollowId() {
		return followId;
	}
	public void setFollowId(long followId) {
		this.followId = followId;
	}
	public long getUpper() {
		return upper;
	}
	public void setUpper(long upper) {
		this.upper = upper;
	}
	public long getFollower() {
		return follower;
	}
	public void setFollower(long follower) {
		this.follower = follower;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getFollowType() {
		return followType;
	}
	public void setFollowType(String followType) {
		this.followType = followType;
	}
	public String getCreateDateStr() {
		return CommonUtil.getDateTimeStr(this.createDate,null);
	}
	
	public String getModifyDateStr() {
		return CommonUtil.getDateTimeStr(this.modifyDate,null);
	}
}
