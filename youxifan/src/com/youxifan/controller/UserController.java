package com.youxifan.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.apache.commons.lang3.StringUtils;

import com.youxifan.pojo.User;
import com.youxifan.service.UserService;
import com.youxifan.utils.CommonUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	protected final transient Log log = LogFactory
	.getLog(UserController.class);
	@Autowired
	private UserService userService;
	public UserController(){
		
	}
	
	
	@RequestMapping
	public String load(ModelMap modelMap){
		List<Object> list = userService.getUserList();
		modelMap.put("userlist", list);
		return "userlist";
	}
	
	// 注册
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap modelMap ,HttpSession session){
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		String name = request.getParameter("name");
		String signing = request.getParameter("signing");
		User user = new User();
		user.setEmail(email);
		user.setUsername(name);
		user.setPassword(psw);
		user.setSigning(signing);
		if (!userService.checkEmail(user.getEmail())) {
			modelMap.put("addstate", "该邮箱已经被注册！");
			return "register";
		}
		try{
			userService.save(user);
			if(user.getUserid() == 0){
				System.out.println("user.getUserid=="+user.getUserid());				
			}				
			modelMap.put("addstate", "添加成功");
//			userService.getUserByEmail(user.getEmail())
			session.setAttribute(CommonUtil.USER_CONTEXT, user);
		}
		catch(Exception e){
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}
		
		return "redirect:/doc";
	}
	
	//登录
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,HttpServletResponse response, HttpSession session,ModelMap modelMap){
		String goto_url = (String)session.getAttribute(CommonUtil.LOGIN_TO_URL);
		Cookie[] cookies =request.getCookies(); 
		boolean cautologin = false;
		String cemail = null;
		for (Cookie cookie : cookies) {
			if ("autologin".equals(cookie.getName())) {
				if ("1".equals(cookie.getValue())) {
					cautologin = true;
				}
			}else if("email".equals(cookie.getName())){
				cemail = cookie.getValue();
			}
		}
		if (cautologin) {
			User user = userService.getUserByEmail(cemail);
			session.setAttribute(CommonUtil.USER_CONTEXT, user);
			 
			return StringUtils.isEmpty(goto_url)?"redirect:/doc":"redirect:"+goto_url;
		}
		
		
		String email =  request.getParameter("email");
		String pwd = request.getParameter("psw");
		String autologin  = request.getParameter("remlginstate"); 
		
		boolean login = false;
		
//		String code = request.getParameter("validcode");
//		if (!StringUtils.isEmpty(code)) {
//			code = code.toLowerCase();
//		}
//		String scode = (String)request.getSession().getAttribute("strRandom");
//		if (StringUtils.isEmpty(code) || !code.equals(scode)) {
//			modelMap.put("email", email);
//			modelMap.put("msg", "验证码错误");
//			login = false;
//		}else \
		
		if (StringUtils.isEmpty(email)) {
			return "login";
		} 
		
		User user = userService.getUserByEmail(email);
		if (user == null) {
			modelMap.put("msg", "该邮箱没有注册");
			login = false;
		}else if (StringUtils.isEmpty(pwd) || !pwd.equals(CommonUtil.decoderStr(user.getPassword()))) {
			modelMap.put("msg", "密码错误");
			login = false;
		}else { 
			session.setAttribute(CommonUtil.USER_CONTEXT, user);
			login = true;
		}
		if (login) {
			
			if("on".equals(autologin)){     
                Cookie emailcookie = new Cookie("email", email); 
                emailcookie.setMaxAge(999999); 
                emailcookie.setPath("/"); 
                Cookie loginCookie = new Cookie("autologin", "1"); 
                loginCookie.setMaxAge(999999);
                loginCookie.setPath("/"); 
                response.addCookie(emailcookie); 
                response.addCookie(loginCookie);
			}
//			return "redirect:/jcrop/userhead.jsp";
			return "redirect:/doc";
		}
		return "login";
	}
	
	@RequestMapping(value = "/checkEmail/{email}/")
	@ResponseBody
	public Map checkEmail(@PathVariable String email ){

		String retValue = "";
		if (userService.checkEmail(email)) {
			retValue = "{\"check\":\"OK\"}";
		}else {
			retValue = "{\"check\":\"False\"}";
		}
//		 writer.print(retValue);
		Map retMap = new HashMap();
		retMap.put("check", "错误"); 
		return retMap;
	}
	
	
	
	@RequestMapping(value="/headImg" ,method = RequestMethod.POST)
	public void saveHeadImg(HttpServletRequest request, HttpServletResponse response,PrintWriter writer){
		User user = (User)request.getSession().getAttribute("loginuser") ;
		if(user == null){
			writer.print("notLogin");
		}
		try{
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));
			int w = Integer.parseInt(request.getParameter("w"));
			int h = Integer.parseInt(request.getParameter("h"));
			String filename = request.getParameter("filename"); 
			String savePath = request.getSession().getServletContext().getRealPath("");
			boolean rs=userService.saveHeadImg(x,y,w,h,filename,savePath+"/uploads/",user);
			
		}
		catch(Exception e){
			writer.print("false");
			log.error(e.getMessage()); 
		}
		writer.print("true");
	}
	
	
	@RequestMapping(params = "method=del")
	public void del(@RequestParam("id") String id, HttpServletResponse response){
		try{
			User user = new User();
			user.setUserid(new Integer(id));
			userService.delete(user);
			response.getWriter().print("{\"del\":\"true\"}");
		}
		catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	 
	// 登录注销 
	@RequestMapping("/logout") 
	public String logout(HttpSession session,HttpServletResponse response ) { 
	  session.removeAttribute(CommonUtil.USER_CONTEXT); 
	  Cookie cookie = new Cookie("autologin", null); 
	  cookie.setMaxAge(0);
	  cookie.setPath("/");
	  response.addCookie(cookie);

	  return "redirect:/user/login"; 
	} 
}
