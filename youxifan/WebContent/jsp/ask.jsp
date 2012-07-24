<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>问题详情</title>  

  	<script type="text/javascript" src="<%=contextPath%>/script/jquery.min.js"></script>
    <script language="javascript" src="<%=contextPath%>/script/jquery-ui-1.8.20.custom.js"></script>
    <script language="javascript" src="<%=contextPath%>/script/jquery.taghandler.js"></script>
    
    
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/css/all.css"> 
 	<link rel="stylesheet" href="<%=contextPath%>/css/jquery.taghandler.css" type="text/css">  
	<link rel="stylesheet" type="text/css" href="<%=contextPath%>/css/jquery-ui-1.8.7.custom.css" /> 
</head>

<body>

<div class="container">

  <div class="header">
  	<a href="#" style="float:left; margin-left:10px;">
    	<img src="<%=contextPath %>/images/logo.jpg" alt="游戏烦" name="Insert_logo" width="116" height="56" id="Insert_logo" style=" padding-top:5px; " />
    </a> 
    <div style="float:left; padding-top:18px; margin-left:10px;">
    	<input id="searchinput" type="text" style=" " />
        <span id="stext" >提交新问题</span>
    </div> 
    <div  id="headnav">   
        <a href="#" style="float:left; margin-left:10px; color:#FFF;">
            首页
        </a> 
        <a href="#" style="float:left; margin-left:50px; color:#FFF;">
            话题广场
        </a> 
    </div>
  <!-- end .header --></div>
    
    
    
    
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
	  
	  <input type="submit" value="提交"  /><br/>
  </form>
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
</body>

<script type="text/javascript">
jQuery(document).ready(function(){
	$('#game').tagHandler({
		autocomplete: true,
		maxTags:1,  
		allowAdd: false,   
		getURL:'<%=contextPath %>/tag/search/fid/0',  
		afterAdd: function(tag){
			var gamestr = $('#gametext').val(); 
			$('#tags').tagHandler({
				autocomplete: true,
				maxTags:5,  
				allowAdd: true,   
				getURL:'<%=contextPath %>/tag/search/fstr/'+gamestr,  
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
		submitField:'gametext'
		
	});
});

</script>

</html>
