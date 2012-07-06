<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<script language="javascript"
	src="<%=contextPath%>/script/jquery.min.js"></script>
	
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
	background:url(../images/background.jpg) no-repeat top ;  
	padding-top:280px;
	text-align:center;
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
.contable{
	margin:0 auto;
	text-align:left;
	filter:alpha(opacity=70);
	-moz-opacity:0.7;
	-khtml-opacity: 0.7;
	opacity: 0.7;

}
.warnning{
	color:#00F;
	}
</style>

<script type="text/javascript">
function turnback(){
	window.location.href="<%=contextPath%>/view/login.jsp";
}

function checkEmail(element){
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/user/checkEmail/" + element.value+"/",
		dataType: "json",
		success : function(data) { 
			if(data.check == "False"){ 
				$("#msg").html("该邮箱不可用");  
			}else{
				$("#msg").html("");
			} 
		},
		error :function(){
			alert("网络连接出错！");
		}
	});
}
</script>

</head>
<body>
<div class="head">
	youxifan.com         
</div>

<div style="width:100%; height:800px; background-color:#f77400; ">
	<div class="content"> 
		<form method="post" action="<%=contextPath%>/s/user/register">
		<div id="msg" style="color:blue;margin:0 auto;"> &nbsp; </div>
    	<table class="contable">
            <tr>
                <td>注册邮箱</td>
                <td><input type="text" id="email" name="email"  onBlur="checkEmail(this)"/> *</td> 
                <td class="warnning">该邮箱不可用</td>
            </tr>
            <tr>
            	<td>登录密码</td>
                <td><input type="password"  id="psw" name="psw"/></td>
                <td class="warnning">密码长度不得少于6位</td>
            </tr>
             <tr>
            	<td>确认密码</td>
                <td><input type="password" id="repsw" name="repsw"/></td>
                <td class="warnning">两次输入密码不一致</td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input type="text" id="name" name="name" /></td>
                <td class="warnning">此昵称以被使用</td>
            </tr>
            <tr >
                <td>常玩游戏 </td> 
                <td><input type="text"   /> </td> 
                <td> </td> 
            </tr>
            <tr >
                <td>邀请码 </td> 
                <td><input type="text"  id="invitecode" name="invitecode"/></td> 
                <td class="warnning">请输入邀请码 </td> 
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


<div style="width:100%;height:90px; border-top: solid; border-top-width:5px; border-top-color:#afafaf; background-color:#2a2823;">
	 
</div>

</body>
</html>