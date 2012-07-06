<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script language="javascript"
	src="<%=contextPath%>/script/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=contextPath%>/css/common.css" />

<script type="text/javascript">
</script>
</head>
<body>
<div style="width: 300px; margin:200px auto">
<form method="post" action="<%=contextPath%>/s/user/login">
<div style="color: red">&nbsp;<c:out value="${msg}"></c:out></div>
<table style="text-align: center;">
	<tr>
		<td align="right">邮箱</td>
		<td align="left"><input class=" r3px " id="email" name="email"
			type="text" /></td>
	</tr>
	<tr>
		<td align="right">密码</td>
		<td align="left"><input class=" r3px " id="psw" name="psw"
			type="password" /></td>
	</tr>
	<tr>
		<td align="right">验证码</td>
		<td align="left"><input class=" r3px " id="validcode"
			name="validcode" type="text" /> <img
			style="cursor: hand; border: none;" id="imgvalidcode"
			name="imgvalidcode" src="<%=contextPath%>/ImageValidServlet"
			align="absmiddle"
			onclick="this.src='<%=contextPath%>/ImageValidServlet?i='+Math.random();" />
		</td>
	</tr>

	<tr>
		<td colSpan="2" align="center">
		<input type="submit" value="登陆" /> 
		<input type="button" onclick="javascript:window.location.href='<%=contextPath%>/view/register.jsp';" value="注册" /></td>
	</tr>
</table> 
</form>
</div>

</body>
</html>