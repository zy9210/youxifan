<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>  
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
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
	/*
	width:100%; 
	height:100%; 
	float:left;
	document.body.offsetHeight  + "px"
	
	width:100%; 

	height : expression(function(){this.style.height = document.body.offsetHeight  + "px";});
	background:#000 url(<%=contextPath%>/images/wallpaper/<%=new java.util.Random().nextInt(5)%>.jpg) no-repeat center;
*/
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
</style>
<script type="text/javascript">
$().ready(function(){ 
	$('.centerdiv').height(document.body.scrollHeight);   //  window.screen.availHeight
	});
</script>
</head>
<body > 
<div class="centerdiv">  
	<div class="content" style="overflow:hidden;">  
	</div> 
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11; TEXT-ALIGN: center; ">
	<div style="height:30%;" ></div>
	<form method="post" action="<%=contextPath%>/login" >
    	<table style="margin:0 auto ;  ">
    		<tr>
    			<td colspan="2" style="text-align:center;color:blue;" > &nbsp;${msg} </td> 
    		</tr>
            <tr>
                <td class="label" >邮箱</td>
                <td class="label" >密码</td> 
            </tr>
            <tr>
            	<td><input class="input" type="text"  id="email" name="email" value="${loginemail!=null?loginemail:''}"/></td>
                <td><input class="input" type="password" id="psw" name="psw"/></td>
                <td><input type="submit" value="登录" /></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="remlginstate" name="remlginstate"/>记住我的登录状态</td>
                <td><a href="<%=contextPath%>/jsp/forgetpwd.jsp"  >忘记密码</a></td>
            </tr>
            <tr >
                <td colspan="2" style="text-align:center" > <a href="<%=contextPath%>/jsp/register.jsp" >申请注册</a>需要邀请码</td> 
            </tr>
        </table>
        </form>
        <div style=" width:440px; margin:0 auto ; ">
        	<img   src="<%=contextPath%>/images/des1.png"  style="float:left;" >
        	<img   src="<%=contextPath%>/images/des2.png"  style="float:left;margin-left:40px;" >
        </div>
        <div style="clear:both;height:0px ;" ></div>
    </div> 
</div> 
</body>
</html>