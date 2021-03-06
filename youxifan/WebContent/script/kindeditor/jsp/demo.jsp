<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
System.out.println(htmlData);
String q = htmlData.replaceAll("&", "&amp;");
q = q.replaceAll("<", "&lt;");
q = q.replaceAll(">", "&gt;");
q = q.replaceAll("\"", "&quot;");
System.out.println(q);
%>
<!doctype html>

<%@page import="com.sun.mail.util.QDecoderStream"%><html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/lang/zh_CN.js"></script>
<link rel="stylesheet" href="<%=contextPath%>/script/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=contextPath%>/script/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/plugins/code/prettify.js"></script>	

	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<%=htmlData%>
	<form name="example" method="post" action="demo.jsp">
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=(htmlData)%></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>