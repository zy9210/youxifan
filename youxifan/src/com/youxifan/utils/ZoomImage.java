package com.youxifan.utils;

import java.awt.Canvas;  
import java.awt.Component;  
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.image.AreaAveragingScaleFilter;  
import java.awt.image.BufferedImage;  
import java.awt.image.FilteredImageSource;  
import java.io.File;  
import java.util.Arrays;  
import javax.imageio.ImageIO;  

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
   
 /** 
  * 一个实用的图像放大缩小程序 
  *  
  * @author YuLimin 
  */  
 public class ZoomImage  
 {  
     private static final Log logger = LogFactory.getLog(ZoomImage.class); 
     private static Component component = new Canvas();  
     // ".pcx","tga",".tif"这三种格式目前还不支持；  
     // 这些定义的格式经过我测试过是可以支持的。  
     private static String[] imageFormatArray = new String[]{".jpg",".jpeg",".gif",".png",".bmp"};  
   
   
   
     /** 
      * 查看图像I/O库所支持的图像格式有哪些格式 
      */  
     public void listFormt()  
     {  
         String readerMIMETypes[] = ImageIO.getReaderMIMETypes();  
         String writerMIMETypes[] = ImageIO.getWriterMIMETypes();  
         if(logger.isInfoEnabled())  
         {  
             logger.info("ReaderMIMETypes:" + Arrays.asList(readerMIMETypes));  
             logger.info("WriterMIMETypes:" + Arrays.asList(writerMIMETypes));  
         }  
     }  
   
     /** 
      * 校验图像文件的格式是否可以进行缩放 
      *  
      * @param fileName 
      * @return 
      */  
     public boolean verifyImageFormat(String fileName)  
     {  
         boolean result = false;  
         for(int i = 0;i < imageFormatArray.length;i++)  
         {  
             if(fileName.toLowerCase().lastIndexOf(imageFormatArray[i]) == (fileName.length() - imageFormatArray[i].length()))  
             {  
                 result = true;  
                 break;  
             }  
         }  
         return result;  
     }  
   
     /** 
      * 将目录下的所有图像进行放大缩小 
      *  
      * @param strDir 图像的目录 
      * @param zoomRatio 放大缩小的倍率 
      * @param rebuild 是否重新创建，即已经存在的图像是否覆盖重建 
      * @throws Exception 
      */  
     public void zoom(String strDir,double zoomRatio,boolean rebuild) throws Exception  
     {  
         File fileDir = new File(strDir);  
         if(!fileDir.exists())  
         {  
             logger.warn("Not exist:" + strDir);  
             return;  
         }  
         String dirTarget = strDir + "/Zoom" + zoomRatio;  
         File fileTarget = new File(dirTarget);  
         if(!fileTarget.exists())  
         {  
             fileTarget.mkdir();  
         }  
         File[] files = fileDir.listFiles();  
         StringBuilder stringBuilder = new StringBuilder();  
         for(int i = 0;i < files.length;i++)  
         {  
             String fileFullName = files[i].getCanonicalPath();  
             String fileShortName = files[i].getName();  
             if(!new File(fileFullName).isDirectory())// 排除二级目录，如果想就再递归一次，这里省略  
             {  
                 if(verifyImageFormat(fileShortName))  
                 {  
                     if(logger.isInfoEnabled())  
                     {  
                         logger.info("Begin Zoom:" + fileFullName);  
                     }  
                     stringBuilder = new StringBuilder();  
                     stringBuilder.append(dirTarget).append("/").append(fileShortName);  
                     if(!new File(stringBuilder.toString()).exists() || rebuild)  
                     {  
                         try  
                         {  
                             createZoomSizeImage(fileFullName,stringBuilder.toString(),zoomRatio);  
                         }  
                         catch(Exception e)  
                         {  
                             logger.error("createZoomSizeImage Error:" + fileFullName,e);  
                         }  
                     }  
                     if(logger.isInfoEnabled())  
                     {  
                         logger.info("End Zoom:" + fileFullName);  
                     }  
                 }  
                 else  
                 {  
                     logger.warn("Can't Zoom:" + fileFullName);  
                 }  
             }  
         }  
     }  
   
     /** 
      * 按比例进行放大缩小图像，zoomRatio = 1为原大，zoomRatio > 1为放大，zoomRatio < 1 为缩小 
      *  
      * @param fileName 
      * @param fileNameTarget 
      * @param zoomRatio 
      * @throws Exception 
      */  
     public void createZoomSizeImage(String fileName,String fileNameTarget,double zoomRatio) throws Exception  
     {  
    	 if(zoomRatio==0.0) zoomRatio = 0.1;
         Image image = ImageIO.read(new File(fileName));  
         int width = new Double(image.getWidth(null) * zoomRatio).intValue();  
         int height = new Double(image.getHeight(null) * zoomRatio).intValue();  
         AreaAveragingScaleFilter areaAveragingScaleFilter = new AreaAveragingScaleFilter(width,height);  
         FilteredImageSource filteredImageSource = new FilteredImageSource(image.getSource(),areaAveragingScaleFilter);  
         BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);  
         Graphics graphics = bufferedImage.createGraphics();  
         graphics.drawImage(component.createImage(filteredImageSource),0,0,null);  
         ImageIO.write(bufferedImage,"JPEG",new File(fileNameTarget));  
     }
     /** 
      * 按规定尺寸进行放大缩小图像
      *  int width = 100;  
         int height = 100;  
      * @param fileName 
      * @param fileNameTarget 
      * @param zoomRatio 
      * @throws Exception 
      */  
     public String createZoomSizeImage1(int x,int y,int width,int height,String fileName,String savePath,long user_id) throws Exception  
     {  
System.out.println(savePath+fileName);
         Image image = ImageIO.read(new File(savePath+fileName)); 
         int imgw = image.getWidth(null);
         int imgh = image.getHeight(null);
         int width2 = 0;
         int height3 = 0;
         if (imgh > imgw ) {
        	 height3 = 300;
        	 width2 = new Double(imgw * (300.00/ imgh)).intValue();
		 }else {
			 width2 = 300;
			 height3 = new Double(imgh* (300.00/imgw)).intValue();
		 }
         AreaAveragingScaleFilter areaAveragingScaleFilter = new AreaAveragingScaleFilter(width2,height3);  
         FilteredImageSource filteredImageSource = new FilteredImageSource(image.getSource(),areaAveragingScaleFilter);  
         BufferedImage bufferedImage = new BufferedImage(width2,height3,BufferedImage.TYPE_3BYTE_BGR);  
         Graphics graphics = bufferedImage.createGraphics();  
         graphics.drawImage(component.createImage(filteredImageSource),0,0,null); 
         String userPath = savePath + user_id;
         if(!new File(userPath).exists()) {
         	new File(userPath).mkdirs();
         }
         if(!new File(userPath+"/temp/").exists()) {
          	new File(userPath+"/temp/").mkdirs();
          }
         ImageIO.write(bufferedImage,"JPEG",new File(userPath+"/temp/"+user_id+"_src.jpg"));
         new File(savePath+fileName).delete();
         String ret = createZoomSizeImage2(x,y,width,height,userPath ,user_id);
         new File(userPath+"/temp/"+user_id+"_src.jpg").delete();
         new File(userPath+"/temp").delete();
         return ret;
     }
     
     public String createZoomSizeImage2(int x,int y,int width,int height,String userPath,long user_id) throws Exception  
     {  
    	OperateImage zoomImage = new OperateImage(x,y,width,height);  
       	zoomImage.setSrcpath(userPath+"/temp/"+user_id+"_src.jpg"); 
       	zoomImage.setSubpath(userPath+"/temp/"+user_id+".jpg");
        zoomImage.cut();
 
		Image image = ImageIO.read(new File(userPath+"/temp/"+user_id+".jpg"));  
		int width2 = 100;  //可以设置图片宽度
		int height3 = 100; //可以设置图片高度
		AreaAveragingScaleFilter areaAveragingScaleFilter = new AreaAveragingScaleFilter(width2,height3);  
		FilteredImageSource filteredImageSource = new FilteredImageSource(image.getSource(),areaAveragingScaleFilter);  
		BufferedImage bufferedImage = new BufferedImage(width2,height3,BufferedImage.TYPE_3BYTE_BGR);  
		Graphics graphics = bufferedImage.createGraphics();  
		graphics.drawImage(component.createImage(filteredImageSource),0,0,null);   
		if(!new File(userPath).exists()) {
			new File(userPath).mkdirs();
		}
		ImageIO.write(bufferedImage,"JPEG",new File(userPath+"/"+user_id+".jpg")); 
		new File(userPath+"/temp/"+user_id+".jpg").delete();
		return  ""+user_id+"/"+user_id+".jpg";
     }
     
     /** 
      * 测试用例 
      *  
      * @param args 
      * @throws Exception 
      */  
     public static void main(String[] args) throws Exception  
     {  
         ZoomImage zoomImage = new ZoomImage();  
//         zoomImage.listFormt();  
//         // 缩小四倍  
//         zoomImage.zoom("E:/qq",0.25,false);  
//         // 放大四倍  
//         zoomImage.zoom("E:/ww",4,false);  
         zoomImage.createZoomSizeImage1(100,100,200,200,"c1674c91-9d35-48b6-b26f-f2b42ff1968b.jpg","D:\\MyWork\\workspace\\youxifan\\WebContent\\uploads\\",11100);
     }  
     
}