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

.warnning{
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
				$("#msg").html("该邮箱不可用");  
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
	if(invitestr.trim().length == 0){
		$("#invitemsg").html("请输入邀请码");
		return false;
	}
	$("#invitemsg").html("");
	return true;
}

function checkGame(){
	var gametext = $("#gametext").val();
	if(gametext.trim().length == 0){
		$("#gamemsg").html("常玩游戏不能为空");
		return false;
	}
	$("#gamemsg").html("");
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
	return true;
}
</script>

</head>
<body>
<div class="centerdiv">
	<div class="content"> 
	</div>
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11">
		<form method="post" action="<%=contextPath%>/register"  onsubmit="return submitCheck();"> 
	    	<table style="margin:300px auto 0; "> 
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
	                <td><input type="text" id="name" name="name" value="${name}"/></td>
	                <td class="warnning" id="namemsg" ></td>
	            </tr>
	            <tr >
	                <td>常玩游戏 </td> 
	                <td><ul id="game" style="max-width:400px;" ></td> 
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