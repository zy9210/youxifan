package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import org.apache.commons.lang3.StringEscapeUtils; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.youxifan.dao.SuggestionDao;  
import com.youxifan.pojo.Suggestion;

@Service
public class SuggestionService {
	@Autowired
	private SuggestionDao suggestionDao;
	
	 
	public List<Suggestion> getSugList(int start,int step){
		Map map = new HashMap();
		map.put("start", start);
		map.put("step", step);
		List<Suggestion> list = suggestionDao.querySuggestion(map);
		return list;
	}
	
	public void save(Suggestion obj){
		obj.setContact(StringEscapeUtils.escapeHtml4(obj.getContact()));
		obj.setContent(StringEscapeUtils.escapeHtml4(obj.getContent()));
		suggestionDao.save(obj);
	}
	
	
	public void delete(Suggestion obj){
		suggestionDao.delete(obj);
	}
}
