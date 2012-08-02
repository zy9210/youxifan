package com.youxifan.dao;

import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Tag;

public class TagDaoImpl extends SqlSessionDaoSupport implements TagDao{
	

	public List<Tag> queryTag( ) {
		List<Tag> selectList = (List<Tag>) getSqlSession()
			.selectList("Tag.queryTag");
		return selectList;

	}
	public List<Tag> queryByDocid(long docid){
		List<Tag> selectList = (List<Tag>) getSqlSession()
		.selectList("Tag.queryTagByDocid",docid);
		return selectList;
	}
	
	
	public List<Tag> userFollowedTag(Map map){
		List<Tag> selectList = (List<Tag>) getSqlSession()
		.selectList("Tag.queryUserFollowedTag",map);
		return selectList;
	}
	/* 
	 *  模糊tag查询
	 *  tagStr  start  end 
	 *  */
	public List<Tag> tagSearch(Map map){
		List<Tag> selectList = (List<Tag>) getSqlSession()
		.selectList("Tag.queryTagLikeName",map);
		return selectList; 
	}
	
	
	public Tag findTag(Map map){
		return (Tag)getSqlSession().selectOne("Tag.findTagByFatherStr", map);
	}
	
	public Tag findTagbyName(String tagStr){
		return (Tag)getSqlSession().selectOne("Tag.findTagByTagStr", tagStr);
	}
	
	public Tag findTagbyID(Map map){ 
		return (Tag)getSqlSession().selectOne("Tag.findTagByTagID", map);
	}
	
	public List<Tag> queryByFatherID(long fatherid) {
		List<Tag> selectList = (List<Tag>) getSqlSession()
			.selectList("Tag.queryTagByFatherID",fatherid);
		return selectList;

	}
	
	public List<Tag> queryByFatherStr(String fatherStr) {
		List<Tag> selectList = (List<Tag>) getSqlSession()
			.selectList("Tag.queryTagByFatherStr",fatherStr);
		return selectList;

	}
	


	public void delete(Tag model) {
		int row = getSqlSession().insert("Tag.delTag",model);
	}


	public Tag save(Tag model) {
		int row = getSqlSession().insert("Tag.insertTag",model);
		return model;
	}


	public void update(Tag model) {
		int row = getSqlSession().update("Tag.updateTag",model);
	} 
	
	
	
	
}
