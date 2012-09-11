package com.youxifan.dao;

import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Suggestion; 

public class SuggestionDaoImpl extends SqlSessionDaoSupport implements SuggestionDao{
	

	public List<Suggestion> querySuggestion(Map map ) {
		List<Suggestion> selectList = (List<Suggestion>) getSqlSession()
			.selectList("Suggestion.querySuggestion",map);
		return selectList;

	}
	
	 

	public void delete(Suggestion model) {
		int row = getSqlSession().insert("Suggestion.delSuggestion",model);
	}


	public void save(Suggestion model) {
		int row = getSqlSession().insert("Suggestion.insertSuggestion",model); 
	}


	public void update(Suggestion model) {
		int row = getSqlSession().update("Suggestion.updateSuggestion",model);
	} 
	
	
	
	
}
