package com.youxifan.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


import com.youxifan.dao.TagDao;
import com.youxifan.dao.UserDao;
import com.youxifan.pojo.Tag;
import com.youxifan.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TagDaoTest {
	@Autowired
	private TagDao tagDao;

	
	@Test
    public void testSaveTag() {
		Tag tag = new Tag();
		tag.setTagname("");
		tagDao.save(tag);
    }
	
	@Test
    public void testQueryUser() {
		List<Object> list = tagDao.queryTag();
		Tag tag = null;
		for (int i = 0; i<list.size(); i++) {
			tag = (Tag) list.get(i);
			System.out.println(tag.getTagname());
		}
    }
	
	
}
