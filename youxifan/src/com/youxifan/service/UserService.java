package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.StudentDao;
import com.youxifan.dao.StudentDaoImpl;
import com.youxifan.dao.UserDao;
import com.youxifan.pojo.Student;
import com.youxifan.pojo.User;
import com.youxifan.utils.CommonUtil;
import com.youxifan.utils.ZoomImage;
import com.sun.jmx.snmp.daemon.CommunicationException;

@Service
public class UserService {
	@Autowired
	private UserDao entityDao;
	
	@Transactional
	public List<User> getUserList(){
		List<User> list = entityDao.query();
		return list;
	}
	
	public List<User> followedUsers(Map  map ){
		return entityDao.followedUsers(map);
	}
	
	public List<User> usersFans(Map  map ){
		return entityDao.usersFans(map);
	}
	
	/*
	 * 用户的搜索
	 */
	public List<User> userSearch(Map  map ){
		return entityDao.userSearch(map);
	}
	
	/**
	 * 保存user
	 */
	public void save(User user){
		user.setPassword(CommonUtil.encoderStr(user.getPassword()));
		user.setUsername( StringEscapeUtils.escapeHtml4(user.getUsername().trim()));
		user.setSigning(StringEscapeUtils.escapeHtml4(user.getSigning()));
		entityDao.save(user);
	}
	
	/**
	 * 根据email得到user
	 */
	public User getUserByEmail(String email){
		return (User)entityDao.getUserByEmail(email);
	}
	/**
	 * 根据email得到user
	 */
	public User getUserByID(Map map){
		return  entityDao.getUserByID(map);
	}
	
	/**
	 * 根据name得到user
	 */
	public User getUserByName(String name){
		return  entityDao.getUserByName(name);
	}
	/**
	 * 检查email是否注册
	 */
	public boolean checkEmail(String email){
		User user = getUserByEmail(email);
		if (user == null) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * 检查name是否注册
	 */
	public boolean checkName(String name){
		User user = getUserByName(name);
		if (user == null) {
			return true;
		}
		return false;
	}
	/**
	 *根据email修改对账号的密码
	 */
	public boolean changePassword(String email,String password){
		Map p = new HashMap<String, String>();
		p.put("email", email);
		p.put("password", CommonUtil.encoderStr(password)); 
		entityDao.changePassword(p);
		return false;
	}
	
	
	/**
	 *更新用户信息
	 */
	public boolean updateinfo(User user){
		try {
			user.setUsername(StringEscapeUtils.escapeHtml4(user.getUsername().trim()));
			user.setSigning(StringEscapeUtils.escapeHtml4(user.getSigning()));
			entityDao.updateinfo(user); 
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public void delete(User obj){
		entityDao.delete(obj);
	}
	
	/**
	 * 上传头像
	 */
	public boolean saveHeadImg(int x,int y,int width,int height,String fileName,String path, User user) {
		ZoomImage zoomImage = new ZoomImage();  
		try { 
			String url = zoomImage.createZoomSizeImage1(x,y,width,height,fileName,path,user.getUserid());
System.out.println(url);
//			url=url.replace(pathHead_url, pathHead_http);
//			IDaoFactory instance = DaoFactoryImpl.getInstance();
//			IUserDao userDao = instance.createUserDao();
			entityDao.setUserImageUrl(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}
	
	
}
