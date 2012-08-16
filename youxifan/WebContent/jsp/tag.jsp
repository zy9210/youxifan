<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>标签内容</title> 


</head>

<body>

<div class="container">

	<%@ include file="/include/header.jspf"%>
    
  <div class="content">
  	
  	 <div style="margin:10px 0 20px 5px; color:#EB9A03; font-weight:bold;">
    	<span class="radius" style="font-size:24px; margin-right:10px; background-color:#FFEDD9; padding:2px;">${tag.tagname}</span>
        <span style="font-size:18px;">标签下的问题</span>
        <a href="javascript:void(0);" onclick="editFollow('del',${tag.tagid},${loginuser.userid},4)"  id="del4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.followed == 0 ? "notdisplay":""}" >取消关注</a>
        <a href="javascript:void(0);" onclick="editFollow('add',${tag.tagid},${loginuser.userid},4)"  id="add4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.followed == 1 ? "notdisplay":""}" >关注</a>
                 
    </div>
    
    
    <div class="subheader">  
        <div id="tabs">
            <a ${tab== "newest"?"class=\"youarehere\"":""}  href="<%=contextPath%>/tag/${tag.tagid}/tab/newest" title="">最新</a> 
            <a ${tab== "hot"?"class=\"youarehere\"":""} href="<%=contextPath%>/tag/${tag.tagid}/tab/hot" title=" ">最热</a> 
            <a ${tab== "noanswer"?"class=\"youarehere\"":""} href="<%=contextPath%>/tag/${tag.tagid}/tab/noanswer" title=" ">等待回复</a> 
        </div> 
    </div> 
    
    
    <div id="questions"> 
<c:forEach items="${doclist}" var="doc">
        <div class="summary" id="question-summary-${doc.docid}">
            <h3 style=""><a href="<%=contextPath%>/doc/id/${doc.docid}" class="question-hyperlink">${doc.title}</a></h3>
            <div class="qinfo"  >
                <span class="qcreator" onclick="location='<%=contextPath%>/user/${doc.createrid}/tab/askq'" >${doc.creatername}</span>  
                <span class="qcreatedate">发表于${doc.createdateStr}</span>
                
                <span class="guanzhu ${doc.followed == 1 ? "notdisplay":""}" id="add3${doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  >关注 </a></span>
                <span class="guanzhu ${doc.followed == 0 ? "notdisplay":""}" id="del3${doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
				
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
    <input id="nextp" type="button" onclick="nextpage('tagdoc',30,20)" value="更多"/>
</c:if>    
 <input id="nextp" type="button" onclick="nextpage('tagdoc',0,20)" value="更多"/>
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
	<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
		
		{#foreach $T as doc}
		<div class="summary" id="question-summary-{$T.doc.docid}">
			<h3 style="">
				<a href="<%=contextPath%>/doc/id/{$T.doc.docid}" class="question-hyperlink">{$T.doc.title}</a>
			 
			</h3>
			<div class="qinfo"  >
				<span class="qcreator" onclick="location='<%=contextPath%>/user/{$T.doc.createrid}/tab/askq'" >{$T.doc.creatername}</span>  
				<span class="qcreatedate">发表于{$T.doc.createdateStr}</span> 
				
				<span class="guanzhu  {#if $T.doc.followed == 1 }notdisplay{#/if}" id="add3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',{$T.doc.docid},${loginuser.userid},3)"  >关注 </a></span>
                <span class="guanzhu  {#if $T.doc.followed == 0 }notdisplay{#/if}" id="del3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',{$T.doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
                
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


<%@ include file="../include/js.jspf"%>
</body>
</html>
