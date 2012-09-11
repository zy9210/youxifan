<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>${user.username} - 天木游戏问答社区</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css">  
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
<script language="javascript" src="<%=contextPath%>/script/jquery-jtemplates.js"></script>


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

<body>
<%@ include file="../include/header.jspf"%>
<div class="container"> 

  <div class="content">
  
  	 <div class="tuserarea" > 
        <img src="<%=contextPath%>${user.imageurl}" width="100px" height="100px" style="float:left; margin:10px 0;" />
        <div class="tuserinfo"  >
            <div >
            	<span class="tusername" >${user.username}</span>                
                <a href="javascript:void(0);" onclick="editFollow('del',${user.userid},${loginuser.userid},1)"  id="del1${user.userid}${loginuser.userid}" class="attentionlink fltrt ${user.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
                <a href="javascript:void(0);" onclick="editFollow('add',${user.userid},${loginuser.userid},1)"  id="add1${user.userid}${loginuser.userid}" class="attentionlink fltrt ${user.isFollowed == 1 ? "notdisplay":""}" >关注</a>
                <br style="clear:both;"/>
            </div>
            <div class="tusertag" >${user.game}</div>
            <div class="tsigning">${user.signing} </div>
        </div> 
        <br style="clear:both;"/>
    </div><!-- end .tuserarea -->
    
    <div class="subheader">  
        <div id="tabs">
            <a ${tab== "askq"?"class=\"youarehere\"":""}  href="<%=contextPath%>/user/${user.userid}/tab/askq"  >所提问题</a> 
            <a ${tab== "answerq"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/answerq"  >回答的问题</a> 
            <a ${tab== "followedq"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/followedq" >关注的问题</a> 
            <a ${tab== "followedtag"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/followedtag"  >关注的标签</a>
            <a ${tab== "followedUser"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/followedUser"  >关注的人</a>
            <a ${tab== "fans"?"class=\"youarehere\"":""} href="<%=contextPath%>/user/${user.userid}/tab/fans"  >粉丝</a>
        </div> 
    </div> 
    
    
    <div id="questions"> 
<c:choose>
<%-- 显示我关注的人   或    我的粉丝  --%>
	<c:when test="${tab == 'fans' || tab == 'followedUser'}">  
<c:forEach items="${userList}" var="u">	
		<div class="fansiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/user/${u.userid}/tab/askq" style=" float:left;">
        		<img src="<%=contextPath%>${u.imageurl}" width="60px" height="60px"   />
            </a> 
            <div style="float:left; width:620px;padding:0 10px;">
                <div >
                    <span  style=" font-weight:bold;" >${u.username}</span>
                                 
                    <a href="javascript:void(0);" onclick="editFollow('del',${u.userid},${loginuser.userid},1)"  id="del1${u.userid}${loginuser.userid}" class="attentionlink fltrt ${u.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
                    <a href="javascript:void(0);" onclick="editFollow('add',${u.userid},${loginuser.userid},1)"  id="add1${u.userid}${loginuser.userid}" class="attentionlink fltrt ${u.isFollowed == 1 ? "notdisplay":""}" >关注</a>
 
                    <br style="clear:both;"/>
                </div>
                <div class="fusertag" style="color:#B1B1B1;">${u.game}</div>
                <div class="fsigning">${u.signing}</div>
        	</div> 
        	<br style="clear:both;"/> 
        </div> 
</c:forEach>
<c:if  test="${fn:length(fans)== 30}">

    <input id="nextp" type="button" class="more"  onclick="nextpage('user',30,20)" value="更多"/>
</c:if> 
		
	</c:when> 
	 
	<c:when test="${tab == 'followedtag'}">
<%-- tag显示循环单元 --%>
<c:forEach items="${tagList}" var="tag">	
 		<div class="tagiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/tag/${tag.tagid}" class="taglink" style="font-size:25px;">${tag.tagname}</a> 
            <%--<span>该话题下有${tag.followers}个问题</span> --%>
            
           <a href="javascript:void(0);" onclick="editFollow('del',${tag.tagid},${loginuser.userid},4)"  id="del4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
           <a href="javascript:void(0);" onclick="editFollow('add',${tag.tagid},${loginuser.userid},4)"  id="add4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.isFollowed == 1 ? "notdisplay":""}" >关注</a>
    
        	<br style="clear:both;"/> 
        </div>
</c:forEach>	
<c:if  test="${fn:length(tagList)== 30}">

    <input id="nextp" type="button" class="more"  onclick="nextpage('user',30,20)" value="更多"/>
</c:if> 


	</c:when>  
	 
	<c:otherwise>  
<%-- doc显示循环单元 --%>
<c:forEach items="${doclist}" var="doc">
        <div class="summary" id="question-summary-${doc.docid}">
            <h3 style="">
            	<a href="<%=contextPath%>/doc/id/${doc.docid}" target="_blank" class="question-hyperlink">${doc.title}</a>
            	  
            </h3>
            <div class="qinfo"  >
                <a href="<%=contextPath%>/user/${doc.createrid}/tab/askq" target="_blank" >${doc.creatername}</a>  
                <span class="qcreatedate">发表于${doc.createdateStr}</span> 
      
                <a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  id="del3${doc.docid}${loginuser.userid}" class="attentionlink   ${doc.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
                <a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  id="add3${doc.docid}${loginuser.userid}" class="attentionlink   ${doc.isFollowed == 1 ? "notdisplay":""}" >关注</a>

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
<c:if  test="${fn:length(doclist)== 30}">

    <input id="nextp" type="button" class="more"  onclick="nextpage('user',30,20)" value="更多"/>
</c:if> 
	
	</c:otherwise>

</c:choose>

  
  

     
    <!-- end #questions --></div>
    

    
   
      
    
    
    <!-- end .content --></div>
  
    
  <div class="sidebar">
  	<%@ include file="../include/sidebar.jspf"%>
  <!-- end .sidebar --></div>
    
  <div class="footer">
    <%@ include file="../include/footer.jspf"%> 
    <!-- end .footer --></div>
  <!-- end .container --></div>
  
  <!-- template -->
<c:choose>

	<c:when test="${tab == 'fans' || tab == 'followedUser'}">  

<%-- 本地user显示循环单元模板 --%>
<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
{#foreach $T as user}	
 		<div class="fansiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/user/{$T.user.userid}/tab/askq" style=" float:left;">
        		<img src="<%=contextPath%>{$T.user.imageurl}" width="60px" height="60px"  />
            </a>
            <div style="float:left; width:590px;padding:0 10px;">
                <div >
                    <span  style=" font-weight:bold;" >{$T.user.username}</span> 
                            
                    <a href="javascript:void(0);" onclick="editFollow('del',{$T.user.userid},${loginuser.userid},1)"  id="del1{$T.user.userid}${loginuser.userid}" class="attentionlink fltrt {$T.user.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
                    <a href="javascript:void(0);" onclick="editFollow('add',{$T.user.userid},${loginuser.userid},1)"  id="add1{$T.user.userid}${loginuser.userid}" class="attentionlink fltrt {$T.user.isFollowed == 1 ? "notdisplay":""}" >关注</a>
 
                    <br style="clear:both;"/>
                </div>
                <div class="fusertag" style="color:#B1B1B1;">{$T.user.game}</div>
                <div class="fsigning">{$T.user.signing == null ? "" : $T.user.signing }</div>
        	</div> 
        	<br style="clear:both;"/> 
        </div> 
{#/for}
	  -->
</textarea>

	
	</c:when>  
	<c:when test="${tab == 'followedtag'}">
<%-- 本地tag显示循环单元模板 --%>	
<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
{#foreach $T as tag}	
 		<div class="tagiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/tag/{$T.tag.tagid}" class="taglink" style="font-size:25px;">{$T.tag.tagname} </a> 
            
 
           <a href="javascript:void(0);" onclick="editFollow('del',{$T.tag.tagid},${loginuser.userid},4)"  id="del4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.isFollowed == 0 }notdisplay{#/if}" >取消关注</a>
           <a href="javascript:void(0);" onclick="editFollow('add',{$T.tag.tagid},${loginuser.userid},4)"  id="add4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.isFollowed == 1 }notdisplay{#/if}" >关注</a>
 
        	<br style="clear:both;"/> 
        </div>
{#/for}
	  -->
</textarea>

	
	</c:when>
	<c:otherwise> 
<%-- 本地doc显示循环单元模板 --%>
<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
		
		{#foreach $T as doc}
		<div class="summary" id="question-summary-{$T.doc.docid}">
			<h3 style="">
				<a href="<%=contextPath%>/doc/id/{$T.doc.docid}" target="_blank" class="question-hyperlink">{$T.doc.title}</a>
 
			</h3>
			<div class="qinfo"  >
				<a href="<%=contextPath%>/user/{$T.doc.createrid}/tab/askq"   target="_blank" >{$T.doc.creatername}</a>  
				<span class="qcreatedate">发表于{$T.doc.createdateStr}</span> 
				
				<a href="javascript:void(0);" onclick="editFollow('del',{$T.doc.docid},${loginuser.userid},3)"  id="del3{$T.doc.docid}${loginuser.userid}" class="attentionlink fltrt {#if $T.doc.isFollowed == 0 }notdisplay{#/if}" >取消关注</a>
                <a href="javascript:void(0);" onclick="editFollow('add',{$T.doc.docid},${loginuser.userid},3)"  id="add3{$T.doc.docid}${loginuser.userid}" class="attentionlink fltrt {#if $T.doc.isFollowed == 1 }notdisplay{#/if}" >关注</a>
                
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
