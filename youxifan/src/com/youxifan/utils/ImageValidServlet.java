package com.youxifan.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
 /**
   * @author MrWang
   **/
 
public class ImageValidServlet extends HttpServlet {
    /**
     * The doGet method of the servlet. <br>
     * 
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Random random=new Random();
        response.setContentType("image/jpeg");
        int width=70,height=20;
        BufferedImage bi=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g=bi.getGraphics();
        g.setColor(getRandColor(200, 255));
        g.fillRect(0, 0, width,height);//画背景
        g.setColor(getRandColor(160,200));
        for (int i=0;i<155;i++)
        {
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                int xl = random.nextInt(12);
                int yl = random.nextInt(12);
        g.drawLine(x,y,x+xl,y+yl);//躁点
        }
        String strRandom="";
        String generateRandom="23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
        for(int i=0;i<4;i++){
            int intRandom=random.nextInt(55);
            String numRandom=generateRandom.charAt(intRandom)+"";
            strRandom+=numRandom;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.setFont(new Font("Time NewRoman",Font.BOLD,14+random.nextInt(6)));
            g.drawString(numRandom,6+13*i, 16);//画字符
        }
        
        HttpSession session=request.getSession();
        session.setAttribute("strRandom", strRandom.toLowerCase());
        g.dispose();
        ServletOutputStream sos=response.getOutputStream();
        JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(sos);
        encoder.encode(bi);
        sos.flush();
        sos.close();
        bi=null;
    }

    public Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
        }
    
    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
