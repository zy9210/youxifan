<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>搜索   - 天木游戏问答社区</title>
	
	<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css">  
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
	
	
	
	<div style="min-height:600px;" >
	
		<div>
			<input type="text" id="searchstr" value="${searchstr}"/>
			<input type="button" id="searchbutton" value="搜索" onclick="search()" />
		</div>
		<div class="subheader">
			<div id="tabs">
				<a id="doctab" ${tab== "doc"?"class=\"youarehere\"":""} href="javascript:void(0);" onclick="changeTab('doc')">问题</a>
				<a id="tagtab" ${tab== "tag"?"class=\"youarehere\"":""} href="javascript:void(0);" onclick="changeTab('tag')"  >标签</a>
				<a id="usertab" ${tab== "user"?"class=\"youarehere\"":""} href="javascript:void(0);" onclick="changeTab('user')"  >用户</a>
			</div>
		</div>
		
		<div id="conContainer"  > 
		
		
		
		</div>
		
		
	<!-- end .content --></div>


	<div class="footer">
		<%@ include file="../include/footer.jspf"%> 
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
			
			<span class="guanzhu {#if $T.doc.isFollowed == 1 }notdisplay{#/if}" id="add3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('add',{$T.doc.docid},${loginuser.userid},3)"  >关注 </a></span>
            <span class="guanzhu {#if $T.doc.isFollowed == 0 }notdisplay{#/if}" id="del3{$T.doc.docid}${loginuser.userid}"  ><a href="javascript:void(0);" onclick="editFollow('del',{$T.doc.docid},${loginuser.userid},3)"  >取消关注 </a></span>
               
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
            <span> </span> 
            
            
           <a href="javascript:void(0);" onclick="editFollow('del',{$T.tag.tagid},${loginuser.userid},4)"  id="del4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.isFollowed == 0 }notdisplay{#/if}" >取消关注</a>
           <a href="javascript:void(0);" onclick="editFollow('add',{$T.tag.tagid},${loginuser.userid},4)"  id="add4{$T.tag.tagid}${loginuser.userid}" class="attentionlink fltrt {#if $T.tag.isFollowed == 1 }notdisplay{#/if}" >关注</a>
    
        	<br style="clear:both;"/> 
        </div>
{#/for}
	  -->
</textarea>


<%-- 本地user显示循环单元模板 --%>
<textarea id="user-Template" rows="0" cols="0" style="display:none;">
	<!-- 
{#foreach $T as user}	
 		<div class="fansiterm" style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
 			<a href="<%=contextPath%>/user/{$T.user.userid}/tab/askq" style=" float:left;">
        		<img src="<%=contextPath%>{$T.user.imageurl}" width="60px" height="60px"  />
            </a>
            <div style="float:left; width:620px;padding:0 10px;">
                <div >
                    <span  style=" font-weight:bold;" >{$T.user.username}</span>             
                    <a href="javascript:void(0);" onclick="editFollow('del',{$T.user.userid},${loginuser.userid},1)"  id="del1{$T.user.userid}${loginuser.userid}" class="attentionlink fltrt {$T.user.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
                    <a href="javascript:void(0);" onclick="editFollow('add',{$T.user.userid},${loginuser.userid},1)"  id="add1{$T.user.userid}${loginuser.userid}" class="attentionlink fltrt {$T.user.isFollowed == 1 ? "notdisplay":""}" >关注</a>
                    <br style="clear:both;"/>
                </div>
                <div class="fusertag" style="color:#B1B1B1;">{$T.user.game}</div>
                <div class="fsigning">{$T.user.signing == null ? "" : $T.user.signing}</div>
        	</div> 
        	<br style="clear:both;"/> 
        </div> 
{#/for}
	  -->
</textarea>

<%@ include file="/include/js.jspf"%>
</body>



<script type="text/javascript">

var tab = "${tab}"; 



$(document).ready(function(){
	showPage(); 
})

function showPage(){
	var container = $("#conContainer");
	var newdiv = $("<div></div>"); 
	var url = "<%=contextPath%>/"+tab+"/search/"+encodeURIComponent(searchStr)+"/page/0/20"; 
	$.ajax( {
		type : "POST",
		url : url,
		dataType: "json",
		success : function(data) { 
			if(data.length == 0){
				container.html($("<div>未找到相关信息 </div>") );
				return; 
		    }
			$(newdiv).setTemplateElement(tab+"-Template",null, {filter_data: false}).processTemplate(data);
			container.html($(newdiv).html());
			if(data.length == 20){
		    	container.append($("<input id='nextp' type='button' onclick='nextSearchPage(20,20)' value='更多'/>") ); 
		    }
			//container.append($(newdiv).html());
		     
		},
		error :function(){
			alert("请登录重试！");
		}
	}); 
}

function nextSearchPage(start,step){
	var container = $("#conContainer");
	var newdiv = $("<div></div>");
	var end =  start+ step;
	var url = "<%=contextPath%>/"+tab+"/search/"+encodeURIComponent(searchStr)+"/page/"+start+"/"+step; 
	
	$.ajax( {
		type : "POST",
		url : url,
		dataType: "json",
		success : function(data) {  
			$("#nextp").remove();
			$(newdiv).setTemplateElement(tab+"-Template",null, {filter_data: false}).processTemplate(data);
			container.append($(newdiv).html());
			var startnext = parseInt(start)+parseInt(step);
			if(data.length == 20){
		    	container.append($("<input id='nextp' type='button' onclick='nextSearchPage("+startnext+",20)' value='更多'/>") ); 
		    }
			//container.append($(newdiv).html()); 
		} ,
		error :function(){
			alert("请登录重试！");
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
  
</html>
