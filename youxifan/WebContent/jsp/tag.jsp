<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>${tag.tagname} - 天木游戏问答社区</title> 
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>


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
<%@ include file="/include/header.jspf"%>
<div class="container">

	
    
  <div class="content">
  	
  	 <div style="margin:10px 0 20px 5px; font-weight:bold;">
    	<span class="bigtag"  >${tag.tagname}</span>
        <span style="font-size:18px;">标签下的问题</span>
        <a href="javascript:void(0);" onclick="editFollow('del',${tag.tagid},${loginuser.userid},4)"  id="del4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
        <a href="javascript:void(0);" onclick="editFollow('add',${tag.tagid},${loginuser.userid},4)"  id="add4${tag.tagid}${loginuser.userid}" class="attentionlink fltrt ${tag.isFollowed == 1 ? "notdisplay":""}" >关注</a>
                 
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
            	<a href="<%=contextPath%>/user/${doc.createrid}/tab/askq" target="_blank" >${doc.creatername}</a>  
                <span class="qcreatedate">发表于${doc.createdateStr}</span>
                
                <span class="guanzhu ${doc.isFollowed == 1 ? "notdisplay":""}" id="add3${doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  >关注 </a></span>
                <span class="guanzhu ${doc.isFollowed == 0 ? "notdisplay":""}" id="del3${doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
				
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
    <input id="nextp" type="button" class="more"  onclick="nextpage('tagdoc',30,20)" value="更多"/>
</c:if>     
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
	<textarea id="Template-Items" rows="0" cols="0" style="display:none;">
	<!-- 
		
		{#foreach $T as doc}
		<div class="summary" id="question-summary-{$T.doc.docid}">
			<h3 style="">
				<a href="<%=contextPath%>/doc/id/{$T.doc.docid}" class="question-hyperlink">{$T.doc.title}</a>
			 
			</h3>
			<div class="qinfo"  >
				<a href="<%=contextPath%>/user/{$T.doc.createrid}/tab/askq" target="_blank" >{$T.doc.creatername}</a>
				<span class="qcreatedate">发表于{$T.doc.createdateStr}</span> 
				
				<span class="guanzhu  {#if $T.doc.isFollowed == 1 }notdisplay{#/if}" id="add3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',{$T.doc.docid},${loginuser.userid},3)"  >关注 </a></span>
                <span class="guanzhu  {#if $T.doc.isFollowed == 0 }notdisplay{#/if}" id="del3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',{$T.doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
                
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
