package com.youxifan.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.youxifan.utils.CommonUtil;



public class Doc implements Serializable {
	private static final long serialVersionUID = 1L;


	private long docid;
	private long upperdocid;
	private String title;
	private String content;
	private long createrid;
	private String creatername;  
	private String bsflag;
	private String doctype;
	private BigDecimal docpoint;	
	private long views;
	private long answer;
	private Date modifydate;
	private Date createdate;
	private User creater;
	private int followed;
	private List<Doc> answers;
	private List<Tag> tags;
	
	
	public int getFollowed(){
		return this.followed;
	}
	
	public void setFollowed(int followed){
		this.followed = followed;
	}
	
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	
	
	public long getAnswer() {
		return answer;
	}
	public void setAnswer(long answer) {
		this.answer = answer;
	}
	
	
	public long getViews() {
		return views;
	}
	public void setViews(long views) {
		this.views = views;
	}

	public long getDocid() {
		return docid;
	}
	public void setDocid(long docid) {
		this.docid = docid;
	}
	public long getUpperdocid() {
		return upperdocid;
	}
	public void setUpperdocid(long upperdocid) {
		this.upperdocid = upperdocid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCreaterid() {
		return createrid;
	}
	public void setCreaterid(long createrid) {
		this.createrid = createrid;
	}
	public String getCreatername() {
		return creatername;
	}
	public void setCreatername(String creatername) {
		this.creatername = creatername;
	}
	public String getBsflag() {
		return bsflag;
	}
	public void setBsflag(String bsflag) {
		this.bsflag = bsflag;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public BigDecimal getDocpoint() {
		return docpoint;
	}
	public void setDocpoint(BigDecimal docpoint) {
		this.docpoint = docpoint;
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
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
	public List<Doc> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Doc> answers) {
		this.answers = answers;
	}
	
	public String getCreatedateStr() {
		return CommonUtil.getDateTimeStr(this.createdate,null);
	}
	
	public String getModifydateStr() {
		return CommonUtil.getDateTimeStr(this.modifydate,null);
	}
	
	

}
