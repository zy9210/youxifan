package com.youxifan.utils;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.*;
import java.util.*;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CommonUtil
{

    public CommonUtil()
    {
    }

    public static final String USER_CONTEXT = "loginuser";
    public static final String REQUEST_PARAMETERS= "paraMap";
    public static final String FILTERED_REQUEST = "@session_context_filtered_request";
    public static final String LOGIN_TO_URL = "login_to_url";
    
    public static String convert8859ToGB(String str)
    {
        if(str != null)
            try
            {
                str = new String(str.getBytes("8859_1"), "GB2312");
            }
            catch(UnsupportedEncodingException ue)
            {
                System.out.println(ue.getMessage());
            }
        return str;
    }

    public static String convertGBTo8859(String str)
    {
        if(str != null)
            try
            {
                str = new String(str.getBytes("GB2312"), "8859_1");
            }
            catch(UnsupportedEncodingException ue)
            {
                System.out.println(ue.getMessage());
            }
        return str;
    }

    public static String parserNull(String sourceStr, String replaceStr)
    {
        if(sourceStr == null)
            return replaceStr;
        else
            return sourceStr;
    }

    public static String parserNull(Object sourceStrObj, String replaceStr)
    {
        if(sourceStrObj == null)
            return replaceStr;
        try
        {
            return (String)sourceStrObj;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return replaceStr;
    }

    public static Date getCurrentDate(String date)
    {
        if(date == null)
            return new Date(System.currentTimeMillis());
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date tdate = sdf.parse(date);
            return tdate;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new Date(System.currentTimeMillis());
    }

    public static Date getCurrentDate()
    {
        return new Date(System.currentTimeMillis());
    }

    public static Long convertToLong(String string)
    {
        if(string == null)
            return new Long(0L);
        else
            return new Long(string);
    }

    public static String getDateStr(Date date, String pattern)
    {
        if(date == null)
            return null;
        if(pattern == null)
            pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
    
    public static String getDateTimeStr(Date date, String pattern)
    {
        if(date == null)
            return null;
        if(pattern == null)
            pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(date);
    }

    public static Date parserDateStr(String dateStr, String pattern)
    {
        if(dateStr == null)
            return null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        Date date = null;
        try
        {
            date = formater.parse(dateStr);
        }
        catch(ParseException ex)
        {
            ex.printStackTrace();
        }
        return date;
    }

    public static String getTimeStr(Time time)
    {
        if(time == null)
        {
            return "";
        } else
        {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(time);
            return (new StringBuilder(" ")).append(cal.get(11)).append(":").append(cal.get(12)).append(":").append("00").toString();
        }
    }

    public static String getNextDate(String datamod, String dateString)
    {
        Calendar now_Time = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(datamod);
        try
        {
            now_Time.setTime(df.parse(dateString));
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        now_Time.add(5, 1);
        SimpleDateFormat sdNowDate = new SimpleDateFormat(datamod);
        return sdNowDate.format(now_Time.getTime());
    }

    public static String getBeforeDate(String datamod, String dateString)
    {
        Calendar now_Time = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(datamod);
        try
        {
            now_Time.setTime(df.parse(dateString));
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        now_Time.add(5, -1);
        SimpleDateFormat sdNowDate = new SimpleDateFormat(datamod);
        return sdNowDate.format(now_Time.getTime());
    }

    public static String uniqueNum()
    {
        return (new StringBuilder(String.valueOf((new Random()).nextInt(10000))).append(String.valueOf(String.valueOf(System.currentTimeMillis())))).append(String.valueOf((new Random()).nextInt(10000))).toString();
    }

    public static String encoderStr(String str)
    {
        if(str == null)
        {
            return null;
        } else
        {
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(str.getBytes());
        }
    }

    public static String decoderStr(String str)
    {
        if(str == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            return new String(decoder.decodeBuffer(str));
        }
        catch(Exception exception)
        {
            return str;
        }
    }
    
    public static final String generateGUID(){  
        UUID uuid = UUID.randomUUID();  
        return uuid.toString();       
    }  
    
    
    public static SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");	
	public static SimpleDateFormat format3 = new SimpleDateFormat("MM月dd日 HH:mm");	
	public static SimpleDateFormat format2 = new SimpleDateFormat("dd");	
	public static SimpleDateFormat format4 = new SimpleDateFormat("今天 HH:mm");
	
	public static String getTime(Date old) {
		Date now = new Date();
		if(!format0.format(now.getTime()).equals(format0.format(old.getTime()))) {
			return format.format(old.getTime());
		} else {
			if(!format2.format(now.getTime()).equals(format2.format(old.getTime()))) {
				return format3.format(old.getTime());
			} else {
				if(now.getHours()!= old.getHours()) {
					return format4.format(old.getTime());
				} else {
					return now.getMinutes()-old.getMinutes()+"分钟前";
				}
			}
		}
	}
	
	
	public static String complete(String queryContent, Properties p)
    {
		Set<Object> keys = p.keySet();
		for (Object key : keys) {
			String  keystr = (String) key;
			queryContent=queryContent.replace("@{"+keystr+"}", p.getProperty(keystr));
		}
		
        return queryContent;
    }
	
	
	
	
	
	

    public static void main(String[] args) 
    {
        String str = "44_\u4E2D\u6587\u52A0\u5BC6ddd";
        System.out.println(encoderStr(str));
        Calendar now_Time = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        System.out.println((new StringBuilder(String.valueOf(c.get(1)))).append("-").append(c.get(2)).append("-").append(c.get(5)).toString());
        System.out.println(uniqueNum());
        System.out.println(uniqueNum());
        System.out.println(generateGUID());
        System.out.println(decoderStr("ZW5rNU1qRXlNVEE9"));
        System.out.println(System.currentTimeMillis());
         
    }
}