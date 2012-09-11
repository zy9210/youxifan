<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title> 
	
	<script type="text/javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
    <script language="javascript" src="<%=contextPath%>/script/jquery-ui-1.8.20.custom.js"></script>
    <script language="javascript" src="<%=contextPath%>/script/jquery.taghandler.js"></script>
    
     
 	<link rel="stylesheet" href="<%=contextPath%>/css/jquery.taghandler.css" type="text/css">  
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/jquery-ui-1.8.7.custom.css" /> 
	
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
 

a:hover, a:focus {
color: #00C0FF;
}

a { 
color: #0072A3;
text-decoration: none;  
outline: none;
}
.warnning{
	width:150px;
	color:red;
}	
	
</style>

<script type="text/javascript">
function turnback(){
	window.location.href="<%=contextPath%>/jsp/login.jsp";
}

function checkEmail( ){
	var emailstr = $("#email").val();
	
	var myReg =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(myReg.test(emailstr)==false){
		$("#msg").html("邮箱格式不正确！");
		return false;
	}
	
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/checkEmail/" + emailstr+"/",
		dataType: "json",
		success : function(data) { 
			if(data.check == "False"){ 
				$("#msg").html("该邮箱已经被注册");  
				return false;
			}else{
				$("#msg").html("");
				return true;
			} 
		},
		error :function(){
			alert("网络连接出错！");
			return false;
		}
	});
	$("#msg").html("");
	return true;
}

function checkPwd(){
	var pwdstr = $("#pwd").val();
	if(pwdstr.length < 6){
		$("#pwdmsg").html("密码长度不得少于6位");
		return false;
	}
	if(pwdstr.length > 20){
		$("#pwdmsg").html("密码长度不得大于20位");
		return false;
	}
	$("#pwdmsg").html("");
	return true;
}

function checkRepwd(){
	var pwdstr = $("#pwd").val();
	var repwdstr = $("#repwd").val();
	if(pwdstr != repwdstr){
		$("#repwdmsg").html("两次输入密码不一致");
		return false;
	}
	$("#repwdmsg").html("");
	return true;
}

function checkInvite(){
	var invitestr = $("#invitecode").val();
	if($.trim(invitestr) == ""){
		$("#invitemsg").html("请输入邀请码");
		return false;
	}
	$("#invitemsg").html("");
	return true;
}

function checkGame(){
	var gametext = $("#gametext").val();
	if($.trim(gametext) == ""){
		$("#gamemsg").html("常玩游戏不能为空");
		return false;
	}
	$("#gamemsg").html("");
	return true;
}

function checkName(){
	var name = $("#name").val();
	
	if($.trim(name) == ""){
		$("#namemsg").html("昵称不能为空");
		return false;
	}
	
	if($.trim(name).length > 60){
		$("#namemsg").html("昵称过长");
		return false;
	}

	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/checkName/" +encodeURIComponent(name)+"/",
		dataType: "json",
		success : function(data) { 
			if(data.check == "False"){ 
				$("#namemsg").html("该昵称已经被注册");  
				return false;
			}else{
				$("#namemsg").html("");
				return true;
			} 
		},
		error :function(){
			alert("网络连接出错！");
			return false;
		}
	});
	
	$("#namemsg").html("");
	return true;
}

function submitCheck(){
	var invitestr = $("#email").val();
	if(invitestr.trim().length == 0){
		$("#emailmsg").html("邮箱必填！");
		return false;
	}
	$("#emailmsg").html(""); 

	
	if(!checkPwd()){
		return false;
	}
	if(!checkRepwd()){
		return false;
	}
	if(!checkInvite()){
		return false;
	}
	if(!checkGame()){
		return false;
	}   
	if(!checkName()){
		return false;
	} 
	
	return true;
}
</script>

</head>
<body>
<div class="centerdiv">
	<div class="content"> 
	</div>
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11;TEXT-ALIGN: center; ">
		<div style="height:10%;" ></div>
		<img   src="<%=contextPath%>/images/LOGO_background.jpg"  style="width:380px; margin:0 auto 0;" >
		
		<form method="post" action="<%=contextPath%>/register"  onsubmit="return submitCheck();"> 
	    	<table style="margin:20px auto 0; TEXT-ALIGN:left;  "> 
	    	 	<tr>
	    	 	    <td> </td>
	                <td  colspan=2 style="color:red;" >${addstate}</td> 
	            </tr>
	            <tr>
	                <td>注册邮箱</td>
	                <td><input type="text" id="email" name="email" value="${email}"  onBlur="checkEmail()"/></td> 
	                <td class="warnning" id="msg"></td>
	            </tr>
	            <tr>
	            	<td>登录密码</td>
	                <td><input type="password"  id="pwd" name="pwd"  onBlur="checkPwd()"/></td>
	                <td class="warnning" id="pwdmsg"></td>
	            </tr>
	             <tr>
	            	<td>确认密码</td>
	                <td><input type="password" id="repwd" name="repwd" onBlur="checkRepwd()"/></td>
	                <td class="warnning" id="repwdmsg"></td>
	            </tr>
	            <tr>
	                <td>昵称</td>
	                <td><input type="text" id="name" name="name" value="${name}" onBlur="checkName()"/></td>
	                <td class="warnning" id="namemsg" ></td>
	            </tr>
	            <tr>
	                <td>性别</td>
	                <td>
						<input type="radio" name="gender" value="1" ${gender == null || gender == '1' ? "checked" : ""}> 男     
						<input type="radio" name="gender" value="0" ${ gender == '0' ? "checked" : ""}> 女  
					</td>
	                <td class="warnning" id="gendermsg" ></td>
	            </tr> 
	            <tr >
	                <td>常玩游戏 </td> 
	                <td><ul id="game" style="width:175px;" ></td> 
	                <td class="warnning" id="gamemsg"> </td> 
	            </tr>
	            <tr >
	                <td>邀请码 </td> 
	                <td><input type="text"  id="invitecode" name="invitecode" value="${invitecode}" onBlur="checkInvite()"/></td> 
	                <td class="warnning" id="invitemsg"> </td> 
	            </tr>
	            <tr >
	                <td></td> 
	                <td style="text-align:center;"><input type="submit" value="注册" /> </td> 
	                <td> </td> 
	            </tr>
	        </table>
        </form>
    </div> 
</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	$('#game').tagHandler({
		autocomplete: true, 
		allowAdd: true,  
		assignedTags: [ ${gametext}], 
		getURL:'<%=contextPath %>/tag/search/fid/0',  
		afterAdd: function(tag){ 
		},
		submitField:'gametext',
		afterDelete:function(tag){ 
		}
	});
});
</script>
</body>
</html>