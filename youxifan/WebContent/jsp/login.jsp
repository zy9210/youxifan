<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title> 
<script language="javascript"
	src="<%=contextPath%>/script/jquery.1.3.2.js"></script>
<script language="javascript"
	src="<%=contextPath%>/script/popup_layer.js"></script>

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
	background:url(<%=contextPath%>/images/background.jpg) no-repeat top ;  
	padding-top:400px;
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
#blk9{
	width:400px; 
	height:200px;
	background-color:#fff;
	border:solid 1px;
	border-radius: 5px;
	 -webkit-border-radius: 5px; 
	 -moz-border-radius: 5px;  
}
</style>
</head>
<body>

<div class="head">
	youxifan.com         
</div> 

<div style="width:100%; height:700px; background-color:#f77400;">
	<div class="content"> 
	<form method="post" action="<%=contextPath%>/user/login">
    	<table style="margin:0 auto;">
    		<tr>
    			<td colspan="2" style="text-align:center;color:blue;" > &nbsp;${msg} </td> 
    		</tr>
            <tr>
                <td>邮箱</td>
                <td>密码</td> 
            </tr>
            <tr>
            	<td><input type="text"  id="email" name="email" value="${loginemail!=null?loginemail:''}"/></td>
                <td><input type="password" id="psw" name="psw"/></td>
                <td><input type="submit" value="登录" /></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="remlginstate" name="remlginstate"/>记住我的登录状态</td>
                <td><a href="javascript:void(0)"   id="ele9" >忘记密码</a></td>
            </tr>
            <tr >
                <td colspan="2" style="text-align:center" > <a href="<%=contextPath%>/jsp/register.jsp" >申请注册</a>需要邀请码</td> 
            </tr>
        </table>
        </form>
    </div> 
</div>

<div style="width:100%;height:90px;background-color:#2a2823; border-top:solid; border-top-width:5px; border-top-color:#afafaf">
	 
</div>

<div style="display: none" id="blk9" class="blk" >
    <div class="head" style=" font: 30px 宋体，  'Times New Roman', Times, serif;font-weight: 900;text-indent:10px">
        <div class="head-right"> 
        	找回密码
        </div>
    </div>
    <div class="main" style="text-align:left; padding-left:20px; ">
    
	   <div style="font: bold 20px 宋体; padding:10px 0; "> 请输入您注册的邮箱：</div>
	   <input type="text" id="getpwdemail" onBlur="testEmail(this)" />
		<span id="msg" style="color:red"></span>
	   <div>
	   		<input type="button" value="发送" id="sendemail" onclick="getpwd()" style="margin-top:10px; padding:5px 10px;font: bold 20px 宋体;" />
	   		<input type="button" value="关闭" id="close9" style="margin-top:10px; padding:5px 10px;font: bold 20px 宋体;" />
	   </div>
	     
    </div>
    <div class="foot" style="display: none;">
        <div class="foot-right">
        </div>
    </div>
</div>
<script language="javascript">

        $(document).ready(function() {

            //示例9，综合效果
            var t9 = new PopupLayer({ trigger: "#ele9", popupBlk: "#blk9", closeBtn: "#close9", useOverlay: true, useFx: true,
                offsets: {
                    x: 0,
                    y: 0
                }
            });
            t9.doEffects = function(way) {
                if (way == "open") {
                    this.popupLayer.css({ opacity: 0.3 }).show(400, function() {
                        this.popupLayer.animate({
                            left: ($(document).width() - this.popupLayer.width()) / 2,
                            top: (document.documentElement.clientHeight - this.popupLayer.height()) / 2 + $(document).scrollTop(),
                            opacity: 0.8
                        }, 1000, function() { this.popupLayer.css("opacity", 1) } .binding(this));
                    } .binding(this));
                }
                else {
                    this.popupLayer.animate({
                        left: this.trigger.offset().left,
                        top: this.trigger.offset().top,
                        opacity: 0.1
                    }, { duration: 500, complete: function() { this.popupLayer.css("opacity", 1); this.popupLayer.hide() } .binding(this) });
                }
            }
        });

		
        function getpwd(){

        	var email = $("#getpwdemail").val(); 
        	
        	var myReg =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
			if(myReg.test(email)==false){
				$("#msg").html("邮箱格式不正确！");
				return;
			}
			
             
        	$.ajax( {
        		type : "POST",
        		url : "<%=contextPath%>/getpwd/sendEmail/" + email+"/",
        		dataType: "json",
        		success : function(data) { 
        			if(data.send == "true"){ 
        				$("#msg").html("邮件发送成功！");  
        			}else if(data.send == "noemail"){
        				$("#msg").html("该邮箱没有注册！");
        			} else{
        				$("#msg").html("发送失败,稍后重试！");
            		}
        		},
        		error :function(){
        			$("#msg").html("网络连接出错！");
        		}
        	});
        }
 </script>
</body>
</html>