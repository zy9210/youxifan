<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码重置　- 天木游戏问答社区</title> 
<script language="javascript"
	src="<%=contextPath%>/script/jquery.1.3.2.js"></script> 
<%
String email = request.getParameter("email");
String pwdstr = request.getParameter("pwdstr"); 
%>
<style>  
body{
	position: absolute;
	width:100%; 
	height:100%; 
	margin:0px;
	padding:0px; 
	font-size: 14px ;
	color:#393939;
	font-family: 微软雅黑, Microsoft YaHei, Helvetica, Tahoma, StSun, 宋体, SimSun, sans-serif !important; 
	
}


input[type=text] { 
	 height: 30px;
	 line-height: 32px;
	 text-indent:3px; 
	 width:170px;   
	 border: 1px solid silver;  
	 background-color: #E6F3FA;
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;   
	  
}
input[type=password] { 
	 height: 30px;
	 line-height: 32px;
	 text-indent:3px; 
	 width:170px;   
	 border: 1px solid silver; 
	 background-color: #E6F3FA;
	 
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;  
	 
	  
}
input[type=submit] {
	 height: 32px;
	 line-height: 32px;
	 text-indent:3px;  
	 width:60px;  
	 color:#EEE; 
	 border: 0px; 
	 background-color: #0070A1;
	 margin-top:10px;
	 
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;  
}



.label{
	padding:3px 4px;
	font-size: 14px ;
	color:#393939;
} 
.centerdiv{ 
	width:100%; 
	min-width:1000px;
	height:768px;  
	background:#000 url(<%=contextPath%>/images/wallpaper/<%=new java.util.Random().nextInt(5)%>.jpg) no-repeat center;
}

.content{ 
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
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11;TEXT-ALIGN: center; ">
	
		<div style="height:10%;" ></div>
		<img   src="<%=contextPath%>/images/LOGO_background.jpg"  style="width:380px; margin:0 auto;" >
		
	<form method="post" action="<%=contextPath%>/getpwd/changepwd">
		<input type="hidden" id="email" name="email" value="<%=email%>"/>  
		<input type="hidden" id="pwdstr" name="pwdstr" value="<%=pwdstr%>"/>  
    	<table style="margin:20px auto 0px;  TEXT-ALIGN: left;  ">
    		<tr >
                <td colspan="2" style="text-align:center;color:blue;" > &nbsp;${msg} </td> 
            </tr>
            <tr>
                <td>密码</td>
                <td style="width:370px"><input type="password" id="psw" name="psw"/><span id="pswmsg" style="color:red"></span></td>
            </tr>
            <tr>
            	<td>确认密码</td>
                <td style="width:370px" ><input type="password" id="repsw" name="repsw"/><span id="repswmsg" style="color:red"></span></td> 
            </tr> 
            <tr >
                <td colspan="2" style="text-align:center" ><input type="submit" value="提交" onclick="return checkpwd()" /></td> 
            </tr>
        </table>
    </form>
	
    </div> 
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