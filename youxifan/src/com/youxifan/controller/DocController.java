package com.youxifan.controller;


import java.io.IOException;
import java.io.PrintWriter; 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import com.youxifan.pojo.Doc; 
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.TagService; 
import com.youxifan.utils.CommonUtil;

@Controller
@RequestMapping("/doc")
public class DocController {
	protected final transient Log log = LogFactory
	.getLog(DocController.class);
	
	@Autowired
	private DocService docService;
	@Autowired
	private TagService tagService;
	
	public DocController(){
		
	}
	
	@RequestMapping(method=RequestMethod.GET )
	public String load(ModelMap modelMap,HttpSession session){
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
		Map map = new HashMap();
		map.put("start", 0);
		map.put("step", 30);
		map.put("loginuserid", user.getUserid());
		
		List<Doc> list = docService.queryDoc(map);
		modelMap.put("doclist", list);
		modelMap.put("tab", "newest");
		return "doclist";
	}
	
	@RequestMapping(value = "/tab/{tab}" )
	public String queryTab(ModelMap modelMap,@PathVariable String tab,HttpSession session){
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
		Map map = new HashMap();
		map.put("start", 0);
		map.put("step", 30);
		map.put("sort", tab);
		map.put("loginuserid", user.getUserid());
		List<Doc> list = docService.queryDoc(map);
		modelMap.put("doclist", list);
		modelMap.put("tab", tab);
		return "doclist";
	}
	
	@RequestMapping(value = "/tab/{tab}/page/{start}/{step}" )
	@ResponseBody
	public List queryTabPage(@PathVariable String tab,@PathVariable int start, @PathVariable int step,HttpSession session){
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
		Map map = new HashMap();
		map.put("start", start);
		map.put("step", step);
		map.put("sort", tab);
		map.put("loginuserid", user.getUserid());
		List<Doc> list = docService.queryDoc(map);
		
		
		return list;
	}
	
	
	
	@RequestMapping(value = "/add" )
	public String save(HttpServletRequest request, ModelMap modelMap,HttpServletResponse response,HttpSession session){
		
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
		
		String title = request.getParameter("post_title");
		String content = request.getParameter("post_content");
		String doctype = request.getParameter("post_type"); 
		String subtags = request.getParameter("subtags");
		String gametext = request.getParameter("gametext"); 
		
		Doc doc = new Doc();
		doc.setTitle(title);
		doc.setContent(content);
		doc.setDoctype(doctype); 

		Map paraMap =(Map) session.getAttribute(CommonUtil.REQUEST_PARAMETERS);
		if (paraMap != null) {
			if(paraMap.get("post_title")!=null)
				doc.setTitle(((String[])paraMap.get("post_title"))[0]);
			if(paraMap.get("post_content")!=null)
				doc.setContent(((String[])paraMap.get("post_content"))[0]);
			if(paraMap.get("post_type")!=null)
				doc.setDoctype(((String[])paraMap.get("post_type"))[0]);
			if(paraMap.get("gametext")!=null)
				gametext = ((String[])paraMap.get("gametext"))[0];
			if(paraMap.get("subtags")!=null)
				subtags = ((String[])paraMap.get("subtags"))[0];
			session.removeAttribute(CommonUtil.REQUEST_PARAMETERS);
		}
		if (StringUtils.isEmpty(title)) {
			modelMap.put("addstate", "标题不能为空！");
			return "ask";
		}

		doc.setCreatername(user.getUsername());
		doc.setCreater(user);
		doc.setCreaterid(user.getUserid());
		doc.setGame(gametext);
		try{
			docService.save(doc);
			modelMap.put("addstate", "添加成功");
			tagService.saveTagStr(doc.getDocid(),gametext,subtags,user.getUserid());
			return "redirect:/user/"+user.getUserid()+"/tab/askq";
		}
		catch(Exception e){
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}
		
		return "redirect:/user/"+user.getUserid()+"/tab/askq";
	}

	
	@RequestMapping(value = "/answer/{docid}" ,method=RequestMethod.POST , headers = "Accept=application/json")
	@ResponseBody
	public String answer(@PathVariable Long docid, HttpServletRequest request, HttpServletResponse response){
		String retValue =""; 
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
		if (user == null) {
			retValue = "{\"success\":\"false\",\"msg\":\"请登录\"}";
			return retValue;
		} 
		String content = request.getParameter("post-text");
		String doctype = "3";  //答案
		Long upperdocid = docid;
		if (StringUtils.isEmpty(content)) {
			retValue = "{\"success\":\"false\",\"msg\":\"请作答！\"}"; 
			return retValue;
		}
		Doc doc = new Doc(); 
		doc.setContent(content); 
		doc.setDoctype(doctype); 
		doc.setUpperdocid(upperdocid);
		doc.setCreater(user);
		doc.setCreaterid(user.getUserid());
		doc.setCreatername(user.getUsername());
		try{
			docService.save(doc);
			docService.updateAnswers(1, upperdocid);  //问题的答案数+1
			String nowStr = CommonUtil.getDateTimeStr(new Date(),null);
			retValue = "{\"success\":\"true\",\"msg\":\"提交成功\",\"docid\":\""+doc.getDocid()+"\",\"nowStr\":\""+nowStr+"\"}"; 
			return retValue ;
		}
		catch(Exception e){
			log.error(e.getMessage());
			retValue = "{\"success\":\"false\",\"msg\":\"保存失败\"}"; 
			return retValue;
		}
		
	}
	
	/*
	 * type: title , content
	 */
	@RequestMapping(value = "/update/{docid}/{type}" ,method=RequestMethod.POST)
	@ResponseBody
	public String update(@PathVariable long docid,@RequestParam("post-text") String content,  @PathVariable String type, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String retValue ="";
//		request.setCharacterEncoding("utf8");
//		response.setCharacterEncoding("utf8");
//		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginuser");
		if (user == null) {
			retValue = "{\"success\":\"false\",\"msg\":\"请登录。\"}";
			return retValue;
		} 
//		String content =post-text;// request.getParameter("post-text");
		if (StringUtils.isEmpty(content)) {
			return retValue = "{\"success\":\"false\",\"msg\":\"提交内容不能为空。\"}";
		}
		Map map = new HashMap();
		map.put("docid", docid);
		if ("title".equals(type)) {
			
			map.put("title", StringEscapeUtils.escapeHtml4(content));
		}else if ("content".equals(type)) {
			map.put("content", content);
		}
		
		
		try{
			docService.update(map);
			retValue = "{\"success\":\"true\",\"msg\":\"提交成功！\"}";
			return retValue;
		}
		catch(Exception e){
			log.error(e.getMessage());
			retValue = "{\"success\":\"false\",\"msg\":\"保存失败,稍后再提交。\"}"; 
			return retValue;
		}
		
	}
	

	@RequestMapping(value="/id/{docid}" , method=RequestMethod.GET)
	public String getDocbyId(@PathVariable Long docid, ModelMap modelMap,HttpServletResponse response,HttpSession session){
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT );
		Map m = new HashMap();
		m.put("docid", docid);
		m.put("loginuserid", loginUser.getUserid());
		Doc doc = docService.getDocByID(m);
		modelMap.put("doc", doc);
		return "doc";
	}
	
	@RequestMapping(value="/search/{docStr}/page/{start}/{step}")
	@ResponseBody
	public List docSearch(@PathVariable String docStr,@PathVariable int start, @PathVariable int step,HttpServletRequest request, ModelMap modelMap){
		log.debug("doc搜索 :"+docStr);
		Map map = new HashMap();
		map.put("docStr", "%"+docStr.replace(" ", "%")+"%");
		map.put("start", start);
		map.put("step", step);
		List<Doc> list = docService.docSearch(map);
		 
		return list;
	}
	
	
	
	@RequestMapping(params = "method=del")
	public void del(@RequestParam("id") String id, HttpServletResponse response){
		try{
			Doc doc = new Doc();
			doc.setDocid(new Integer(id));
			docService.delete(doc);
			response.getWriter().print("{\"del\":\"true\"}");
		}
		catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
