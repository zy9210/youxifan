package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.Suggestion; 

public interface SuggestionDao {
	public List<Suggestion> querySuggestion(Map map );
	public void save(final Suggestion model);
	public void update(final Suggestion model);
	public void delete(final Suggestion model);
	
}
