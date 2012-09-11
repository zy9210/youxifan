package com.youxifan.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
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
import com.youxifan.pojo.Getpwd;
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.GetpwdService;
import com.youxifan.service.UserService;
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.EMail;
import com.youxifan.utils.PropertiesUtil;

@Controller
@RequestMapping("/getpwd")
public class GetpwdController {
	
	protected final transient Log log = LogFactory
	.getLog(GetpwdController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GetpwdService getpwdService;
	        
	public GetpwdController(){
		 
	}
	
	@RequestMapping(value="/changepwd")
	public String getUserid(HttpServletRequest request, ModelMap modelMap){
		
		String email = request.getParameter("email");
		String pwdstr = request.getParameter("pwdstr");
		String psw = request.getParameter("psw"); 

		Getpwd getpwd = getpwdService.queryGetpwd(pwdstr);
		if (getpwd == null) {
			modelMap.put("msg", "链接无效！");
			return "getpwd";
		}else if (!getpwd.getEmail().equals(email)) {
			modelMap.put("msg", "邮箱错误！");
			return "getpwd";
		}
		
		userService.changePassword(getpwd.getEmail(), psw);
		getpwdService.delete(pwdstr);
		
		return "redirect:/jsp/login.jsp";
	}
	
	
	
	@Resource(name="getpwdhtml")
	private String  getpwdhtml;
	
	
	@RequestMapping(value="/sendEmail/{email}")
//	@ResponseBody
	public void sendEmail(@PathVariable String email,PrintWriter writer){
		
		if (userService.checkEmail(email)) {
			writer.print( "{\"send\":\"noemail\"}");
			return;
		}	
		String pwdstr = CommonUtil.generateGUID();
		try {
			Getpwd getpwd = new Getpwd();
			getpwd.setGetpwdstr(pwdstr);
			getpwd.setEmail(email.trim());
			getpwdService.save(getpwd);
			
			Properties properties = new Properties();
			properties.put("pwdstr", pwdstr); 
			properties.put("email", email);
			String htmlstr = CommonUtil.complete(getpwdhtml, properties);
			
			
//			EMail mail = new EMail("smtp.163.com", 25,false, 
//			"zy9210@163.com", "youxiafan", email, email, 
//			"找回密码", ""); 
			
			EMail mail = new EMail(PropertiesUtil.getProperty("smtpHost"),Integer.parseInt(PropertiesUtil.getProperty("smtpPort")),false, 
					PropertiesUtil.getProperty("fromEMail"), PropertiesUtil.getProperty("fromName"), email, email, 
					"密码找回_wan181.com", ""); 
			
			mail.setMessageHTML(htmlstr); 
			mail.createAuthenticator(PropertiesUtil.getProperty("fromEMail"),PropertiesUtil.getProperty("emailpassword"));
			mail.sendWithoutWait();
			
		} catch (Exception e) {
			log.error("发送找密码邮件发生错误！", e); 
			writer.print( "{\"send\":\"false\"}"); 
		}
		
		
		writer.print( "{\"send\":\"true\"}"); 
	}
	
	


}
