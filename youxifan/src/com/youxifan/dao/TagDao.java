package com.youxifan.dao;

import java.util.List;
import java.util.Map;

public interface TagDao {
	public List<Object> queryTag( );
	public Object save(final Object model);
	public void update(final Object model);
	public void delete(final Object model);
	public List<Object> queryByFatherID(long fatherid);
	public List<Object> queryByFatherStr(String fatherStr);
	public Object findTag(Map map);
	public Object findTag(String tagStr);
}
