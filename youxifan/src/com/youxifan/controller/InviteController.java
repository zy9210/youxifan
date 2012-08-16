package com.youxifan.controller;

 
import java.io.PrintWriter; 
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
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
import com.youxifan.pojo.Invite;
import com.youxifan.pojo.Tag;
import com.youxifan.pojo.User;
import com.youxifan.service.DocService;
import com.youxifan.service.InviteService;
import com.youxifan.service.TagService; 
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.EMail;

@Controller 
public class InviteController {
	
	protected final transient Log log = LogFactory
	.getLog(InviteController.class);
	
	@Autowired
	private TagService tagService; 
	
	@Autowired
	private InviteService inviteService; 
	
	
	public InviteController(){
		 
	}
	
	@RequestMapping(value="/invite/create/{maxi}")
	@ResponseBody
	public String createInvite(@PathVariable int maxi,HttpServletResponse response, ModelMap modelMap) throws Exception{
		Map map = new HashMap();
		map.put("maxinvite", maxi);
		List<Map> list = inviteService.getUserUsefulInvite(map);
		long userid = 0;
		long usefuli = 0;
		Invite invite = null;
		for (Map m : list) {
			userid =((BigInteger) m.get("userid")).longValue();
			usefuli =(Long) m.get("myin");
			for (int i = 0; i < maxi - usefuli; i++) {
				invite = new Invite();
				invite.setOwnerid(userid);
				invite.setInvitestr(CommonUtil.generateGUID());
				inviteService.save(invite);
			}
		}
		response.setCharacterEncoding("utf-8");
		return "生成邀请码完成！";
	}
	
	
	@RequestMapping(value="/invite/create/{addnum}/{userid}")
	@ResponseBody
	public String createInvitetoUser(@PathVariable int addnum,@PathVariable long userid,HttpServletResponse response, ModelMap modelMap){
		
		for (int i = 0; i < addnum; i++) {
			Invite invite = new Invite();
			invite.setOwnerid(userid);
			invite.setInvitestr(CommonUtil.generateGUID());
			inviteService.save(invite); 
		}
		response.setCharacterEncoding("utf-8");
		return "生成邀请码完成！";
	}
	
	
	
	@RequestMapping(value="/invite/plus1/{maxi}")
	@ResponseBody
	public String plus1(@PathVariable int maxi,HttpServletResponse response, ModelMap modelMap) throws Exception{
		Map map = new HashMap();
		map.put("maxinvite", maxi);
		List<Map> list = inviteService.getUserUsefulInvite(map);
		long userid = 0;
		long usefuli = 0;
		Invite invite = null;
		for (Map m : list) {
			userid =((BigInteger) m.get("userid")).longValue();
			usefuli =(Long) m.get("myin");
			if(maxi > usefuli) {
				invite = new Invite();
				invite.setOwnerid(userid);
				invite.setInvitestr(CommonUtil.generateGUID());
				inviteService.save(invite);
			}
		}
		response.setCharacterEncoding("utf-8");
		return "生成邀请码完成！";
	}

	
	@RequestMapping(value="/search/{tab}/{searchstr}") 
	public String search(@PathVariable String tab,@PathVariable String searchstr,HttpServletRequest request, ModelMap modelMap){
		String p = request.getParameter("p");
		System.out.println(searchstr);
		modelMap.put("tab", tab);
		return "search";
	}
	
	
	
	
}
