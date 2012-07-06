<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>

<script language="javascript" src="<%=request.getContextPath()%>/script/jquery.min.js"></script>
<style>
table{  border-collapse:collapse;  }
td{  border:1px solid #f00;  }
</style>
<script type="text/javascript">
function add(){
	window.location.href="<%=request.getContextPath() %>/student.do?method=add";
}

function del(id){
$.ajax( {
	type : "POST",
	url : "<%=request.getContextPath()%>/student.do?method=del&id=" + id,
	dataType: "json",
	success : function(data) {
		if(data.del == "true"){
			alert("删除成功！");
			$("#" + id).remove();
		}
		else{
			alert("删除失败！");
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
<table >
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>eMail</td>
		<td>密码</td>
		<td>个性签名</td>
	</tr>
	<c:forEach items="${userlist}" var="user">
	<tr id="<c:out value="${user.userid}"/>">
		<td><c:out value="${user.userid}"/></td>
		<td><c:out value="${user.username}"/></td>
		<td><c:out value="${user.email}"/></td>
		<td><c:out value="${user.password}"/></td>
		<td><c:out value="${user.signing}"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>