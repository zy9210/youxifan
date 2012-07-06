package com.youxifan.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.TagDao;
import com.youxifan.pojo.Tag;

@Service
public class TagService {
	@Autowired
	private TagDao tagDao;
	
	@Transactional
	public List<Object> getUserList(){
		List<Object> list = tagDao.queryTag();
		return list;
	}
	
	public void save(Tag tag){
		if (StringUtils.isEmpty(tag.getTagname())) {
			return;
		}
		tagDao.save(tag);
	}
	
	
	public void delete(Object obj){
		tagDao.delete(obj);
	}
}
