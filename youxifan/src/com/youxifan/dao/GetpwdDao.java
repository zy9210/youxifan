package com.youxifan.dao;

import java.util.List;
import java.util.Map;

public interface GetpwdDao {
	public Object query(String pwdstr);
	public Object save(final Object model);
	public void update(final Object model);
	public void delete(final String getpwdstr);
}
