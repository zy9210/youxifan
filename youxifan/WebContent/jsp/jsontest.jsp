<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title> 
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>


<script type="text/javascript"> 
function checkEmail(element){
	alert(element.value);
	$.ajax( {
		type : "get",  
		url : "<%=contextPath%>/test/jsont/",
		dataType: "json", 
		success : function(data) { 
			alert(data);
			alert(data.ret);
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
type : "POST", //contentType: "application/json",  application/xml 
		dataType: "json", //dataType: "html", json--返回json数据类型；xml--返回xml
		
		
<input type="text" id="email" name="email"  onBlur="checkEmail(this)"/>

</body>
</html>