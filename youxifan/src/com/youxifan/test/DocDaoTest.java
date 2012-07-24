package com.youxifan.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


import com.youxifan.dao.DocDao;
import com.youxifan.pojo.Doc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DocDaoTest {
	@Autowired
	private DocDao docDao;
	
	public final void setDocDao(DocDao docDao){
		this.docDao = docDao;
	}
	
	
	 
    public void testInsertDoc() {
		Doc doc = new Doc();
		doc.setTitle("的法定分");
		doc.setContent("林肯郡阿历克斯登九峰楼可能从vladj");
		doc.setCreaterid(123);
		doc.setDoctype("1");
		doc.setBsflag("1");
		docDao.save(doc);
    }
	
	
	@Test
    public void testQueryDoc() {
		List<Object> list = null;//docDao.queryDoc();
		Doc doc = null;
		for (int i = 0; i<list.size(); i++) {
			doc = (Doc) list.get(i);
			System.out.println(doc.getDocid()+"-title:"+doc.getTitle()+"-content:"+doc.getContent()+doc.getCreaterid()+"-"+doc.getCreatedate());
			System.out.println(doc.getCreater().getUserid()+doc.getCreater().getUsername()+"-"+doc.getCreater().getCreatedate());
		}
    }
	
	
}
