<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>首页</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css">
<script language="javascript" src="<%=contextPath%>/script/jquery.js"></script>
<script language="javascript" src="<%=contextPath%>/script/jquery-jtemplates.js"></script>
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
    
    <div id="questions"> 
<c:forEach items="${doclist}" var="doc">
        <div class="summary" id="question-summary-${doc.docid}">
            <h3 style=""><a href="<%=contextPath%>/doc/id/${doc.docid}" class="question-hyperlink">${doc.title}</a></h3>
            <div class="qinfo"  >
                <span class="qcreator"  >${doc.creatername}</span>  
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
<c:if  test="${fn:length(doclist)== 30}">
    <input id="nextp" type="button" onclick="nextpage(30,20)" value="更多"/>
</c:if>    
 <input id="nextp" type="button" onclick="nextpage(30,20)" value="更多"/>
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
  
  
  
 	<!-- template -->
	<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
		
		{#foreach $T as doc}
		<div class="summary" id="question-summary-{$T.doc.docid}">
			<h3 style=""><a href="youxifan/doc/id/{$T.doc.docid}" class="question-hyperlink">{$T.doc.title}</a></h3>
			<div class="qinfo"  >
				<span class="qcreator"  >{$T.doc.creatername}</span>  
				<span class="qcreatedate">发表于{$T.doc.createdateStr}</span>
				<span class="guanzhu"><a href="#" >关注 </a></span>
			</div>
			<div class="excerpt">
				{$T.doc.content}
			</div>
			<div class="tags" > 
				{#foreach $T.doc.tags as tag}
				<a href="#" class="taglink" title="title" >{$T.tag.name}</a> 
				{#/for}
			 </div>
		</div> 
		{#/for}
			
			
	  -->
	</textarea>


  <script language="javascript">
  
  function nextpage(  start,  step){
	  $("#nextp").remove();
	  var template = $("#doctemp").html(); 
	  var container = $("#questions");
	  var newdiv = $("<div/>");   
	  $.ajax( {
			type : "POST",
			url : "<%=contextPath%>/doc/sort/${sort}/page/0/10",
			dataType: "json",
			success : function(data) {  
				$(newdiv).setTemplateElement("Template-Items").processTemplate(data);
				container.append($(newdiv).html());
			    var startno = parseInt(start)+parseInt(step);
			    container.append($("<input id='nextp' type='button' onclick='nextpage("+startno+","+step+")' value='更多'/>") ); 
			},
			error :function(){
				alert("网络连接出错！");
			}
		});
		  
  }
  
  </script>
</body>
</html>
