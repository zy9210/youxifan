package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.Doc;

public interface DocDao { 
	public List<Doc> queryDoc(Map map);
	public List<Doc> usersQ(Map map);
	public List<Doc> tagsQ(Map map);
	public List<Doc> userAnsweredQ(Map map);
	public List<Doc> userFollowedQ(Map map);
	public Doc getDocByID(Map map);
	public Doc save(final Doc model);
	public void updateViews(final long docid);
	public void update(final Doc model);
	public void delete(final Doc model);
	public List<Doc> getAnswers(Long upperdocid);
}
