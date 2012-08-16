<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>${user.username}个人页面</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css"> 
<script language="javascript" src="<%=contextPath%>/script/jquery.js"></script>
<script language="javascript" src="<%=contextPath%>/script/jquery-jtemplates.js"></script>

</head>

<body>

<div class="container">


	<%@ include file="../include/header.jspf"%>


  <div class="content">
  
  	 <div class="tuserarea" > 
        <img src="<%=contextPath%>${user.imageurl}" width="100px" height="100px" style="float:left; margin:10px 0;" />
        <div style="float:left; width:550px;padding:0 10px;">
            <div >
            	<span class="tusername" >${user.username}</span>                
                <a href="javascript:void(0);" onclick="editFollow('del',${user.userid},${loginuser.userid},1)"  id="del1${user.userid}${loginuser.userid}" class="attentionlink fltrt ${user.followed == 0 ? "notdisplay":""}" >取消关注</a>
                <a href="javascript:void(0);" onclick="editFollow('add',${user.userid},${loginuser.userid},1)"  id="add1${user.userid}${loginuser.userid}" class="attentionlink fltrt ${user.followed == 1 ? "notdisplay":""}" >关注</a>
                <br style="clear:both;"/>
            </div>
            <div class="tusertag" style="color:#B1B1B1;">${user.game}</div>
            <div class="tsigning">${user.signing} </div>
        </div> 
        <br style="clear:both;"/>
    </div><!-- end .tuserarea -->
    
    <div class="subheader">  
        <div id="tabs">
            <a ${tab== "askq"?"class=\"youarehere\"":""}  href="<%=contextPath%>/user/${user.userid}/tab/askq" title="">所提问题</a> 
            <a ${tab== "answerq"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/answerq" title=" ">回答的问题</a> 
            <a ${tab== "followedq"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/followedq" title=" ">关注的问题</a> 
            <a ${tab== "followedtag"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/followedtag" title=" ">关注的标签</a>
            <a ${tab== "followedUser"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/followedUser" title=" ">关注的人</a>
            <a ${tab== "fans"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/fans" title=" ">粉丝</a>
        </div> 
    </div> 
    
    
    <div id="questions"> 
<c:choose>

	<c:when test="${tab == 'fans' || tab == 'followedUser'}">  
<c:forEach items="${userList}" var="u">	
		<div class="fansiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<img src="<%=contextPath%>${loginuser.imageurl}" width="60px" height="60px"  style=" float:left;"/>
            <div style="float:left; width:590px;padding:0 10px;">
                <div >
                    <span  style=" font-weight:bold;" >${u.username}</span>
   <c:if  test="${loginuser.userid == user.userid && tab != 'fans'}">                 
                    <a href="javascript:void(0);" onclick="editFollow('del',${u.userid},${loginuser.userid},1)"  id="del1${u.userid}${loginuser.userid}" class="attentionlink fltrt ${u.followed == 0 ? "notdisplay":""}" >取消关注</a>
                    <a href="javascript:void(0);" onclick="editFollow('add',${u.userid},${loginuser.userid},1)"  id="add1${u.userid}${loginuser.userid}" class="attentionlink fltrt ${u.followed == 1 ? "notdisplay":""}" >关注</a>
   </c:if>
                    <br style="clear:both;"/>
                </div>
                <div class="fusertag" style="color:#B1B1B1;">${user.game}</div>
                <div class="fsigning">${user.signing}</div>
        	</div> 
        	<br style="clear:both;"/> 
        </div> 
</c:forEach>		
	</c:when> 
	 
	<c:when test="${tab == 'followedtag'}">
<c:forEach items="${tagList}" var="tag">	
 		<div class="tagiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/tag/${tag.tagid}" class="taglink" style="font-size:25px;">${tag.tagname}</a> 
            <span>该话题下有${tag.followers}个问题</span>
	<c:if  test="${loginuser.userid == user.userid }">
           <a href="javascript:void(0);" onclick="editFollow('del',${tag.tagid},${loginuser.userid},4)"  id="del4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.followed == 0 ? "notdisplay":""}" >取消关注</a>
           <a href="javascript:void(0);" onclick="editFollow('add',${tag.tagid},${loginuser.userid},4)"  id="add4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.followed == 1 ? "notdisplay":""}" >关注</a>
   
	</c:if>
        	<br style="clear:both;"/> 
        </div>
</c:forEach>	
	</c:when>  
	 
	<c:otherwise>  
<c:forEach items="${doclist}" var="doc">
        <div class="summary" id="question-summary-${doc.docid}">
            <h3 style="">
            	<a href="<%=contextPath%>/doc/id/${doc.docid}" class="question-hyperlink">${doc.title}</a>
            	
	<c:if  test="${loginuser.userid == user.userid && tab == 'followedq'}">                 
                <a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  id="del3${doc.docid}${loginuser.userid}" class="attentionlink fltrt ${doc.followed == 0 ? "notdisplay":""}" >取消关注</a>
                <a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  id="add3${doc.docid}${loginuser.userid}" class="attentionlink fltrt ${doc.followed == 1 ? "notdisplay":""}" >关注</a>
   
	</c:if>
            </h3>
            <div class="qinfo"  >
                <span class="qcreator" onclick="location='<%=contextPath%>/user/${doc.createrid}/tab/askq'" >${doc.creatername}</span>  
                <span class="qcreatedate">发表于${doc.createdateStr}</span> 
                <!--  
				<span class="guanzhu  ${doc.followed == 1 ? "notdisplay":""}" id="add3${doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  >关注 </a></span>
                <span class="guanzhu ${doc.followed == 0 ? "notdisplay":""}" id="del3${doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
            	-->
            </div>
            <div class="excerpt">
                ${doc.content}
            </div>
            <div class="tags" > 
	<c:forEach items="${doc.tags}" var="tag">
                <a href="<%=contextPath %>/tag/${tag.tagid}" class="taglink" title="${tag.tagname}" >${tag.tagname}</a> 
	</c:forEach>
             </div>
        </div> 
</c:forEach>	
	</c:otherwise>

</c:choose>

  
  

<c:if  test="${fn:length(doclist)== 30}">
    <input id="nextp" type="button" onclick="nextpage('user,'30,20)" value="更多"/>
</c:if>    
 <input id="nextp" type="button" onclick="nextpage('user',0,20)" value="更多"/>
    <!-- end #questions --></div>
    

    
   
      
    
    
    <!-- end .content --></div>
  
    
  <div class="sidebar">
  	<%@ include file="../include/sidebar.jspf"%>
  <!-- end .sidebar --></div>
    
  <div class="footer">
    <p>此 .footer 包含声明 position:relative，以便为 .footer 指定 Internet Explorer 6 hasLayout，并使其以正确方式清除。如果您不需要支持 IE6，则可以将其删除。</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
  
  <!-- template -->
<c:choose>

	<c:when test="${tab == 'fans' || tab == 'followedUser'}">  
	
	
	</c:when>  
	<c:when test="${tab == 'followedtag'}">
	
<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
{#foreach $T as tag}	
 		<div class="tagiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/tag/{$T.tag.tagid}" class="taglink" style="font-size:25px;">{$T.tag.tagname} </a> 
            <span>该话题下有${tag.followers}个问题</span>
	<c:if  test="${loginuser.userid == user.userid }">
           <a href="javascript:void(0);" onclick="editFollow('del',{$T.tag.tagid},${loginuser.userid},4)"  id="del4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.followed == 0 }notdisplay{#/if}" >取消关注</a>
           <a href="javascript:void(0);" onclick="editFollow('add',{$T.tag.tagid},${loginuser.userid},4)"  id="add4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.followed == 1 }notdisplay{#/if}" >关注</a>
   
	</c:if>
        	<br style="clear:both;"/> 
        </div>
{#/for}
	  -->
</textarea>

	
	</c:when>
	<c:otherwise> 
<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
		
		{#foreach $T as doc}
		<div class="summary" id="question-summary-{$T.doc.docid}">
			<h3 style="">
				<a href="<%=contextPath%>/doc/id/{$T.doc.docid}" class="question-hyperlink">{$T.doc.title}</a>
				
	<c:if  test="${loginuser.userid == user.userid && tab == 'followedq'}">                
                <a href="javascript:void(0);" onclick="editFollow('del',{$T.doc.docid},${loginuser.userid},3)"  id="del3{$T.doc.docid}${loginuser.userid}" class="attentionlink fltrt {#if $T.doc.followed == 0 }notdisplay{#/if}" >取消关注</a>
                <a href="javascript:void(0);" onclick="editFollow('add',{$T.doc.docid},${loginuser.userid},3)"  id="add3{$T.doc.docid}${loginuser.userid}" class="attentionlink fltrt {#if $T.doc.followed == 1 }notdisplay{#/if}" >关注</a>
	</c:if>
			</h3>
			<div class="qinfo"  >
				<span class="qcreator" onclick="location='<%=contextPath%>/user/{$T.doc.createrid}/tab/askq'" >{$T.doc.creatername}</span>  
				<span class="qcreatedate">发表于{$T.doc.createdateStr}</span> 
				  
			</div>
			<div class="excerpt">
				{$T.doc.content}
			</div>
			<div class="tags" > 
				{#foreach $T.doc.tags as tag}
				<a href="<%=contextPath %>/tag/{$T.tag.tagid}" class="taglink" title="title" >{$T.tag.tagname}</a> 
				{#/for}
			 </div>
		</div> 
		{#/for}
			
			
	  -->
</textarea>
	</c:otherwise>

</c:choose>
	
	

  
	<%@ include file="../include/js.jspf"%>
</body>
</html>
