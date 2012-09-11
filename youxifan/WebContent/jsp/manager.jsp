<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理   - 天木游戏问答社区</title>
	 
 	<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
 	 
</head>

<body>

<%@ include file="/include/header.jspf"%> 
<div class="container">
	
	
	
	<div style="min-height:600px;" >

		<div class="subheader">
			<div id="tabs">
				<a id="suggestion" ${tab== "suggestion"?"class=\"youarehere\"":""} href="javascript:void(0);" onclick="changeTab('suggestion')">意见建议</a> 
			</div>
		</div>
		
		<div id="resultContainer"  > 
		
		
		
		</div>
		
		
	<!-- end .content --></div>


	<div class="footer">
		<%@ include file="../include/footer.jspf"%> 
	<!-- end .footer --></div>
<!-- end .container --></div>


<!-- template -->
<textarea id="suggestion-Template" rows="0" cols="0" style="display:none;">
<!-- 
	
	<table>
	{#foreach $T as sug}
		<tr>
			<td>
				<a href="<%=contextPath%>/user/{$T.sug.userid}/tab/askq">{$T.sug.userid}</a>
			</td>
			<td>
				{$T.sug.contact}
			</td>
			<td>
				{$T.sug.content}
			</td>
		</tr>  
	{#/for}
	</table>
		
		
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
	var container = $("#resultContainer");
	var newdiv = $("<div></div>"); 
	var url = "<%=contextPath%>/"+tab+"/page/0/20"; 
	$.ajax( {
		type : "GET",
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
	var container = $("#resultContainer");
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

 
</script>




<style type="text/css">


</html>
