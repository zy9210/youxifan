package com.youxifan.pojo;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.youxifan.utils.CommonUtil;



public class User implements Serializable {
	private static final long serialVersionUID = 1L;


	private long userid;
	
	private String userlevel;
	private String username;
	private String signing;
	private long userpoint;
	private String alias;  
	private String bsflag;
	private String email;
	private String imageurl;
	private String password;
	private Date modifydate;
	private Date createdate;
	private String gender;
	//查看他人页面时   是否关注该人  1：关注   0：未关注
	private int isFollowed;
	 
	private String game;
	
	//我关注的人的个数
	private int myFollowed;
	//我的fans个数
	private int myFans;
	
	public int getMyFollowed() {
		return myFollowed;
	}
	public void setMyFollowed(int myFollowed) {
		this.myFollowed = myFollowed;
	}
	public int getMyFans() {
		return myFans;
	}
	public void setMyFans(int myFans) {
		this.myFans = myFans;
	}
	public String getGameTagStr() {
		if (StringUtils.isEmpty(this.game)) {
			return "";
		}
		return  "'"+ game.replace(",", "','")+"'"; 
	} 
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getIsFollowed(){
		return this.isFollowed;
	}
	
	public void setIsFollowed(int isFollowed){
		this.isFollowed = isFollowed;
	}
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(String userlevel) {
		this.userlevel = userlevel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSigning() {
		return signing;
	}
	public void setSigning(String signing) {
		this.signing = signing;
	}
	public long getUserpoint() {
		return userpoint;
	}
	public void setUserpoint(long userpoint) {
		this.userpoint = userpoint;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getBsflag() {
		return bsflag;
	}
	public void setBsflag(String bsflag) {
		this.bsflag = bsflag;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
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
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreatedateStr() {
		return CommonUtil.getDateTimeStr(this.createdate,null);
	}
	
	public String getModifydateStr() {
		return CommonUtil.getDateTimeStr(this.modifydate,null);
	}


}
