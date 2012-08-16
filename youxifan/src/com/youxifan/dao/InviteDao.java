package com.youxifan.dao;

import java.util.List;
import java.util.Map;

import com.youxifan.pojo.Invite;

public interface InviteDao {
	public List<Invite> getOwnerInvite(Map map );
	public List<Map> getUserUsefulInvite(Map map );
	public Invite findInviteByCode(Map map);
	public void useInvite(Map map);
	public void save(final Invite model);
	public void update(final Invite model);
	public void delete(final Invite model);
}
