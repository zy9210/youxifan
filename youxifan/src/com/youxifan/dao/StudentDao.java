package com.youxifan.dao;

import java.util.List;

public interface StudentDao {
	public List<Object> queryStudent( );
	public Object save(final Object model);
	public void update(final Object model);
	public void delete(final Object model);
}
