<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title> 
<script language="javascript"
	src="<%=contextPath%>/script/jquery.1.3.2.js"></script>
<script language="javascript"
	src="<%=contextPath%>/script/popup_layer.js"></script>
<%
String email = request.getParameter("email");
String pwdstr = request.getParameter("pwdstr"); 
%>
<style>  

input[type=text] {
	 height:30px; 
	 font: 20px Georgia, 'Times New Roman', Times, serif; 
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;
}
input[type=password] {
	 height:30px; 
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
.content{
	font: bold 14px/18px 宋体,sans-serif;
	margin:0 auto; 
	width:960px; 
	background:url(<%=contextPath%>/images/background.jpg) no-repeat top ;  
	padding-top:400px;
	}
.head{
	width:100%;
	height:40px;
	background-color:#242424;
	color:white;
	font-style:italic;
	font-size:36px;
	font-weight: 900;
	text-indent:50px
}
#blk9{
	width:400px; 
	height:200px;
	background-color:#fff;
	border:solid 1px;
	border-radius: 5px;
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;  
}
</style>
</head>
<body>

<div class="head">
	youxifan.com         
</div> 

<div style="width:100%; height:700px; background-color:#f77400;">
	<div class="content"> 
	<form method="post" action="<%=contextPath%>/getpwd/changepwd">
		<input type="hidden" id="email" name="email" value="<%=email%>"/>  
		<input type="hidden" id="pwdstr" name="pwdstr" value="<%=pwdstr%>"/>  
    	<table style="margin:0 auto;">
    		<tr >
                <td colspan="2" style="text-align:center;color:blue;" > &nbsp;${msg} </td> 
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" id="psw" name="psw"/><span id="pswmsg" style="color:blue"></span></td>
            </tr>
            <tr>
            	<td>确认密码</td>
                <td><input type="password" id="repsw" name="repsw"/><span id="repswmsg" style="color:blue"></span></td> 
            </tr> 
            <tr >
                <td colspan="2" style="text-align:center" ><input type="submit" value="提交" onclick="return checkpwd()" /></td> 
            </tr>
        </table>
        </form>
    </div> 
</div>

<div style="width:100%;height:90px;background-color:#2a2823; border-top:solid; border-top-width:5px; border-top-color:#afafaf">
	 
</div>

<script language="javascript">

        function checkpwd(){
        	$("#pswmsg").html("");
        	$("#repswmsg").html("");
        	
        	var psw = $("#psw").val(); 
        	var repsw = $("#repsw").val(); 
        	
			if(psw.length < 6){
				$("#pswmsg").html("密码长度不能小于6位");
				return false;
			} 
			if(psw != repsw){
				$("#repswmsg").html("两次输入密码不相同");
				return false;
			} 
			return true;
        }
 </script>
</body>
</html>