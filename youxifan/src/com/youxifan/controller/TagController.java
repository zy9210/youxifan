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
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.sun.jmx.snmp.daemon.CommunicationException;
import com.youxifan.pojo.Doc;
import com.youxifan.pojo.Getpwd; 
import com.youxifan.pojo.Tag;
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.TagService; 
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.EMail;

@Controller 
public class TagController {
	
	protected final transient Log log = LogFactory
	.getLog(TagController.class);
	
	@Autowired
	private TagService tagService; 
	
	@Autowired
	private DocService docService; 
	
	
	public TagController(){
		 
	}
	
	@RequestMapping(value="/tag/search/fid/{fatherid}")
	@ResponseBody
	public Map getTagByFID(@PathVariable long fatherid,HttpServletRequest request, ModelMap modelMap){
		List<Tag> list = tagService.queryByFatherID(fatherid);
		
		List<String> lstr = new ArrayList<String>();
		for (Tag tag : list) {
			lstr.add(tag.getTagname());
		}
		Map map = new HashMap();
		map.put("availableTags", lstr);
		return map;
	}
	
	@RequestMapping(value="/tag/search/fstr/{fatherStr}")
	@ResponseBody
	public Map getTagByFstr(@PathVariable String fatherStr,HttpServletRequest request, ModelMap modelMap){
		log.debug("request father tag is :"+fatherStr);
		List<Tag> list = tagService.queryByFatherStr(fatherStr);
		
		List<String> lstr = new ArrayList<String>();
		for (Tag tag : list) { 
			lstr.add(tag.getTagname());
		}
		Map map = new HashMap();
		map.put("availableTags", lstr);
		return map;
	}
	
	
	@RequestMapping(value="/tag/search/{tagStr}/page/{start}/{step}")
	@ResponseBody
	public List tagSearch(@PathVariable String tagStr,@PathVariable int start, @PathVariable int step,HttpServletRequest request, ModelMap modelMap){
		log.debug("tag搜索 :"+tagStr);
		Map map = new HashMap();
		map.put("tagStr", "%"+tagStr+"%");
		map.put("start", start);
		map.put("end", start+ step);
		List<Tag> list = tagService.tagSearch(map);
		 
		return list;
	}
	
	//  只做测试用
	@RequestMapping(value="/addTag/{fatherStr}/{tagStr}")
//	@ResponseBody
	public void save(@PathVariable String fatherStr,@PathVariable String tagStr,HttpSession session){
		long fatherid = tagService.findTagbyName(fatherStr).getTagid();
		if (fatherid == 0) {
			return;
		}
		User user = (User) session.getAttribute(CommonUtil.USER_CONTEXT);
		Tag tag = new Tag();
		tag.setFatherid(fatherid);
		tag.setTagname(tagStr);
		tag.setBsflag("1");
		tag.setCreator(user.getUserid());
		tagService.save(tag);
		System.out.println(tag.getTagid());
		
	}


	// tag页面展示
	@RequestMapping("/tag/{tagid}") 
	public String load(ModelMap modelMap,@PathVariable long tagid ,HttpSession session) { 
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT );
		Map m = new HashMap();
		m.put("tagid", tagid);
		m.put("loginuserid", loginUser.getUserid());
		Tag tag = tagService.findTagbyID(m);
		if (tag == null) {
			return "error";
		}
		Map map = new HashMap();
		map.put("start", 0);
		map.put("end", 30);
		map.put("tagid", tagid);
		map.put("sort", "newest");
		map.put("loginuserid", loginUser.getUserid());
		List<Doc> list = docService.tagsQ(map);
		
		modelMap.put("doclist", list);
		modelMap.put("tab", "newest");   
		modelMap.put("tag", tag);  
		

	  return "tag"; 
	}


	// tag页面展示
	@RequestMapping("/tag/{tagid}/tab/{tab}") 
	public String show(ModelMap modelMap,@PathVariable long tagid,@PathVariable String tab,HttpSession session ) { 
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT );
		Map m = new HashMap();
		m.put("tagid", tagid);
		m.put("loginuserid", loginUser.getUserid());
		Tag tag = tagService.findTagbyID(m);
		if (tag == null) {
			return "error";
		}
		Map map = new HashMap();
		map.put("start", 0);
		map.put("end", 30);
		map.put("tagid", tagid);
		map.put("sort", tab);
		map.put("loginuserid", loginUser.getUserid());
		List<Doc> list = docService.tagsQ(map);
		
		modelMap.put("doclist", list);
		modelMap.put("tab", tab);  
		
		modelMap.put("tag", tag);  
		

	  return "tag"; 
	}
	
	@RequestMapping("/tag/{tagid}/tab/{tab}/page/{start}/{step}") 
	@ResponseBody
	public List showPage(ModelMap modelMap,@PathVariable long tagid,@PathVariable String tab,@PathVariable int start, @PathVariable int step,HttpSession session) { 
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT ); 
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", start+ step);
		map.put("tagid", tagid);
		map.put("sort", tab);
		map.put("loginuserid", loginUser.getUserid());
		List<Doc> list = docService.tagsQ(map);
		
		modelMap.put("doclist", list);
		modelMap.put("tab", tab); 
		return list;
	}


}
