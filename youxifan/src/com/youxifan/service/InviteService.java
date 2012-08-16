package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.youxifan.dao.InviteDao;
import com.youxifan.pojo.Invite;
import com.youxifan.utils.CommonUtil;

@Service
public class InviteService {
	@Autowired
	private InviteDao inviteDao;
	
	public Invite findInviteByCode(String  invitecode){
		Map map = new HashMap();
		map.put("invitestr", invitecode);		
		Invite invite = inviteDao.findInviteByCode(map);
		return invite;
	}
	
	public void useInvite(String invitecode,long userid){
		Map map = new HashMap();
		map.put("invitestr", invitecode);
		map.put("userid", userid);
		inviteDao.useInvite(map);
		
	}
	
	public List<Invite> getOwnerInvite(Map map){
		List<Invite> list = inviteDao.getOwnerInvite(map);
		return list;
	}
	
	public List<Map> getUserUsefulInvite(Map map ){
		List<Map> list = inviteDao.getUserUsefulInvite(map);
		return list;
	}
	
	public void createInvitetoUser(  int addnum,  long userid){
		Invite invite = null;
		for (int i = 0; i < addnum; i++) {
			invite = new Invite();
			invite.setOwnerid(userid);
			invite.setInvitestr(CommonUtil.generateGUID());
			this.save(invite); 
		} 
	}
	
	/*
	 *return  true:还没被用，能用      false：已经被用过了
	 */
	public boolean checkInviteCode(String  invitecode){
		Invite invite = this.findInviteByCode(invitecode);
		if (invite != null) {
			return true;
		}
		return false;
	}
	
	
	public void save(Invite Invite){
		inviteDao.save(Invite);
	}
	
	
	public void delete(Invite obj){
		inviteDao.delete(obj);
	}
}
