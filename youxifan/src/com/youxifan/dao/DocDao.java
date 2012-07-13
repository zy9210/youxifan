package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.Doc;

public interface DocDao {
	public List<Object> query( );
	public List<Object> queryDoc( );
	public List<Object> newestDoc(Map map);
	public Object getDocByID(Long docid);
	public Object save(final Object model);
	public void updateViews(final long docid);
	public void update(final Object model);
	public void delete(final Object model);
	public List<Doc> getAnswers(Long upperdocid);
}
