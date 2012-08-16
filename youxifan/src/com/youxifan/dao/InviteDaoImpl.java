package com.youxifan.dao;

import java.util.List;
import java.util.Map;


import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.youxifan.pojo.Invite;
 

public class InviteDaoImpl extends SqlSessionDaoSupport implements InviteDao{
	

	public List<Invite> getOwnerInvite(Map map ) {
		List<Invite> selectList = (List<Invite>) getSqlSession().selectList("Invite.getOwnerInvite",map);
		return selectList;

	}
	
	public Invite findInviteByCode(Map map){
		Invite invite = (Invite) getSqlSession().selectOne("Invite.findInviteByCode",map);
		return invite;
	}
	
	public List<Map> getUserUsefulInvite(Map map ) {
		List<Map> selectList = (List<Map>) getSqlSession().selectList("Invite.getUserUsefulInvite",map);
		return selectList;

	}


	public void delete(Invite model) {
		int row = getSqlSession().insert("Invite.delInvite",model);
	}


	public void save(Invite model) {
		int row = getSqlSession().insert("Invite.insertInvite",model);
		 
	}


	public void update(Invite model) {
		int row = getSqlSession().update("Invite.updateInvite",model);
	}

 
	public void useInvite(Map map){
		int row = getSqlSession().update("Invite.useInvite",map);
	}
	
	
	
}
