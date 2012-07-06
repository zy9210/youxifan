<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档列表</title>

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
<c:forEach items="${doclist}" var="doc">
	<div>
		<div style=" ">
			<div  >
				<img  src="<%=contextPath%>/${doc.creater.imageurl}" />
			</div>
			<dir > ${doc.creater.alias}</dir>
		</div>
		<div>
			<div style="font:20px ">${doc.title}</div>
			<div>${doc.content}</div>
		</div>
	</div>
</c:forEach>


<strong>提交问题</strong>
<form method="post" action="<%=contextPath%>/doc.do?method=add">
	<input type="hidden" id="doctype" name="doctype" value="1" />
	<div>标题</div>
	<input type="text" id="title" name="title" />
	<div>内容</div>
	<textarea class="r3px " id="content" name="content" placeholder="问题内容"></textarea>
	<input type="submit" value="提交"/>
</form>

</body>
</html>