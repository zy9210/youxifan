<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>  

<style>  
body{
	position: absolute;
	width:100%; 
	height:100%; 
	margin:0px;
	padding:0px;
}
input[type=text] {
	 text-indent:3px;
	 height:30px; 
	 font: 20px Georgia, 'Times New Roman', Times, serif; 
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;
	 background:#fff;
	 background-color:#fff; 
	 outline: none;
	 
}
input[type=password] {
	 text-indent:3px;
	 height:30px; 
	 background:#fff;
	 font: 20px Georgia, 'Times New Roman', Times, serif; 
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;
}
input[type=submit] {
	 font: bold 20px Georgia, 'Times New Roman', Times, serif; 
	 border-radius: 5px;
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;  
	 height:33px;
}
.centerdiv{
	width:100%; 
	height:100%; 
	/*   */
	background:#000 url(<%=contextPath%>/images/wallpaper/<%=new java.util.Random().nextInt(5)%>.jpg) no-repeat center;
	
}

.content{
	font: bold 14px/18px 宋体,sans-serif;
	width:1000px;
	height:100%;
	margin:0 auto; 
	padding:1px 0px 1px 0px;
	background:#D3D1CE;  
	
	filter:alpha(opacity=90);
	-moz-opacity:0.9;
	-khtml-opacity: 0.9;
	opacity: 0.9;
	}
  
</style>
</head>
<body> 

<div class="centerdiv">
	<div class="content"> 
	</div>
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11">
	<form method="post" action="<%=contextPath%>/login">
    	<table style="margin:300px auto 0; ">
    		<tr>
    			<td colspan="2" style="text-align:center;color:blue;" > &nbsp;${msg} </td> 
    		</tr>
            <tr>
                <td>邮箱</td>
                <td>密码</td> 
            </tr>
            <tr>
            	<td><input type="text"  id="email" name="email" value="${loginemail!=null?loginemail:''}"/></td>
                <td><input type="password" id="psw" name="psw"/></td>
                <td><input type="submit" value="登录" /></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="remlginstate" name="remlginstate"/>记住我的登录状态</td>
                <td><a href="<%=contextPath%>/jsp/forgetpwd.jsp"  >忘记密码</a></td>
            </tr>
            <tr >
                <td colspan="2" style="text-align:center" > <a href="<%=contextPath%>/jsp/register.jsp" >申请注册</a>需要邀请码</td> 
            </tr>
        </table>
        </form>
    </div> 
</div>

 
 
</body>
</html>