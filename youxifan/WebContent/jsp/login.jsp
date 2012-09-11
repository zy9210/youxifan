<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="天木游戏问答社区 - 交流游戏心得，分享游戏经验" />
<meta name="keywords" content="天木,游戏,问答,社区 " />
<meta name="author" content="Hege Refsnes" />
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天木游戏问答社区 - 交流游戏心得，分享游戏经验</title>   
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
<script language="javascript" src="<%=contextPath%>/script/jquery.placeholder.js"></script> 
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

 
.fltrt {  
	float: right;
	margin-left: 10px;
	margin-right: 5px;
}
.fltlft {  
	float: left;
	margin-right: 10px;
	margin-left: 5px;
}  

.label{
	padding:3px 4px;
	font-size: 14px ;
	color:#393939;
} 
.centerdiv{ 
	width:100%; 
	min-width:1000px;
	height:768px;  
	background:#000 url(<%=contextPath%>/images/wallpaper/<%=new java.util.Random().nextInt(5)%>.jpg) no-repeat center;
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

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-34289945-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body > 
<div class="centerdiv">  
	<div class="content" style="overflow:hidden;">  
	</div> 
	<div style="position: absolute;left:0px; top:0px; width:100%;height:100%; z-index:11; TEXT-ALIGN: center; ">
	<div style="height:10%;" ></div>
	<img   src="<%=contextPath%>/images/LOGO_background.jpg"  style="" >
	<form method="post" action="<%=contextPath%>/login" >
    	<table style="margin:0 auto ;text-align:left;  ">
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
        <div style=" width:440px; margin:0 auto ;margin-top:30px; ">
        	<img   src="<%=contextPath%>/images/des1.png"  style="float:left;" >
        	<img   src="<%=contextPath%>/images/des2.png"  style="float:left;margin-left:40px;" >
        </div>
        
        <div style="clear:both;height:0px ;" ></div>
        <div style="width:100%; margin-top:40px; text-align:center;"><a class="footer-item" href="http://www.miibeian.gov.cn/" target="_blank">京ICP备12036482号</a>
        </div>
    </div> 
</div> 



<style type="text/css">	
.serv-box{
	position: fixed;
	height: 205px;
	opacity: 1;
	right:-320px;
	top: 300px; 
	width: 348px; 
	overflow: hidden;
	border: 1px solid #E8E8E8;
	background-color: white;
	font-size: 12px;
	z-index: 2000;
	border-radius: 5px 0px 0px 5px;
	
	box-shadow: -2px -2px 15px #CCC;
	-webkit-box-shadow: -2px -2px 15px #CCC;
	-moz-box-shadow: -2px -2px 15px #ccc; 
	/* 
	right:-320px;
	*/
}
.serv_header{
	width: 100%;
	height: 38px;
	border-bottom: 1px solid #F0F0F0;
	line-height: 38px;
	color: #333;
	font-size:16px;
}
.serv_main{
	padding: 10px 10px 15px 20px;
	width: 267px;
}

.serv_text {
	color: #999;
	clear: both;
	width: 100%;
	height: 70px;
	border: 1px solid #D1D1D1;
	margin-top: 8px;
	margin-bottom:10px;
	padding: 5px;
	resize: none;
	_display: inline;
	font-size: 12px;
	overflow: auto;
}
.serv_submit{
	font-size: 12px;
	background: #FAFAFA;
	border: 1px solid #CCC;
	cursor: pointer;
	width: 50px;
	height: 20px;
	float: right;
	margin-top: 5px;
	border-radius: 2px;
}

.serv_mask{
	background: #EEE;
	width: 318px;
	height: 167px;
	position: absolute;
	left: 30px;
	top: 38px;
	z-index: 10;
	opacity: .5;
	filter: alpha(opacity=50);
	display: none;
}

.serv_tip{
	width: 178px;
	height: 20px;
	line-height: 20px;
	border: 1px solid #48B6FE;
	position: absolute;
	left: 50%;
	top: 50%;
	margin: -25px 0 0 -104px;
	z-index: 11; 
	text-indent: 20px;
	padding: 15px;
	display: none;
	background-color: white;
	-webkit-box-shadow: -2px -2px 15px #CCC;
	-moz-box-shadow: -2px -2px 15px #ccc;
	box-shadow: -2px -2px 15px #CCC;
	opacity: .8;
	filter: alpha(opacity=80);
} 

#contactway{
	color: #999;
	width:100%;
	font-size:12px;
	height: 20px;
	line-height: 22px;
}

#ServHideB {
	float: right;
	display: block;
	margin: 12px 12px 0 0;
	_margin-right: 6px;
	height: 16px;
	width: 16px;
	background: url(/images/close.png) no-repeat 2px -8px;
}

.servtitle{
	margin: 65px 9px 0px;
	position: absolute;
	top: 0px;
	left: 0px;
	font-weight: bold;
	color: white;
	font-size: 14px;
	width: 16px;
}
.servtitlearea{
	width: 30px;
	height:100%;
	background-color:#666;
	float:left;
	cursor:pointer;
	border-radius: 5px 0px 0px 5px;
}
</style>

<script language="javascript">

$(document).ready(function(){ 
	$('#sugcontent').placeholder(); 
	$('#contactway').placeholder();
})
function showservbox(){
	$('#ServBox').animate({right:0},"slow");
	$('#ServBox').show(500); 
}

function hideservbox(){
	$('#ServBox').animate({right:-320},"slow");
	//$("#ServBox").hide(1000);
}
function subsuggestion(){
	var contactway = $('#contactway').val();
	var sugcontent = $('#sugcontent').val();
	$('#ServMask').show();
	$('#ServTip').show();

	if(contactway.length > 200){
		alert("联系方式内容太长！");
		return;
	}

	if(sugcontent.length > 2000){
		alert("内容太长！");
		return;
	}
	
	if(contactway == "" && sugcontent == ""){ 
		$('#ServBox').animate({right:-320},"slow");
		$('#ServMask').hide();
		$('#ServTip').hide();
		return;
	}

	if(contactway == "联系方式:EMail或电话" && sugcontent == "您的建议是我们不断改进的动力"){ 
		$('#ServBox').animate({right:-320},"slow");
		$('#ServMask').hide();
		$('#ServTip').hide();
		return;
	}
	
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/suggestion/",
		data:"contact="+encodeURIComponent(contactway)+"&content="+encodeURIComponent(sugcontent),
		dataType: "json",
		async:false,
		success : function(data) {  
			//$("#ServHideB").trigger("click");
			$('#ServBox').animate({right:-320},"slow");
			$('#contactway').val("");
			$('#sugcontent').val("");
			
			$('#ServMask').hide();
			$('#ServTip').hide();
		} 
	});
	//$("#ServHideB").trigger("click");
	//$('#ServBox').animate({right:0},"slow");
} 

</script>

<div class="serv-box" id="ServBox" style="display:inline; ">
	<div class="servtitlearea"  onclick="$('#ServBox').animate({right:0},'slow');" >
		<div class="servtitle">意见反馈</div>
	</div>
	<div style="width:318px;float:left;">
		<div class="serv_header">
			<div class="fltlft">反馈意见给开发团队 </div>
			<a id="ServHideB" class="fltrt" href="javascript:void(0)" onclick="hideservbox()"></a>
			<div class="clboth" ></div>
		</div>
		<div class="serv_main">  
			<input type="text" id="contactway" style="" placeholder="联系方式:EMail或电话"  />
			<textarea id="sugcontent" class="serv_text"  placeholder="您的建议是我们不断改进的动力"></textarea>
			<button id="ServSubmit" class="fltrt" onclick="subsuggestion()" >提 交</button>
		</div>
		<div id="ServMask" class="serv_mask" style="display: none ">
		</div>
		<div id="ServTip" class="serv_tip" style="display: none; ">提交成功! 感谢您的反馈!</div>
	</div>
</div>


</body>
</html>