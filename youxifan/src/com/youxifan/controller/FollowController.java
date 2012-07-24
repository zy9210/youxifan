package com.youxifan.controller;


import java.io.IOException;
import java.io.PrintWriter; 
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

 
import com.youxifan.pojo.Follow;
import com.youxifan.service.FollowService;
import com.youxifan.service.GetpwdService;
import com.youxifan.service.UserService;
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.EMail;

@Controller 
@RequestMapping(value="/follow")
public class FollowController {
	
	protected final transient Log log = LogFactory
	.getLog(FollowController.class);
	
	@Autowired
	private FollowService followService;


	        
	public FollowController(){
		 
	}
	
	@RequestMapping(value="/{followType}/{upper}/{follower}")
	public void addFollow(HttpServletRequest request,@PathVariable long upper,@PathVariable long follower,@PathVariable String followType){
		
		Follow follow = new Follow();
		follow.setUpper(upper);
		follow.setFollower(follower);
		follow.setFollowType(followType);
		followService.save(follow); 
	}
	
	@RequestMapping(value="/cansel/{followType}/{upper}/{follower}")
	public void canselFollow(HttpServletRequest request,@PathVariable long upper,@PathVariable long follower,@PathVariable String followType){
		
		Follow follow = new Follow();
		follow.setUpper(upper);
		follow.setFollower(follower);
		follow.setFollowType(followType);
		followService.delete(follow); 
	}
	
	
	
	@Resource(name="getpwdhtml")
	private String  getpwdhtml;
	
	
	
	


}
