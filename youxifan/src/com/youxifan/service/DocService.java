package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.StudentDao;
import com.youxifan.dao.StudentDaoImpl;
import com.youxifan.dao.DocDao;
import com.youxifan.dao.TagDao;
import com.youxifan.pojo.Student;
import com.youxifan.pojo.Doc;
import com.youxifan.utils.CommonUtil;
import com.sun.jmx.snmp.daemon.CommunicationException;

@Service
public class DocService {
	@Autowired
	private DocDao entityDao;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private VoteService voteService;
	 
	/*
	 * doc页面展示  根据tab排序 有分页
	 */
	@Transactional
	public List<Doc> queryDoc(Map map){
		List<Doc> list = entityDao.queryDoc(map);
		
		for (Doc doc : list) {
			doc.setTags(tagService.queryByDocid(doc.getDocid()));
		}
		return list;
	}
	
	/*
	 * 根据tagid取question 有分页
	 */
	public List<Doc> tagsQ(Map map){
		List<Doc> list = entityDao.tagsQ(map);
		for (Doc doc : list) {
			doc.setTags(tagService.queryByDocid(doc.getDocid()));
		}
		return list;
	} 
	
	
	/*
	 * 根据模糊查询doc 有分页
	 */
	public List<Doc> docSearch(Map map){
		List<Doc> list = entityDao.docSearch(map);
		for (Doc doc : list) {
			doc.setTags(tagService.queryByDocid(doc.getDocid()));
		}
		return list;
	}
	
	
	
	/*
	 * 根据userid取question 有分页
	 */
	public List<Doc> usersQ(Map map){
		List<Doc> list = entityDao.usersQ(map);
		for (Doc doc : list) {
			doc.setTags(tagService.queryByDocid(doc.getDocid()));
		}
		return list;
	} 
	
	
	/*
	 * 根据userid取回答过的问题 有分页
	 */
	public List<Doc> userAnsweredQ(Map map){
		List<Doc> list = entityDao.userAnsweredQ(map);
		for (Doc doc : list) {
			doc.setTags(tagService.queryByDocid(doc.getDocid()));
		}
		return list;
	}
	
	/*
	 * 根据userid取关注过的问题 有分页
	 */
	public List<Doc> userFollowedQ(Map map){
		List<Doc> list = entityDao.userFollowedQ(map);
		for (Doc doc : list) {
			doc.setTags(tagService.queryByDocid(doc.getDocid()));
		}
		return list;
	}
	
	
	public Doc getDocByID(Map map){
		Doc doc = null;
		doc = (Doc) entityDao.getDocByID(map);
		if (doc == null) {
			return null;
		}
		doc.setAnswers(entityDao.getAnswers(map));
		
		doc.setTags(tagService.queryByDocid(doc.getDocid()));
		entityDao.updateViews(doc.getDocid());
		return doc;
	}
	
	public void updateVotes(int addend,long docid){
		Map map = new HashMap();
		map.put("addend", addend);
		map.put("docid",docid);
		entityDao.updateVotes(map);
	}
	
	public void updateAnswers(int addend,long docid){
		Map map = new HashMap();
		map.put("addend", addend);
		map.put("docid",docid);
		entityDao.updateAnswers(map);
	}
	
	public void save(Doc doc){ 
		doc.setTitle(StringEscapeUtils.escapeHtml4(doc.getTitle()));
		entityDao.save(doc);
	}
	
	public void update(Map map){ 
		entityDao.update(map);
	}
	
	public void delete(Doc obj){
		entityDao.delete(obj);
	}
}
