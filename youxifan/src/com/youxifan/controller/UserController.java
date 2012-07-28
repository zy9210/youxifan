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

import com.youxifan.pojo.Doc;
import com.youxifan.pojo.Tag;
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.TagService;
import com.youxifan.service.UserService;
import com.youxifan.utils.CommonUtil;

@Controller 
public class UserController {
	protected final transient Log log = LogFactory
	.getLog(UserController.class);
	@Autowired
	private UserService userService;
	public UserController(){
		
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
//		session.removeAttribute(CommonUtil.LOGIN_TO_URL);
		Cookie[] cookies =request.getCookies(); 
		boolean cautologin = false;
		String cemail = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if ("autologin".equals(cookie.getName())) {
					if ("1".equals(cookie.getValue())) {
						cautologin = true;
					}
				}else if("email".equals(cookie.getName())){
					cemail = cookie.getValue();
				}
			}
		}
		
		if (cautologin) {
			log.debug(cemail+"自动登录，转到："+goto_url);
			User user = userService.getUserByEmail(cemail);
			session.setAttribute(CommonUtil.USER_CONTEXT, user); 
			session.removeAttribute(CommonUtil.LOGIN_TO_URL);
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
			log.debug("该邮箱没有注册");
			modelMap.put("msg", "该邮箱没有注册");
			modelMap.put("loginemail", email);
			login = false;
		}else if (StringUtils.isEmpty(pwd) || !pwd.equals(CommonUtil.decoderStr(user.getPassword()))) {
			log.debug(email+"登录时密码错误！");
			modelMap.put("msg", "密码错误");
			modelMap.put("loginemail", email);
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
			session.removeAttribute(CommonUtil.LOGIN_TO_URL);
			return StringUtils.isEmpty(goto_url)?"redirect:/doc":"redirect:"+goto_url;
		}
		return "login";
	}
	
	@RequestMapping(value = "/checkEmail/{email}/")
	public void checkEmail(@PathVariable String email,PrintWriter writer){

		String retValue = "";
		if (userService.checkEmail(email)) {
			retValue = "{\"check\":\"OK\"}";
		}else {
			retValue = "{\"check\":\"False\"}";
		}
		writer.print(retValue); 
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
	
	@Autowired
	private DocService docService;
	@Autowired
	private TagService tagService;
	// 个人页面展示
	@RequestMapping("/user/{userid}/tab/{tab}") 
	public String show(ModelMap modelMap,@PathVariable long userid,@PathVariable String tab,HttpSession session ) { 
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT );
		Map paraMap = new HashMap();
		paraMap.put("userid", userid);
		paraMap.put("loginuserid", loginUser.getUserid());
		User user = userService.getUserByID(paraMap);
		if (user == null) {
			return "error";
		}
		Map map = new HashMap();
		map.put("start", 0);
		map.put("end", 30);
		map.put("userid", userid);
		map.put("loginuserid", loginUser.getUserid());
		List<Doc> docList = null;
		List<Tag> tagList = null;
		List<User> userList = null;
		if ("askq".equals(tab)) {
			docList = docService.usersQ(map); 
			modelMap.put("doclist", docList);
		}else if ("answerq".equals(tab)) {
			docList = docService.userAnsweredQ(map);
			modelMap.put("doclist", docList);
		}else if ("followedq".equals(tab)) {
			docList = docService.userFollowedQ(map);
			modelMap.put("doclist", docList);
		}else if ("followedtag".equals(tab)) {
			tagList = tagService.userFollowedTag(map);
			modelMap.put("tagList", tagList);
		}else if("followedUser".equals(tab)){
			userList = userService.userFollowedUser(map);
			modelMap.put("userList", userList);
		}else if ("fans".equals(tab)) {
			userList = userService.usersFans(map);
			modelMap.put("userList", userList);
		}
		
		
		modelMap.put("tab", tab); 
		modelMap.put("user", user); 
	  return "user"; 
	}
	
	@RequestMapping("/user/{userid}/tab/{tab}/page/{start}/{step}") 
	@ResponseBody
	public List showPage(@PathVariable long userid,@PathVariable String tab,@PathVariable int start, @PathVariable int step,HttpSession session) { 
		User loginUser = (User)session.getAttribute(CommonUtil.USER_CONTEXT );
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", start+ step);
		map.put("userid", userid);
		map.put("loginuserid", loginUser.getUserid());
		List  list = null;
		
		if ("askq".equals(tab)) {
			list = docService.usersQ(map); 
		}else if ("answerq".equals(tab)) {
			list = docService.userAnsweredQ(map); 
		}else if ("followedq".equals(tab)) {
			list = docService.userFollowedQ(map); 
		}else if ("followedtag".equals(tab)) {
			list = tagService.userFollowedTag(map); 
		}else if("followedUser".equals(tab)){
			list = userService.userFollowedUser(map); 
		}else if ("fans".equals(tab)) {
			list = userService.usersFans(map); 
		}
		
	    return list; 
	}
	
	
	
	
	
}
