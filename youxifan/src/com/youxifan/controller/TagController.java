package com.youxifan.controller;

 
import java.io.PrintWriter; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest; 

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.youxifan.pojo.Getpwd; 
import com.youxifan.pojo.Tag;
import com.youxifan.service.TagService; 
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.EMail;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	protected final transient Log log = LogFactory
	.getLog(TagController.class);
	
	@Autowired
	private TagService tagService; 
	
	public TagController(){
		 
	}
	
	@RequestMapping(value="/search/fid/{fatherid}")
	@ResponseBody
	public Map getTagByFID(@PathVariable long fatherid,HttpServletRequest request, ModelMap modelMap){
		List<Object> list = tagService.queryByFatherID(fatherid);
		Tag tag = null;
		List<String> lstr = new ArrayList<String>();
		for (Object object : list) {
			tag = (Tag) object ;
			lstr.add(tag.getTagname());
		}
		Map map = new HashMap();
		map.put("availableTags", lstr);
		return map;
	}
	
	@RequestMapping(value="/search/fstr/{fatherStr}")
	@ResponseBody
	public Map getTagByFstr(@PathVariable String fatherStr,HttpServletRequest request, ModelMap modelMap){
		log.debug("request father tag is :"+fatherStr);
		List<Object> list = tagService.queryByFatherStr(fatherStr);
		Tag tag = null;
		List<String> lstr = new ArrayList<String>();
		for (Object object : list) {
			tag = (Tag) object ;
			lstr.add(tag.getTagname());
		}
		Map map = new HashMap();
		map.put("availableTags", lstr);
		return map;
	}
	
	
	
	@Resource(name="getpwdhtml")
	private String  getpwdhtml;
	
	
	@RequestMapping(value="/addTag/{fatherStr}/{tagStr}")
//	@ResponseBody
	public void save(@PathVariable String fatherStr,@PathVariable String tagStr){
		long fatherid = tagService.findTag(fatherStr).getTagid();
		Tag tag = new Tag();
		tag.setFatherid(fatherid);
		tag.setTagname(tagStr);
		tag.setBsflag("1");
		tagService.save(tag);
		System.out.println(tag.getTagid());
		
	}
	
	


}
