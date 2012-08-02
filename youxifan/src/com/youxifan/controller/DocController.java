package com.youxifan.controller;


import java.io.IOException;
import java.io.PrintWriter;
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
import org.apache.commons.lang3.StringUtils;

import com.youxifan.pojo.Doc;
import com.youxifan.pojo.Tag;
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.TagService;
import com.youxifan.service.UserService;
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
		map.put("end", 30);
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
		map.put("end", 30);
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
		map.put("end", start+step);
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
		try{
			docService.save(doc);
			modelMap.put("addstate", "添加成功");
			tagService.saveTagStr(doc.getDocid(),gametext,subtags);
			return "redirect:/user/"+user.getUserid()+"/tab/askq";
		}
		catch(Exception e){
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}
		
		return "redirect:/user/"+user.getUserid()+"/tab/askq";
	}

	
	@RequestMapping(value = "/answer/{docid}" ,method=RequestMethod.POST , headers = "Accept=application/json")
	//@ResponseBody
	public void answer(@PathVariable Long docid, HttpServletRequest request, HttpServletResponse response){
		String retValue ="";
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginuser");
		if (user == null) {
			retValue = "{\"success\":\"false\",\"msg\":\"请登录\"}";
			out.println(retValue);
			return ;
		} 
		String content = request.getParameter("post-text");
		String doctype = request.getParameter("doctype");
		Long upperdocid = docid;
		if (StringUtils.isEmpty(content)) {
			retValue = "{\"success\":\"false\",\"msg\":\"请作答！\"}";
			out.print(retValue);
			return ;
		}
		Doc doc = new Doc(); 
		doc.setContent(content);
		doc.setDoctype(doctype); 
		doc.setUpperdocid(upperdocid);
		doc.setCreater(user);
		doc.setCreaterid(user.getUserid());
		try{
			docService.save(doc);
			retValue = "{\"success\":\"true\",\"msg\":\"提交成功\"}";
			out.print(retValue);
			return;
		}
		catch(Exception e){
			log.error(e.getMessage());
			retValue = "{\"success\":\"false\",\"msg\":\"保存失败\"}";
			out.print(retValue);
			return;
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
	public List tagSearch(@PathVariable String docStr,@PathVariable int start, @PathVariable int step,HttpServletRequest request, ModelMap modelMap){
		log.debug("doc搜索 :"+docStr);
		Map map = new HashMap();
		map.put("docStr", "%"+docStr+"%");
		map.put("start", start);
		map.put("end", start+ step);
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
