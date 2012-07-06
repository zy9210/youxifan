package com.youxifan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import com.youxifan.pojo.Student;
import com.youxifan.pojo.User;
import com.youxifan.service.StudentService;

@Controller
@RequestMapping("/test")
public class StudentController {
	protected final transient Log log = LogFactory
	.getLog(StudentController.class);
	
	@Autowired // (srping提供的) 默认按类型装配
	private StudentService studentService;
	
	
	@Resource(name="studentService") // ( j2ee提供的 ) 默认按名称装配
	private StudentService ss;
	
	public StudentController(){
		
	}
	
	@RequestMapping
	public String load(ModelMap modelMap){
		List<Object> list = studentService.getStudentList();
		modelMap.put("list", list);
		return "student";
	}
	
	// @RequestMapping(value = "/checkEmail/{email}/",headers =
	// "Accept=application/xml, application/json")
	// public String checkEmail(@RequestHeader("Accept") String accept,
	// @PathVariable String email, Writer writer)
//	@RequestMapping(method = RequestMethod.GET) 

/**
 * public String add(@ModelAttribute("goodsInfo") GoodsInfoModel goodsInfo,
 * DefaultMultipartHttpServletRequest multipartRequest){
 * 
 * 
 * public void importData(@RequestParam("file") MultipartFile
 * file,HttpServletResponse response,ModelMap modelMap){ 
 * int num=0; 
 * try{
 * if(!file.isEmpty())
 * { 
 * // 获得inputstream 
 * InputStream inputstream = file.getInputStream() ; 
 * num = getXlsData(inputstream); 
 * inputstream.close();
 * file=null; 
 * } 
 * String msg = "没有数据"; 
 * if(num>0)
 * { msg = "导入成功"; }
 * response.setContentType("text/html;charset=utf-8");
 * response.getWriter().write("{success:true,msg:'"+msg+"'}"); 
 * }
 * catch(Exceptione)
 * { e.printStackTrace(); } }
 * 
 * 
 */

	
	//a    Controller接受Form数据
	 @RequestMapping(value = "/saveObject.do", method = RequestMethod.POST)
	public ModelAndView saveObject(@ModelAttribute User user) {
		
		 ModelAndView view = new ModelAndView("helloWord");
		view.addObject("message", "saveObject. name1=" + user.getUsername());
		return view;
	}
	 
	
	 
	// 匹配 "/test?method=add"
	@RequestMapping(params = "method=add")
	public String add(HttpServletRequest request, ModelMap modelMap) throws Exception{
		return "student_add";
	}
	
	// 匹配 "/test?method=add"
	@RequestMapping(value ="/charset1")
	public void testCharset1(Writer writer) throws Exception{  
		try {
			writer.write("----中文测试1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value ="/charset3")
	@ResponseBody 
	public String testCharset3 (HttpServletResponse response) throws Exception{
		
		return "{\"ret\", \"中文\"}";
	}
	
	@RequestMapping(value ="/charset2")
	public void testCharset2(HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println("----中文测试2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value ="/jsont")
	@ResponseBody 
	public Map<String,Object>  testjson(HttpServletResponse response) throws Exception{
		Map map = new HashMap<String, Object>();
		map.put("ret", "中文");
		return map;
	}
	
	//
	@RequestMapping(value ="/zhongwen/{chtext}")
	public String testChtext(@PathVariable String chtext) throws Exception{
		System.out.println(chtext);
		return null;
	}
	 
	
	@RequestMapping(params = "method=save")
	public String save(HttpServletRequest request, ModelMap modelMap){
		String user = request.getParameter("user");
		String psw = request.getParameter("psw");
		Student st = new Student();
		st.setUser(user);
		st.setPsw(psw);
		try{
			studentService.save(st);
			modelMap.put("addstate", "添加成功");
		}
		catch(Exception e){
			log.error(e.getMessage());
			modelMap.put("addstate", "添加失败");
		}
		
		return "student_add";
	}
	
	@RequestMapping(params = "method=del")
	public void del(@RequestParam("id") String id, HttpServletResponse response){
		try{
			Student st = new Student();
			st.setId(id);
			studentService.delete(st);
			response.getWriter().print("{\"del\":\"true\"}");
		}
		catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
