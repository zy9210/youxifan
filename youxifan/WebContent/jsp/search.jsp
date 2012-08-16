<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>搜索</title>
	
	<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css">  
<%
String q = request.getParameter("q"); 
%>
</head>

<body>

<div class="container">
	
	<%@ include file="/include/header.jspf"%> 
	
	<div style="min-height:600px;" >
	
		<div>
			<input type="text" id="searchstr" value="<%=q %>"/>
			<input type="button" id="searchbutton" value="搜索" onclick="search()" />
		</div>
		<div class="subheader">
			<div id="tabs">
				<a id="doctab" class="youarehere" href="javascript:void(0);" onclick="changeTab('doc')">问题</a>
				<a id="tagtab"  href="javascript:void(0);" onclick="changeTab('tag')"  >标签</a>
				<a id="usertab"  href="javascript:void(0);" onclick="changeTab('user')"  >用户</a>
				
			</div>
		</div>
		
		<div id="sresultContainer"  > 
		
		
		
		</div>
		
		
	<!-- end .content --></div>


	<div class="footer">
		<p>此 .footer 包含声明 position:relative，以便为 .footer 指定 Internet Explorer
		6 hasLayout，并使其以正确方式清除。如果您不需要支持 IE6，则可以将其删除。</p>
	<!-- end .footer --></div>
<!-- end .container --></div>


<!-- template -->
<textarea id="doc-Template" rows="0" cols="0" style="display:none;">
<!-- 
	
	{#foreach $T as doc}
	<div class="summary" id="question-summary-{$T.doc.docid}">
		<h3 style=""><a href="<%=contextPath%>/doc/id/{$T.doc.docid}" class="question-hyperlink">{$T.doc.title}</a></h3>
		<div class="qinfo"  >
			<span class="qcreator" onclick="location='<%=contextPath%>/user/{$T.doc.createrid}/tab/askq'" >{$T.doc.creatername == null ? "" : $T.doc.creatername}</span>  
			<span class="qcreatedate">发表于{$T.doc.createdateStr}</span>
			
			<span class="guanzhu {#if $T.doc.followed == 1 }notdisplay{#/if}" id="add3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',{$T.doc.docid},${loginuser.userid},3)"  >关注 </a></span>
            <span class="guanzhu {#if $T.doc.followed == 0 }notdisplay{#/if}" id="del3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',{$T.doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
               
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
<textarea id="tag-Template" rows="0" cols="0" style="display:none;">
	<!-- 
{#foreach $T as tag}	
 		<div class="tagiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        	<a href="<%=contextPath%>/tag/{$T.tag.tagid}" class="taglink" style="font-size:25px;">{$T.tag.tagname} </a> 
            <span>该话题下有{$T.tag.followers}个问题</span>
	<c:if  test="${loginuser.userid == user.userid }">
           <a href="javascript:void(0);" onclick="editFollow('del',{$T.tag.tagid},${loginuser.userid},4)"  id="del4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.followed == 0 }notdisplay{#/if}" >取消关注</a>
           <a href="javascript:void(0);" onclick="editFollow('add',{$T.tag.tagid},${loginuser.userid},4)"  id="add4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.followed == 1 }notdisplay{#/if}" >关注</a>
   
	</c:if>
        	<br style="clear:both;"/> 
        </div>
{#/for}
	  -->
</textarea>


<%@ include file="/include/js.jspf"%>
</body>



<script type="text/javascript">

var tab = "doc";
var searchStr = "<%=q %>";



$(document).ready(function(){
	showPage(); 
})

function showPage(){
	var container = $("#sresultContainer");
	var newdiv = $("<div></div>"); 
	var url = "<%=contextPath%>/"+tab+"/search/"+searchStr+"/page/0/20"; 
	$.ajax( {
		type : "POST",
		url : url,
		dataType: "json",
		success : function(data) {  
			$(newdiv).setTemplateElement(tab+"-Template").processTemplate(data);
			container.html($(newdiv).html());
			//container.append($(newdiv).html());
		     
		} 
	}); 
}
function changeTab(tabs){
	$(".youarehere").removeClass("youarehere");
	tab = tabs;
	$("#"+tabs+"tab").addClass("youarehere");
	showPage();
}

function search(){
	searchStr = $("#searchstr").val();
	showPage();
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
