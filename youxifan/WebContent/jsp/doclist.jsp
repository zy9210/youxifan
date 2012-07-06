<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>首页</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css">


</head>

<body>

<div class="container">

  <div class="header">
  	<a href="#" style="float:left; margin-left:10px;">
    	<img src="<%=contextPath %>/images/logo.jpg" alt="游戏烦" name="Insert_logo" width="116" height="56" id="Insert_logo" style=" padding-top:5px; " />
    </a> 
    <div style="float:left; padding-top:18px; margin-left:10px;">
    	<input id="searchinput" type="text" style=" " />
        <span id="stext" >提交新问题</span>
    </div> 
    <div  id="headnav">   
        <a href="#" style="float:left; margin-left:10px; color:#FFF;">
            首页
        </a> 
        <a href="#" style="float:left; margin-left:50px; color:#FFF;">
            话题广场
        </a> 
    </div>
  <!-- end .header --></div>
    
  <div class="content">
  	
    <div class="subheader">  
        <div id="tabs">
            <a class="youarehere" href="#" title="">新问题</a> 
            <a href="#" title=" ">热门问题</a> 
            <a href="#" title=" ">我的问题</a>
            <a href="#" title=" ">我的答案</a>
        </div> 
    </div> 
    
    <div class="questions"> 
<c:forEach items="${doclist}" var="doc">
        <div class="summary" id="question-summary-${doc.docid}">
            <h3 style=""><a href="<%=contextPath%>/doc/id/${doc.docid}" class="question-hyperlink">${doc.title}</a></h3>
            <div class="qinfo"  >
                <span class="qcreator"  >${doc.creater.username}</span>  
                <span class="qcreatedate">发表于${doc.createdateStr}</span>
                <span class="guanzhu"><a href="#" >关注 </a></span>
            </div>
            <div class="excerpt">
                ${doc.content}
            </div>
            <div class="tags" > 
                <a href="#" class="taglink" title="title" >魔兽世界</a> 
                <a href="#" class="taglink" title="title" >战士</a> 
                <a href="#" class="taglink" title="title" >战士</a> 
             </div>
        </div> 
</c:forEach>
    
    
    <!-- end #questions --></div>
  
    
    
    <!-- end .content --></div>
    
  <div class="sidebar1">
  
  	<div class="userarea">
    	<div class="user">
        	<a href="" class="headimg">
        		<img src="images/background.jpg" width="60px" height="60px" />
            </a>
            <div class="userinfo">
            	<div class="username">逆天大战士</div>
                <div class="usertag">魔兽世界</div>
                <div class="signing">接说明了一种基本导航结构，该结构使用以 CSS 设置样式的无序列</div>
            </div>
            <div class="shortcut">
            	<a href="#" >我关注的人 </a> 
                <a href="#" >关注我的人 </a>
            </div>
        </div><!-- end .user -->
    </div><!-- end .userarea -->
    
    <div style="border-bottom:1px solid #BFBFBF; margin-bottom:10px; padding-bottom:5px;">
        <a href="#" class="invite" >
            我的邀请
        </a>
    </div>
    
    <div>
    	<strong>你可能感兴趣的话题</strong>
        <div class="interest" >
        	<a href="#" class="tag" >魔兽世界</a>
            <a href="#" class="attentionlink fltrt">关注</a>
            <span class="desc"  >该话题下有333个问题</span>
        </div>
        
        <div class="interest" >
        	<a href="#" class="tag" >魔兽世界</a>
            <a href="#" class="attentionlink fltrt">关注</a>
            <span class="desc"  >该话题下有333个问题</span>
        </div>
        <div class="interest" >
        	<a href="#" class="tag" >魔兽世界</a>
            <a href="#" class="attentionlink fltrt">关注</a>
            <span class="desc"  >该话题下有333个问题</span>
        </div>
        <div class="interest" >
        	<a href="#" class="tag" >魔兽世界</a>
            <a href="#" class="attentionlink fltrt">关注</a>
            <span class="desc"  >该话题下有333个问题</span>
        </div>
        <div class="interest" >
        	<a href="#" class="tag" >魔兽世界</a>
            <a href="#" class="attentionlink fltrt">关注</a>
            <span class="desc"  >该话题下有333个问题</span>
        </div>
        
        
    </div>
    
    
    <!-- end .sidebar1 --></div>
    
  <div class="footer">
    <p>此 .footer 包含声明 position:relative，以便为 .footer 指定 Internet Explorer 6 hasLayout，并使其以正确方式清除。如果您不需要支持 IE6，则可以将其删除。</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
</html>
