<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script language="javascript"
	src="<%=contextPath%>/script/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=contextPath%>/css/common.css" />

<script type="text/javascript">
function turnback(){
	window.location.href="<%=contextPath%>/view/login.jsp";
}

function checkEmail(element){
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/s/user/checkEmail/" + element.value+"/",
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
<div style="width: 400px; margin:200px auto">
<form method="post" action="<%=contextPath%>/s/user/register">
<div id="msg" style="color: red"> &nbsp; </div>
<table style="text-align: center;">
	<tr>
		<td align="right">登陆邮箱</td>
		<td align="left">
		<input class=" r3px " id="email" name="email" type="text" onBlur="checkEmail(this)" /></td>
	</tr>
	<tr>
		<td align="right">姓名</td>
		<td align="left">
		<input class=" r3px " id="name" name="name" type="text" /></td>
	</tr>
	<tr>
		<td align="right">登陆密码</td>
		<td align="left"><input class=" r3px " id="psw" name="psw"
			type="password" /></td>
	</tr>
	<tr>
		<td align="right">个性签名</td>
		<td align="left"><textarea class="r3px " id="signing"
			name="signing" placeholder="你的职业、公司或专业特长"></textarea></td>
	</tr>
	<tr>
		<td align="right">验证码</td>
		<td align="left">
		<input class=" r3px " id="validcode" name="validcode" type="text" /> 
		<img id="imgvalidcode" name="imgvalidcode" src="<%=contextPath%>/ImageValidServlet"
			align="absmiddle"
			onclick="this.src='<%=contextPath%>/ImageValidServlet?i='+Math.random();" />
		</td>
	</tr>
	<tr>
		<td colSpan="2" align="center">
		<input type="submit" value="提交" /> 
		<input type="button" onclick="turnback()" value="登陆" />
		</td>
	</tr>
</table>

</form>
</div>

</body>
</html>