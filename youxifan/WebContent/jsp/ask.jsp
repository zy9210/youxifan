<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>问题详情</title>  

  	<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
    <script language="javascript" src="<%=contextPath%>/script/jquery-ui-1.8.20.custom.js"></script>
    <script language="javascript" src="<%=contextPath%>/script/jquery.taghandler.js"></script> 

    
    
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/css/all.css"> 
 	<link rel="stylesheet" href="<%=contextPath%>/css/jquery.taghandler.css" type="text/css">  
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/jquery-ui-1.8.7.custom.css" />
	
	<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/kindeditor-min.js"></script>
	<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/lang/zh_CN.js"></script> 
	<link rel="stylesheet" href="<%=contextPath%>/script/kindeditor/themes/default/default.css" />
 
</head>

<body>
<%@ include file="../include/header.jspf"%>
<div class="container">
    
    
    
    
  <div class="content">
  
  
  
  <form action="<%=contextPath %>/doc/add" method="post" onsubmit="return submitTest();"> 
  	  <input type="hidden" name="post_type" value="1"/>
  	  <label>标题</label>  <br/>
	  <input type="text" id="post_title" name="post_title"  style="width:610px;height:25px;" />  <br/>
	  
	  <label>内容</label><br/>
	  <textarea id="post_content" name="post_content" style="width:610px;height:300px;" ></textarea><br/>
	  
	  <label>游戏</label><br/>
	  <ul id="game" style="width:610px;"></ul> 
	  
	  <label>标签</label><br/>
	  <ul id="tags" style="width:610px;"></ul> 
	  
	  <input type="submit" value="提交"  onclick="return check();"/ /><br/>
  </form>
  <!-- end .content --></div>
  
    
   <div class="sidebar">
  
  	<%@ include file="../include/sidebar.jspf"%>
    
  <!-- end .sidebar --></div>
    
  <div class="footer">
    <%@ include file="../include/footer.jspf"%> 
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body> 
<script type="text/javascript">
 
function check(){ 
	var titletext = $.trim($('#post_title').val());
	
	if( titletext.length == 0  ){
		alert("标题不能为空！");
		return false;
	}
	if( titletext.length > 200 ){
		alert("标题过长！");
		return false;
	}
	if($('#gametext').val().trim() == null  ||  $('#gametext').val().trim() == "" ){
		alert("问题所属游戏必须选择,回车建立标签！");
		return false;
	}
	
	return true;
}
jQuery(document).ready(function(){
	//初始化游戏标签
	$('#game').tagHandler({
		autocomplete: true,
		maxTags:1,  
		allowAdd: true,   
		getURL:'<%=contextPath %>/tag/search/fid/0',  
		afterAdd: function(tag){
			var gamestr = $('#gametext').val(); 
			$('#game .tagInput').hide(); 
			//初始化   tag标签
			$('#tags').tagHandler({
				autocomplete: true,
				maxTags:5,  
				allowAdd: true,   
				getURL:'<%=contextPath %>/tag/search/fstr/'+encodeURIComponent(gamestr),  
				onAdd: function(tag){
					var addflag = true,tags = $('#tags').tagHandler("getTags");
			        jQuery.each(tags, function (i, e) {
						if(tag.toUpperCase()===e.toUpperCase()){
							$('#tags').find('.tagItem').each(function(){
								if($(this).html().toLocaleUpperCase()===tag.toLocaleUpperCase()){
									$(this).animate({opacity: 0.55}).delay(20).animate({opacity: 1}).animate({opacity: 0.55}).delay(20).animate({opacity: 1});
								}
							}); 
							addflag = false;
						}
					});
					return addflag;
				},
				submitField:'subtags'
				
			});
		},
		submitField:'gametext',
		afterDelete:function(tag){
			$('#game .tagInput').show();  
		}
	});


	var editor = KindEditor.create('#post_content',
			{resizeType : 1,
			allowPreviewEmoticons : true,
			allowImageUpload : false,
			newlineTag : 'br',
			pasteType : 1,
			items : []
			});  
});

 
</script>

</html>
