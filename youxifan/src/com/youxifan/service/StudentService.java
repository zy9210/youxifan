package com.youxifan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youxifan.dao.StudentDao;
import com.youxifan.dao.StudentDaoImpl;
import com.youxifan.pojo.Student;
import com.youxifan.utils.CommonUtil;
import com.sun.jmx.snmp.daemon.CommunicationException;

@Service
public class StudentService {
	@Autowired
	private StudentDao entityDao;
	
	@Transactional
	public List<Object> getStudentList(){
		List<Object> list = entityDao.queryStudent();
		return list;
	}
	
	public void save(Student st){
		st.setPsw(CommonUtil.encoderStr(st.getPsw()));
		st.setId(CommonUtil.uniqueNum());
		entityDao.save(st);
	}
	public void delete(Object obj){
		entityDao.delete(obj);
	}
}
