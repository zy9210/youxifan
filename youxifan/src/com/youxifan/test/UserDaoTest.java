package com.youxifan.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


import com.youxifan.dao.UserDao;
import com.youxifan.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	public final void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Test
    public void testQueryUser() {
		List<User> list = userDao.query();
		User user = null;
		for (int i = 0; i<list.size(); i++) {
			user = (User) list.get(i);
			System.out.println(user.getUsername());
		}
    }
	
	@Test
    public void testGetUserByEmail() {
		User user = (User) userDao.getUserByEmail("zy921");
		if (user ==null) {
			return;
		}
		System.out.println(user.getUsername());
    }
}
