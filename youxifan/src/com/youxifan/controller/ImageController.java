package com.youxifan.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.youxifan.pojo.Student;
import com.youxifan.service.StudentService;

@Controller
@RequestMapping("/image.do")
public class ImageController {
	protected final transient Log log = LogFactory
	.getLog(ImageController.class);


	public ImageController(){
		
	}
	
	@RequestMapping(params = "method=upload")
	public void load(HttpServletRequest request, HttpServletResponse response){
//		String savePath = request.getServletConfig().getServletContext().getRealPath("");
		String savePath = request.getSession().getServletContext().getRealPath("");
		savePath = savePath + "/uploads/";
        //savePath = Constants.myheadImgUrl Tem;
        File f1 = new File(savePath);
System.out.println(savePath);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            return ;
        }
        Iterator<FileItem> it = fileList.iterator();
        String name = "";
        String extName = "";
        while(it.hasNext()) {
            FileItem item = it.next();
            if (!item.isFormField()) {
                name = item.getName();
                long size = item.getSize();
                String type = item.getContentType();
                System.out.println(size + " " + type);
                if (name == null || name.trim().equals("")) {
                    continue;
                }
                //扩展名格式： 
                if (name.lastIndexOf(".") >= 0) {
                    extName = name.substring(name.lastIndexOf("."));
                }
                File file = null;
                do {
                    //生成文件名：
                    name = UUID.randomUUID().toString();
                    //System.out.println("name:"+name);
                    file = new File(savePath + name + extName);
                } while (file.exists());
                File saveFile = new File(savePath + name + extName);
                try {
                    item.write(saveFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
			response.getWriter().print(name + extName); 
		} catch (Exception e) {
			log.error(e, e);
			e.printStackTrace();
		}
        
	}
	
	@RequestMapping(params = "method=save")
	public void add(HttpServletRequest request,  HttpServletResponse response) throws Exception{
		
	}
	
	@RequestMapping(params = "method=save")
	public String save(HttpServletRequest request, ModelMap modelMap){
		String user = request.getParameter("user");
		String psw = request.getParameter("psw");
		Student st = new Student();
		st.setUser(user);
		st.setPsw(psw);
		try{
			//studentService.save(st);
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
			//studentService.delete(st);
			response.getWriter().print("{\"del\":\"true\"}");
		}
		catch(Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
