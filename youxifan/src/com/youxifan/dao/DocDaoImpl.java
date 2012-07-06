package com.youxifan.dao;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Doc;

public class DocDaoImpl extends SqlSessionDaoSupport implements DocDao{
	

	public List<Object> query( ) {
		List<Object> docList = (List<Object>) getSqlSession()
			.selectList("Doc.queryDoc");
		return docList;

	} 
	public List<Object> queryDoc( ) {
		List<Object> docList = (List<Object>) getSqlSession()
			.selectList("Doc.queryDocq");
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
