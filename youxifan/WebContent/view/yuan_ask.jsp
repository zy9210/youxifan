<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.apache.commons.lang3.StringUtils"%>
<html> 
<head> 
    <title>ask - youxifan</title> 
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.sstatic.net/js/stub.js?v=c014461b9109"></script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/css/all.css">

</head>
<body class="questions-page">
    <noscript><div id="noscript-padding"></div></noscript>
    <div id="notify-container"></div>
    <div id="overlay-header"></div>
    <div id="custom-header"></div>

    <div class="container">
        <%@ include file="../include/contentHeader.jspf"%>

		<div id="content">
			
	        <div id="mainbar" class="ask-mainbar">  
	    		<form id="post-form" class="post-form" action="/questions/ask/submit" method="post">
	        		<div class="form-item ask-title"> 
		            	<table class="ask-title-table"> 
		            		<tr>
			                    <td class="ask-title-cell-key">
			                        <label for="title">Title</label>
			                    </td> 
		                    	<td class="ask-title-cell-value"> 
		                        	<input id="title" name="title" type="text" maxlength="300" tabindex="100" class="ask-title-field" value="">                        
		                        	<span class="edit-field-overlay">what&#39;s your programming question? be specific.</span>
		                    	</td>
		                	</tr>
		            	</table> 
	           	 		<div id="question-suggestions"> 
	            		</div> 
	        		</div> 
	        		
	        		<div id="post-editor" class="post-editor">  
	        			<div class="wmd-container"> 
		        			<div id="wmd-button-bar" class="wmd-button-bar"></div>
		        				<textarea id="wmd-input" class="wmd-input" name="post-text" cols="92" rows="15" tabindex="101">
								</textarea>
		        			</div> 
		        			<div class="fl" style="margin-top: 8px; height:24px;">&nbsp;</div>
		        			<div id="draft-saved" class="draft-saved community-option fl" style="margin-top: 8px; height:24px; display:none;">draft saved</div>
			        		<div id="wmd-preview" class="wmd-preview"></div>
			        		<div> </div> 
		        			<div class="edit-block">
		        			<input id="fkey" name="fkey" type="hidden" value="f91f7f3c6de40552d290061b6d57699c">
		        			<input id="author" name="author" type="text"> 
	        			</div> 
	        		</div>
	        		
	        		<div class="form-item">
	        			<label>Tags</label>  
	        			<input id="tagnames" name="tagnames" type="text" size="60" value="" tabindex="103">
	        			<span class="edit-field-overlay">at least one tag such as (c++ sql-server c), max 5 tags</span>
	        		</div>
	        		
	        		<div class="form-submit cbt"><input id="submit-button" type="submit" value="提交" tabindex="120"></div>
	        	</form>
	        </div> 
	        

	        
			<div id="sidebar" class="ask-sidebar">
				<div class="module" id="questions-count">
					<div class="summarycount al">305</div>
					<p>questions</p>
				</div>   
				<div class="everyonelovesstackoverflow" id="adzerk2">
				</div> 

				<div class="module" id="related-tags">
					<h4 id="h-related-tags">Related Tags</h4>
					<a href="/questions/tagged/android" class="post-tag" title="show questions tagged 'android'" rel="tag"><img src="http://cdn.sstatic.net/img/hosted/tKsDb.png" height="16" width="18" alt="" class="sponsor-tag-img">android</a><span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">42</span></span>            <br>
				
					<a href="/questions/tagged/c%23" class="post-tag" title="show questions tagged 'c#'" rel="tag">c#</a><span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">27</span></span>            <br>
				
					<a href="/questions/tagged/javascript" class="post-tag" title="show questions tagged 'javascript'" rel="tag">javascript</a><span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">25</span></span>            <br>
				
					<a href="/questions/tagged/java" class="post-tag" title="show questions tagged 'java'" rel="tag">java</a><span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">24</span></span>            <br> 
				</div>
			</div>

		</div>
    </div>
    <div id="footer">
        <div class="footerwrap">
            <div id="footer-menu">
                <a href="/about">about</a> |
                <a href="/faq">faq</a> | <a href="http://blog.stackexchange.com?blt=1">blog</a> |
                    <a href="http://chat.stackoverflow.com">chat</a> |
                <a href="http://data.stackexchange.com">data</a> |
                <a href="http://blog.stackoverflow.com/category/podcasts/">podcast</a> |
                <a href="http://shop.stackexchange.com/">shop</a> |
                <a href="http://stackexchange.com/legal">legal</a>
                <div id="footer-sites">
                    
                        <span style="color:#FE7A15;font-size:140%">&#9632;</span>&nbsp;<a href="http://stackoverflow.com">stackoverflow.com</a>&nbsp; 
                        <span style="color:#FE7A15;font-size:140%">&#9632;</span>&nbsp;<a href="http://stackapps.com">api/apps</a>&nbsp; 
                        <span style="color:#FE7A15;font-size:140%">&#9632;</span>&nbsp;<a href="http://careers.stackoverflow.com">careers</a>&nbsp; 
                        <span style="color:#E8272C;font-size:140%">&#9632;</span>&nbsp;<a href="http://serverfault.com">serverfault.com</a>&nbsp; 
                        <span style="color:#00AFEF;font-size:140%">&#9632;</span>&nbsp;<a href="http://superuser.com">superuser.com</a>&nbsp; 
                        <span style="color:#969696;font-size:140%">&#9632;</span>&nbsp;<a href="http://meta.stackoverflow.com">meta</a>&nbsp; 
                        <span style="color:#46937D;font-size:140%">&#9632;</span>&nbsp;<a href="http://area51.stackexchange.com">area&nbsp;51</a>&nbsp; 
                        <span style="color:#C0D0DC;font-size:140%">&#9632;</span>&nbsp;<a href="http://webapps.stackexchange.com">webapps</a>&nbsp; 
                        <span style="color:#000000;font-size:140%">&#9632;</span>
                </div>
            </div>
            <div id="footer-flair">
                <a class="peer1" href="http://www.peer1.com/stackoverflow"></a>  
                <a href="http://creativecommons.org/licenses/by-sa/3.0/" class="cc-wiki-link"></a>
                <div id="svnrev">rev 2012.3.7.1488</div>
            </div>
            <div id="copyright">
                site design / logo &copy; 2012 stack exchange inc; 
                user contributions licensed under <a href="http://creativecommons.org/licenses/by-sa/3.0/" rel="license">cc-wiki</a> with <a href="http://blog.stackoverflow.com/2009/06/attribution-required/" rel="license">attribution required</a>
            </div>
        </div>
    </div>
</body>
</html>