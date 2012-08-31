<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码找回</title> 
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
input[type=button] {
	 height: 32px;
	 line-height: 32px;
	 text-indent:3px; 
	 width:60px;  
	 color:#EEE; 
	 border: 1px solid silver; 
	 background-color: #0070A1;
	 
	 border-radius: 5px; 
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;  
}

.centerdiv{
	width:100%; 
	height:100%; 
	/*   */
	background:#000 url(<%=contextPath%>/images/wallpaper/<%=new java.util.Random().nextInt(6)%>.jpg) no-repeat center;
	
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
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11">
		<div  style="width:400px;margin:300px auto 0; ">
	    
		   <div style="font: bold 20px 宋体; padding:10px 0; ">注册邮箱：</div>
		   <input type="text" id="getpwdemail"  />
			<div id="msg" style="color:red"></div>
		   <div>
		   		<input type="button" value="发送" id="sendemail" onclick="getpwd()" style="margin-top:10px; padding:5px 10px; " />

		   </div>
		     
	    </div>
	
    </div> 
</div>

<script language="javascript">

function getpwd(){

	var email = $("#getpwdemail").val(); 
	
	var myReg =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(myReg.test(email)==false){
		$("#msg").html("邮箱格式不正确！");
		return;
	}
	
     
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/getpwd/sendEmail/" + email+"/",
		dataType: "json",
		success : function(data) { 
			if(data.send == "true"){ 
				$("#msg").html("密码重设的链接已发送至"+email);  
				setTimeout( function() {window.location.href='<%=contextPath%>/jsp/login.jsp';}, 5000); 
			}else if(data.send == "noemail"){
				$("#msg").html("该邮箱没有注册！");
			} else{
				$("#msg").html("发送失败,稍后重试！");
    		}
		},
		error :function(){
			$("#msg").html("网络连接出错！");
		}
	});
}
 
 </script>
</body>
</html>