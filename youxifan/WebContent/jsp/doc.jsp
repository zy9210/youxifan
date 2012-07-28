<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>问题详情</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css"> 
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
</head>

<body>

<div class="container">

  <%@ include file="../include/header.jspf"%>
    
    
    
    
  <div class="content">
  
    <div class="question" id="question-summary-${doc.docid}"> 
        <h1 class="fltlft" style="width:570px; color:#ec9902; "  >${doc.title}</h1>
        
        <a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  id="del3${doc.docid}${loginuser.userid}" class="attentionlink fltrt ${doc.followed == 0 ? "notdisplay":""}" >取消关注</a>
        <a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  id="add3${doc.docid}${loginuser.userid}" class="attentionlink fltrt ${doc.followed == 1 ? "notdisplay":""}" >关注</a>
                
        <div class="clboth" style="border-top:10px;" > 
	<c:forEach items="${doc.tags}" var="tag">
                <a href="<%=contextPath %>/tag/${tag.tagid}" class="taglink" title="${tag.tagname}" >${tag.tagname}</a> 
	</c:forEach>
         </div>
        
        <div class="excerpt" style="margin:10px 0 10px 0;">
            ${doc.content}
        </div>
        <div class="qinfo"  >
            <span class="qcreator" onclick="location='<%=contextPath%>/user/${doc.createrid}/tab/askq'"  >${doc.creatername}</span>  
            <span class="qcreatedate">发表于${doc.createdateStr}</span>
        </div>
    </div>	 <!-- end #question -->
    
    <div class="answers"> 
<c:forEach items="${doc.answers}" var="answer">      
    	<div class="answer">
            <div class="votearea"  >
            	<a href="" class="upvote">up vote</a>
                <span class="votecount" id="votecount_id">214</span>
                <a href="" class="downvote">down vote</a>
            </div>
            <div class="aarea" >
            	<div>
                ${answer.content}
                </div>
                <div class="ainfo" style="margin-top:5px; clear:both;" >
                    <span class="qcreator"  >${answer.creater.username}</span>  
                    <span class="qcreatedate">发表于${answer.createdateStr}</span>
                </div>
            </div>
            <hr style="clear:both; "/>
        </div>
</c:forEach>          
        
        
    <!-- end #answers --></div>
    
    <div class="" style="padding:0 20px 20px 20px;">
    	<h1>添加答案</h1>
        <textarea  class="postarea" placeholder="添加你的答案" ></textarea>
        <input class="fltrt"  type="button" value="提交答案" style="padding:2px; text-align:center; vertical-align:middle;" />
    </div>
      
    
    
    <!-- end .content --></div>
  
    
  <div class="sidebar1">
  
  	<div class="userarea">
    	<div class="user">
        	<a href="" class="headimg">
        		<img src="<%=contextPath %>/images/background.jpg" width="60px" height="60px" />
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
    </div><!-- end .userinfo -->
    
    <div style="border-bottom:1px solid #BFBFBF; margin-bottom:10px; padding-bottom:10px;">
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

  
<%@ include file="../include/js.jspf"%>  
</body>
</html>
