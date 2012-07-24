package com.youxifan.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.StudentDao;
import com.youxifan.dao.StudentDaoImpl;
import com.youxifan.dao.DocDao;
import com.youxifan.pojo.Student;
import com.youxifan.pojo.Doc;
import com.youxifan.utils.CommonUtil;
import com.sun.jmx.snmp.daemon.CommunicationException;

@Service
public class DocService {
	@Autowired
	private DocDao entityDao;
	
	
	 
	/*
	 * 根据sort分组 有分页
	 */
	@Transactional
	public List<Object> queryDoc(Map map){
		List<Object> list = entityDao.queryDoc(map);
		return list;
	}
	/*
	 * 根据userid取question 有分页
	 */
	public List<Object> usersQ(Map map){
		List<Object> list = entityDao.usersQ(map);
		return list;
	} 
	
	
	/*
	 * 根据userid取回答过的问题 有分页
	 */
	public List<Object> userAnsweredQ(Map map){
		List<Object> list = entityDao.userAnsweredQ(map);
		return list;
	}
	
	/*
	 * 根据userid取关注过的问题 有分页
	 */
	public List<Object> userFollowedQ(Map map){
		List<Object> list = entityDao.userFollowedQ(map);
		return list;
	}
	
	
	public Doc getDocByID(Long docid){
		Doc doc = null;
		doc = (Doc) entityDao.getDocByID(docid);
		doc.setAnswers(entityDao.getAnswers(docid));
		entityDao.updateViews(docid);
		return doc;
	}
	
	
	public void save(Doc doc){
		entityDao.save(doc);
	}
	
	public void delete(Object obj){
		entityDao.delete(obj);
	}
}
