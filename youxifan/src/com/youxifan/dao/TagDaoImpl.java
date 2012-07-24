package com.youxifan.dao;

import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TagDaoImpl extends SqlSessionDaoSupport implements TagDao{
	

	public List<Object> queryTag( ) {
		List<Object> selectList = (List<Object>) getSqlSession()
			.selectList("Tag.queryTag");
		return selectList;

	}
	
	public Object findTag(Map map){
		return getSqlSession().selectOne("Tag.findTagByFatherStr", map);
	}
	
	public Object findTag(String tagStr){
		return getSqlSession().selectOne("Tag.findTagByTagStr", tagStr);
	}
	
	public List<Object> queryByFatherID(long fatherid) {
		List<Object> selectList = (List<Object>) getSqlSession()
			.selectList("Tag.queryTagByFatherID",fatherid);
		return selectList;

	}
	
	public List<Object> queryByFatherStr(String fatherStr) {
		List<Object> selectList = (List<Object>) getSqlSession()
			.selectList("Tag.queryTagByFatherStr",fatherStr);
		return selectList;

	}
	


	public void delete(Object model) {
		int row = getSqlSession().insert("Tag.delTag",model);
	}


	public Object save(Object model) {
		int row = getSqlSession().insert("Tag.insertTag",model);
		return model;
	}


	public void update(Object model) {
		int row = getSqlSession().update("Tag.updateTag",model);
	} 
	
	
	
	
}
