package com.youxifan.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import com.sun.org.apache.bcel.internal.generic.INVOKESTATIC;
import com.sun.org.apache.bcel.internal.generic.INVOKEVIRTUAL;
import com.youxifan.pojo.Doc;
import com.youxifan.pojo.Invite;
import com.youxifan.pojo.Tag;
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.FollowService;
import com.youxifan.service.InviteService;
import com.youxifan.service.TagService;
import com.youxifan.service.UserService;
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.PropertiesUtil;

@Controller 
public class UserController {
	protected final transient Log log = LogFactory
	.getLog(UserController.class);
	@Autowired
	private UserService userService;
	
	@Autowired
	private FollowService followService;
	 
	public UserController(){
		
	}
	 
	 
	// 注册
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap modelMap ,HttpSession session){
		String email = request.getParameter("email");
		String psw = request.getParameter("pwd");
		String name = request.getParameter("name");
		String signing = request.getParameter("signing");
		String gametext = request.getParameter("gametext");
		String invitecode = request.getParameter("invitecode");
		User user = new User();
		user.setEmail(email);
		user.setUsername(name);
		user.setPassword(psw);
		user.setSigning(signing);
		user.setGame(gametext);
		int defaultImgTotle = 1 + Integer.parseInt(PropertiesUtil.getProperty("defaultImgTotle"));
		user.setImageurl("/uploads/0/"+(1+new Random().nextInt(defaultImgTotle))+".jpg");
		if (!userService.checkEmail(user.getEmail())) {
			modelMap.put("addstate", "该邮箱已经被注册！");
			modelMap.put("email", email);
			modelMap.put("psw", psw);
			modelMap.put("name", name);
			modelMap.put("signing", signing);
			modelMap.put("gametext", "\""+gametext.replace(",", "\",\"")+"\"");
			modelMap.put("invitecode", invitecode); 
			return "register";
		}	
		Invite invite = inviteService.findInviteByCode(invitecode) ;
		if (invite == null) {
			modelMap.put("addstate", "邀请码错误或已被使用！"); 
			modelMap.put("email", email);
			modelMap.put("psw", psw);
			modelMap.put("name", name);
			modelMap.put("signing", signing);
			modelMap.put("gametext", "\""+gametext.replace(",", "\",\"")+"\"");
			modelMap.put("invitecode", invitecode); 
			return "register";
		}
		try{
			userService.save(user);  
			modelMap.put("addstate", "添加成功");
//			userService.getUserByEmail(user.getEmail())
			session.setAttribute(CommonUtil.USER_CONTEXT, user);
		}
		catch(Exception e){
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败,请稍后重试。"); 
			modelMap.put("email", email);
			modelMap.put("psw", psw);
			modelMap.put("name", name);
			modelMap.put("signing", signing);
			modelMap.put("gametext", "\""+gametext.replace(",", "\",\"")+"\"");
			modelMap.put("invitecode", invitecode); 
			return "register";
		}
		//保存信息完成后   配置相关信息：gametag的保存和follow，invite
		try {
			tagService.saveGameTag(gametext,user.getUserid());
		} catch (Exception e) {
			log.debug("注册个人信息保存常完成，保存游戏tag报错！");
		}
		
		inviteService.createInvitetoUser(Integer.parseInt(PropertiesUtil.getProperty("initInvitNum")), user.getUserid()); 
		inviteService.useInvite(invitecode,user.getUserid());
		
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
		//cookie记录是否自动登录   
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
		//验证码 判断部分
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
			user.setMyFans(followService.countUserFans(user.getUserid()));
			user.setMyFollowed(followService.countUserFollowed(user.getUserid()));
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
	@ResponseBody
	public String checkEmail(@PathVariable String email ){

		String retValue = "";
		if (userService.checkEmail(email)) {
			retValue = "{\"check\":\"OK\"}";
		}else {
			retValue = "{\"check\":\"False\"}";
		}
		return retValue;
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

		return "redirect:/login"; 
	} 
	
	
	//设置  处理ajax提交修改内容
	@RequestMapping("/user/set/{tab}/") 
	@ResponseBody
	public String changepwd(HttpSession session,@PathVariable String tab,HttpServletRequest request ,ModelMap modelMap) { 
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT); 
		String retValue = "";
		if("changepwd".equals(tab)){
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			if (StringUtils.isEmpty(oldpwd) || !oldpwd.equals(CommonUtil.decoderStr(user.getPassword()))) {
				retValue = "{\"ret\":\"wrongpwd\"}";
			}else {
				userService.changePassword(user.getEmail(), newpwd);
				user.setPassword(CommonUtil.encoderStr(newpwd));
				session.setAttribute(CommonUtil.USER_CONTEXT,user);
				retValue = "{\"ret\":\"OK\"}";
			}
		}else if ("baseinfo".equals(tab)) {
			String uname = request.getParameter("uname");
			String gametext = request.getParameter("gametext");
			String signing = request.getParameter("signing");
  
			user.setUsername(uname);
			user.setSigning(signing);
			user.setGame(gametext);
			try {
				tagService.saveGameTag(gametext,user.getUserid());
			} catch (Exception e) {
				log.debug("修改个人信息保存常玩游戏报错！");
			}
 
			userService.updateinfo(user);
//		  session.setAttribute(CommonUtil.USER_CONTEXT,user);
			retValue = "{\"ret\":\"OK\"}";
		} 
		  
		return retValue;
	} 
	
	@Autowired
	private InviteService inviteService;
	//设置  跳转显示页面
	@RequestMapping("/set/{tab}/")  
	public String setting(HttpSession session,@PathVariable String tab,HttpServletRequest request ,ModelMap modelMap) { 
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT); 
		modelMap.put("user", user);
		modelMap.put("tab", tab);
		if ("invite".equals(tab)) {
			Map map = new HashMap();
			map.put("ownerid", user.getUserid());
			modelMap.put("invitelist", inviteService.getOwnerInvite(map));
		}
		return "setting";
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
			userList = userService.followedUsers(map);
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
			list = userService.followedUsers(map); 
		}else if ("fans".equals(tab)) {
			list = userService.usersFans(map); 
		}
		
	    return list; 
	}
	
	
	@RequestMapping(value="user/search/{searchStr}/page/{start}/{step}")
	@ResponseBody
	public List userSearch(@PathVariable String searchStr,@PathVariable int start, @PathVariable int step,HttpServletRequest request, HttpSession session){
		log.debug("doc搜索 :"+searchStr);
		User user = (User)session.getAttribute(CommonUtil.USER_CONTEXT);
		Map map = new HashMap();
		map.put("nameStr", "%"+searchStr.replace(" ", "%")+"%");
		map.put("start", start);
		map.put("loginuserid", user.getUserid());
		map.put("end", start+ step);
		List<User> list = userService.userSearch(map);
		 
		return list;
	}
	
	
}
