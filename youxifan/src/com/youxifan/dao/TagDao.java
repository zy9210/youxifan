package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.Tag;

public interface TagDao {
	public List<Tag> queryTag( );
	public Tag save(final Tag model);
	public void update(final Tag model);
	public void delete(final Tag model);
	public List<Tag> queryByFatherID(long fatherid);
	public List<Tag> queryByFatherStr(String fatherStr);
	public List<Tag> queryByDocid(long docid);
	public List<Tag> userFollowedTag(Map map);
	public Tag findTag(Map map);
	public Tag findTagbyName(String tagStr);
	public Tag findTagbyID(Map map);
	public List<Tag> tagSearch(Map map);
}
