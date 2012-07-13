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
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.UserService;
import com.youxifan.utils.CommonUtil;

@Controller
@RequestMapping("/doc")
public class DocController {
	protected final transient Log log = LogFactory
	.getLog(DocController.class);
	
	@Autowired
	private DocService docService;
	public DocController(){
		
	}
	
	@RequestMapping(method=RequestMethod.GET )
	public String load(ModelMap modelMap){
		Map map = new HashMap();
		map.put("start", 0);
		map.put("end", 30);
		List<Object> list = docService.newestDoc(map);
		modelMap.put("doclist", list);
		modelMap.put("sort", "newest");
		return "doclist";
	}
	
	@RequestMapping(value = "/sort/{sort}/page/{start}/{step}" )
	@ResponseBody
	public List answer(@PathVariable String sort,@PathVariable int start, @PathVariable int step){
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", start+step);
		map.put("sort", sort);
		List<Object> list = docService.newestDoc(map);
		
		
		return list;
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST )
	public String save(HttpServletRequest request, ModelMap modelMap,HttpServletResponse response){
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginuser");
		if (user == null) {
			request.setAttribute("backpath", "");
			return "login";
		}
		String title = request.getParameter("title");
		String content = request.getParameter("post-text");
		String doctype = request.getParameter("doctype");
		String upperdocid = request.getParameter("upperdocid");
		
		Doc doc = new Doc();
		doc.setTitle(title);
		doc.setContent(content);
		doc.setDoctype(doctype);
		if (!StringUtils.isEmpty(upperdocid)) {
			doc.setUpperdocid(new Integer(upperdocid));
		}
		doc.setCreater(user);
		doc.setCreaterid(user.getUserid());
		try{
			docService.save(doc);
			modelMap.put("addstate", "添加成功");
			return "redirect:/s/doc";
		}
		catch(Exception e){
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}
		
		return "redirect:/s/doc";
	}

	
	@RequestMapping(value = "/{docid}/answer" ,method=RequestMethod.POST , headers = "Accept=application/json")
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
	public String getDocbyId(@PathVariable Long docid, ModelMap modelMap,HttpServletResponse response){
		Doc doc = docService.getDocByID(docid);
		modelMap.put("doc", doc);
		return "doc";
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
