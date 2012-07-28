package com.youxifan.dao;



import com.youxifan.pojo.Getpwd;

public interface GetpwdDao {
	public Getpwd query(String pwdstr);
	public Getpwd save(final Getpwd model);
	public void update(final Getpwd model);
	public void delete(final String getpwdstr);
}
