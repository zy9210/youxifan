package com.youxifan.controller;

  
import java.util.List;  
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
import org.springframework.web.bind.annotation.ResponseBody;
  
import com.youxifan.pojo.Suggestion; 
import com.youxifan.pojo.User;
import com.youxifan.service.SuggestionService; 
import com.youxifan.utils.CommonUtil;

@Controller 
public class SuggestionController {
	
	protected final transient Log log = LogFactory
	.getLog(SuggestionController.class);
	
	@Autowired
	private SuggestionService suggestionService; 
	 
	
	public SuggestionController(){
		 
	}
	
	 
	
	@RequestMapping(value="/suggestion/",method = RequestMethod.POST)
	@ResponseBody
	public String saveSuggestion(HttpServletRequest request, ModelMap modelMap,HttpSession session){
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT );
		String contact = request.getParameter("contact");
		String content = request.getParameter("content");
		
		Suggestion sug = new Suggestion();
		sug.setContact(contact);
		sug.setContent(content);
		if (loginUser != null) {
			sug.setUserid(loginUser.getUserid());
		}
		suggestionService.save(sug);
		
		return "{\"success\":\"true\"}";
	}

	@RequestMapping(value="/suggestion/page/{start}/{step}" )
	@ResponseBody
	public List getSuggestion(@PathVariable int start,@PathVariable int step,HttpServletResponse response, ModelMap modelMap){
		
		return suggestionService.getSugList(start, step);
	}

	@RequestMapping(value="/admin/{tab}") 
	public String getSuggestion(@PathVariable String tab, HttpServletResponse response, ModelMap modelMap){
		modelMap.put("tab", tab);
		return "manager";
	}
	
	
	 
}
