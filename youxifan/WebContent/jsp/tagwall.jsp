<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>标签墙   - 天木游戏问答社区</title>
	 
 	<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
 	 
</head>

<body>

<%@ include file="/include/header.jspf"%> 
<div class="container">
	
	
	
	<div style="min-height:600px;" > 
		 
		
		<div id="resultContainer"  > 
		
		
		
		</div>
		
		
	<!-- end .content --></div>


	<div class="footer">
		<%@ include file="../include/footer.jspf"%> 
	<!-- end .footer --></div>
<!-- end .container --></div>


<!-- template -->

<textarea id="tag-Template" rows="0" cols="0" style="display:none;">
	<!-- 
	
 		<div class="tagiterm" style="margin-top:30px;">
        	<div style="border-bottom: 1px solid #BFBFBF; padding-bottom:10px; margin-bottom:10px;">
        		 <a href="<%=contextPath %>/tag/{$T.ftag.tagid}" class="bigtag" >{$T.ftag.tagname}</a> 
        	</div>
        	<div>
        	
        	{#foreach $T.tags as tag} 
        		 <a href="<%=contextPath %>/tag/{$T.tag.tagid}" class="taglink"     style=" white-space:nowrap; margin: 0px 10px 10px 0px;display:inline-block;  ">{$T.tag.tagname}</a>
        	 
        	{#/for}
        	 
        	<div class="clboth"> </div>
        	</div> 
        </div>

	  -->
</textarea>


<%@ include file="/include/js.jspf"%>
</body>



<script type="text/javascript">
 
$(document).ready(function(){
	showPage(); 
})

function showPage(){
	var container = $("#resultContainer");
	var newdiv = $("<div></div>"); 
	var url = "<%=contextPath %>/tag/searchObj/fid/0"; 
	container.html("");
	$.ajax( {
		type : "GET",
		url : url,
		dataType: "json",
		async:false,
		success : function(data) { 
			$.each(data, function(i, item){      
				$.ajax( {
					type : "GET",
					url : "<%=contextPath %>/tag/searchObj/fid/"+item.tagid,
					dataType: "json",
					async:false,
					success : function(sdata) { 
						var mydate ={"ftag":item,"tags":sdata};
						$(newdiv).setTemplateElement("tag-Template",null, {filter_data: false}).processTemplate(mydate);
						container.append($(newdiv).html());
					},
					error :function(){
						alert("请登录重试！");
					}
				}); 


				
			}); 


			
			
			if(data.length == 20){
		    	container.append($("<input id='nextp' type='button' onclick='nextSearchPage(20,20)' value='更多'/>") ); 
		    } 
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
