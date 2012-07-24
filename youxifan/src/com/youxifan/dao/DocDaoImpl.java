package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Doc;

public class DocDaoImpl extends SqlSessionDaoSupport implements DocDao{
	

	
	//根据sort分组 有分页
	public List<Object> queryDoc(Map map) {
		List<Object> docList = (List<Object>) getSqlSession()
			.selectList("Doc.queryDoc",map);
		return docList;

	} 
	
	//根据userid去question 有分页
	public List<Object> usersQ(Map map) {
		List<Object> docList = (List<Object>) getSqlSession()
			.selectList("Doc.usersQuestion",map);
		return docList; 
	} 
	
	//根据userid去查回答过的问题 有分页
	public List<Object> userAnsweredQ(Map map) {
		List<Object> docList = (List<Object>) getSqlSession()
			.selectList("Doc.userAnsweredQ",map);
		return docList; 
	} 
	
	//根据userid去查关注过的问题 有分页
	public List<Object> userFollowedQ(Map map) {
		List<Object> docList = (List<Object>) getSqlSession()
			.selectList("Doc.userFollowedQ",map);
		return docList; 
	} 
	
	
	public List<Doc> getAnswers(Long upperdocid ) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.getAnswers",upperdocid);
		return docList;

	} 
	
	public Object save(Object model) {
		int row = getSqlSession().insert("Doc.insertDoc",model);
		return model;
	}
	
	public void updateViews(long docid) {
		int row = getSqlSession().update("Doc.updateViews",docid);
	}

	public Object getDocByID(Long docid) {
		return getSqlSession().selectOne("Doc.selbyid", docid);
	}
	

	public void delete(Object model) {
		int row = getSqlSession().insert("Doc.delDoc",model);
	}


	public void update(Object model) {
		int row = getSqlSession().update("Doc.updateDoc",model);
	}
	


	
	
	
	
}
