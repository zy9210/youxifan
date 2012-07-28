package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.controller.DocController;
import com.youxifan.dao.FollowDao;
import com.youxifan.dao.TagDao;
import com.youxifan.pojo.Follow;
import com.youxifan.pojo.Tag;

@Service
public class TagService {
	
	protected final transient Log log = LogFactory
	.getLog(TagService.class);
	
	@Autowired
	private TagDao tagDao;
	@Autowired
	private FollowDao followDao;
	
	@Transactional
	public List<Tag> getUserList(){
		List<Tag> list = tagDao.queryTag();
		return list;
	}
	
	public List<Tag> userFollowedTag(Map map){
		return tagDao.userFollowedTag(map);
	}
	
	/*
	 * 根据父标签id查找子标签
	 */
	public List<Tag> queryByFatherID(long fatherid){
		List<Tag> list = tagDao.queryByFatherID(fatherid);
		return list;
	}
	
	/*
	 * 根据父标签字符串查找子标签
	 */
	public List<Tag> queryByFatherStr(String fatherStr){
		List<Tag> list = tagDao.queryByFatherStr(fatherStr);
		return list;
	}
	
	/*
	 * 根据docid查找文档的标签
	 */
	public List<Tag> queryByDocid(long docid){
		List<Tag> list = tagDao.queryByDocid(docid);
		return list;
	}
	
	
	/*
	 * map:fatherStr,tagStr
	 */
	public Tag findTag(String fatherStr ,String tagStr){
		Map map = new HashMap();
		map.put("fatherStr", fatherStr);
		map.put("tagStr", tagStr);
		
		return tagDao.findTag(map);
	}
	
	/*
	 * tagStr
	 */
	public Tag findTagbyName(String tagStr){ 
		
		return (Tag)tagDao.findTagbyName(tagStr);
	}
	
	/*
	 * tagID
	 */
	public Tag findTagbyID(Map map){ 
		
		return (Tag)tagDao.findTagbyID(map);
	}
	
	
	public boolean isExist(String fatherStr ,String tagStr){
		boolean retVal = false;
		Tag tag = (Tag)findTag(fatherStr, tagStr);
		if (tag != null) {
			retVal = true;
		}
		return retVal;
	}

	public void saveTagStr(long docid,String fatherStr ,String tagListStr ){
		String[] tagAry = tagListStr.split(",");
		
		long fatherID = 0;
		Tag fatherTag = findTagbyName(fatherStr);
		if (fatherTag == null) {
			Tag t = new Tag();
			t.setFatherid(0);
			t.setBsflag("1");
			t.setTagname(fatherStr.trim());
			save(t);
			fatherID = t.getTagid();
		}else {
			fatherID = fatherTag.getTagid();
		}
		
		for (String tagStr : tagAry) {
			Tag tag = (Tag)findTag(fatherStr, tagStr.trim());
			if (tag != null) {
				insertTagFollow(tag.getTagid(),docid);
			}else {
				Tag t = new Tag();
				t.setFatherid(fatherID);
				t.setBsflag("1");
				t.setTagname(tagStr.trim());
				save(t);
				insertTagFollow(t.getTagid(),docid);
			}
		}
	}
	
	public void insertTagFollow(long tagid, long docid){
		Follow follow = new Follow();
		follow.setUpper(tagid);
		follow.setFollower(docid);
		follow.setFollowType("5");
		
		followDao.save(follow);
	}
	
	public void save(Tag tag){
		if (StringUtils.isEmpty(tag.getTagname())) {
			return;
		}
		tagDao.save(tag);
		log.debug("save tay :"+tag.getTagname()+"; tagID="+tag.getTagid());
	}
	
	
	public void delete(Tag obj){
		tagDao.delete(obj);
	}
}
