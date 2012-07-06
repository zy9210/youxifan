package com.youxifan.test;
 
import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import com.youxifan.pojo.User;
import com.youxifan.utils.PropertiesUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PropertiesUtilTest {

	@Autowired
	private PropertiesUtil p ; 
	
	@Test
    public void testProperty() {  
        System.out.println(p.getProperty("aa.bb"));
        System.out.println(p.getProperty("userdaoimpl"));
    }
}
