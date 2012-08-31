<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>设置</title> 
	<script language="javascript"   src="<%=contextPath %>/jcrop/js/jquery.min.js"></script>
	<script language="javascript"  src="<%=contextPath %>/jcrop/js/swfobject.js"></script> 
	<script language="javascript"  src="<%=contextPath %>/jcrop/js/jquery.uploadify.v2.1.4.js"></script>
	<script language="javascript"   src="<%=contextPath %>/jcrop/js/jquery.Jcrop.js"></script>


	<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css">  
	
</head>

<body>
<%@ include file="/include/header.jspf"%>
<div class="container"> 
	
	<!-- class="content"    因为头像设置要更宽的宽度  所以没有办法用centent的class -->
	
	<div style="min-height:600px;">
	
		<div class="subheader">
			<div id="tabs">
				<a ${tab== "userinfo"?"class=\"youarehere\"":""}  href="<%=contextPath%>/set/userinfo/"  >基础信息</a>
				<a ${tab== "changepwd"?"class=\"youarehere\"":""} href="<%=contextPath%>/set/changepwd/"  >修改密码</a>
				<a ${tab== "headimg"?"class=\"youarehere\"":""} href="<%=contextPath%>/set/headimg/"  >设置头像</a>
				<a ${tab== "invite"?"class=\"youarehere\"":""} href="<%=contextPath%>/set/invite/"  >我的邀请</a>
			</div>
		</div>
		
		<div id="retMsg"  > 
		</div>
		
		
		
		
<c:if  test="${tab == 'changepwd'}">			
		<div id="pswd">
			<table style="margin:40px 0 40px 40px;" cellpadding="10" >
				<tr>
	                <td class="cell lable">当前密码</td>
	                <td class="cell"><input id="oldpwd" name="oldpwd" type="password"/></td>  
	            </tr>
	            <tr>
	                <td class="cell lable">新密码</td>
	                <td class="cell"><input id="newpwd" name="newpwd" type="password"/></td>  
	            </tr>
	            <tr>
	                <td class="cell lable">确认密码吗</td>
	                <td class="cell"><input id="repwd" name="repwd" type="password"/> </td>  
	            </tr>
	            
	            <tr>
	                <td></td>
	                <td><input type="button" value="保存" onclick="changepwd();"/></td>  
	            </tr>
	            
			</table> 
		</div>
		
</c:if>		
		
<c:if  test="${tab == 'userinfo'}">		
		<%@ include file="/include/baseinfo.jspf"%>
</c:if>	


<c:if  test="${tab == 'headimg'}">
		<%@ include file="/jcrop/userhead.jspf"%>
</c:if>	


<c:if  test="${tab == 'invite'}">
	<div> 您所有拥有的邀请码：</div> <br/>
	<c:forEach items="${invitelist}" var="invite" varStatus="status" >
        <div >
            <span>${invite.invitestr}</span>
            <span></span>
        </div> 
        <c:if  test="${status.count % 5 == 0}">
        	<br/>
        </c:if>	
	</c:forEach>
</c:if>	
		
		
		
		
		
		
	<!-- end .content --></div>


	<div class="footer">
		<%@ include file="../include/footer.jspf"%> 
	<!-- end .footer --></div>
<!-- end .container --></div>

</body>



<script type="text/javascript">

function changepwd(){
	var oldpwd = $("#oldpwd").val();
	var newpwd = $("#newpwd").val();
	var repwd = $("#repwd").val();

 
	if(newpwd != repwd){
		$("#retMsg").html("两次输入密码不同！");
		$("#retMsg").show();
		setTimeout( function() {$("#retMsg").hide();}, 15000);
	}else{
		$.ajax({type:"POST", 
	        url:"<%=contextPath%>/user/set/changepwd/", 
	        data:"oldpwd="+oldpwd+"&newpwd="+newpwd, 
	        dataType:"json",
	        success:function (data) {
	        	if(data.ret=="wrongpwd"){ 
	        		$("#retMsg").html("当前密码错误！");
	        		$("#retMsg").show();
	        		setTimeout( function() {$("#retMsg").hide();}, 15000);
	        	}else{
	        		$("#retMsg").html("密码修改成功！");
	        		$("#retMsg").show();
	        		$("#oldpwd").val("");
	        		$("#newpwd").val("");
	        		$("#repwd").val("");
	        		setTimeout( function() {$("#retMsg").hide();}, 15000);
	        	}
	        }
		});
	}
}

 
</script>




<style type="text/css">

#retMsg
{
	width:700px; 
	height:50px;
	line-height:50px;
	text-align:center;
	background:#eee; 
	border: 1px solid #bfbfbf;
	box-shadow:0 1px 4px rgba(0, 0, 0, .5);
	-webkit-box-shadow:0 1px 4px rgba(0, 0, 0, .5);
	border-radius:5px 5px 5px 5px;
	-webkit-border-radius:5px 5px 5px 5px;
	
	display:none;
	
	
} 

.lable{
	text-align:right;
	
	vertical-align: middle;
	/* padding:15px 25px 10px 10px;   */ 
}


</html>
