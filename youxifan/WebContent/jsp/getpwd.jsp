<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码重置</title> 
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
	<form method="post" action="<%=contextPath%>/getpwd/changepwd">
		<input type="hidden" id="email" name="email" value="<%=email%>"/>  
		<input type="hidden" id="pwdstr" name="pwdstr" value="<%=pwdstr%>"/>  
    	<table style="margin:300px auto 0; ">
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