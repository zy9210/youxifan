package com.youxifan.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Object> getUserList(){
		List<Object> list = entityDao.query();
		return list;
	}
	
	/**
	 * 保存user
	 */
	public void save(User user){
		user.setPassword(CommonUtil.encoderStr(user.getPassword()));
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
	public User getUserByID(long userid){
		return (User)entityDao.getUserByID(userid);
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
	 *根据email修改对账号的密码
	 */
	public boolean changePassword(String email,String password){
		Map p = new HashMap<String, String>();
		p.put("email", email);
		p.put("password", CommonUtil.encoderStr(password)); 
		entityDao.changePassword(p);
		return false;
	}
	
	
	public void delete(Object obj){
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
