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
	public List<Object> getUserList(){
		List<Object> list = tagDao.queryTag();
		return list;
	}
	
	public List<Object> queryByFatherID(long fatherid){
		List<Object> list = tagDao.queryByFatherID(fatherid);
		return list;
	}
	
	public List<Object> queryByFatherStr(String fatherStr){
		List<Object> list = tagDao.queryByFatherStr(fatherStr);
		return list;
	}
	
	/*
	 * map:fatherStr,tagStr
	 */
	public Object findTag(String fatherStr ,String tagStr){
		Map map = new HashMap();
		map.put("fatherStr", fatherStr);
		map.put("tagStr", tagStr);
		
		return tagDao.findTag(map);
	}
	
	/*
	 * tagStr
	 */
	public Tag findTag(String tagStr){ 
		
		return (Tag)tagDao.findTag(tagStr);
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
		long fatherID = findTag(fatherStr).getTagid();
		for (String tagStr : tagAry) {
			Tag tag = (Tag)findTag(fatherStr, tagStr);
			if (tag != null) {
				insertTagFollow(tag.getTagid(),docid);
			}else {
				Tag t = new Tag();
				t.setFatherid(fatherID);
				t.setBsflag("1");
				t.setTagname(tagStr);
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
	
	
	public void delete(Object obj){
		tagDao.delete(obj);
	}
}
