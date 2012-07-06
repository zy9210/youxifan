package com.youxifan.test;

import java.util.List;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.youxifan.dao.StudentDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class StudentDaoTest {
	@Autowired
	private StudentDao entityDao;
	
	public final void setStudentDao(StudentDao entityDao){
		this.entityDao = entityDao;
	}
	
	@Test
    public void testUniqueNum() {
		List<Object> list = entityDao.queryStudent();
        System.out.println(list);
    }
}
