package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Doc;

public class DocDaoImpl extends SqlSessionDaoSupport implements DocDao{
	

	
	//根据sort分组 有分页
	public List<Doc> queryDoc(Map map) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.queryDoc",map);
		return docList;

	} 
	
	public List<Doc> docSearch(Map map){
		List<Doc> docList = (List<Doc>) getSqlSession()
				.selectList("Doc.searchDoc",map);
		return docList; 
	}
	
	//根据userid去question 有分页
	public List<Doc> usersQ(Map map) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.usersQuestion",map);
		return docList; 
	} 
	
	//根据tagid去question 有分页
	public List<Doc> tagsQ(Map map) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.queryTagDoc",map);
		return docList; 
	} 
	
	
	//根据userid去查回答过的问题 有分页
	public List<Doc> userAnsweredQ(Map map) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.userAnsweredQ",map);
		return docList; 
	} 
	
	//根据userid去查关注过的问题 有分页
	public List<Doc> userFollowedQ(Map map) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.userFollowedQ",map);
		return docList; 
	} 
	
	
	public List<Doc> getAnswers(Map map ) {
		List<Doc> docList = (List<Doc>) getSqlSession()
			.selectList("Doc.getAnswers",map);
		return docList;

	} 
	
	public Doc save(Doc model) {
		int row = getSqlSession().insert("Doc.insertDoc",model);
		return model;
	}
	
	public void updateViews(long docid) {
		int row = getSqlSession().update("Doc.updateViews",docid);
	}

	public void updateVotes(Map map){
		int row = getSqlSession().update("Doc.updateVotes",map);
	}
	
	public void updateAnswers(Map map){
		int row = getSqlSession().update("Doc.updateAnswers",map);
	}
	
	public Doc getDocByID(Map map) {
		return (Doc)getSqlSession().selectOne("Doc.selbyid", map);
	}
	

	public void delete(Doc model) {
		int row = getSqlSession().insert("Doc.delDoc",model);
	}


	public void update(Map map) {
		int row = getSqlSession().update("Doc.updateDoc",map);
	}
	


	
	
	
	
}
