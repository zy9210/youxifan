<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.apache.commons.lang3.StringUtils"%>
<html> 
<head> 
    <title>Bounty Questions - Stack Overflow</title> 
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script type="text/javascript" src="http://cdn.sstatic.net/js/stub.js?v=c014461b9109"></script>
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/css/all.css">
<%
	String sort = (String)request.getAttribute("sort");
	if(StringUtils.isEmpty(sort)){	
		sort = "newest";
	}
 
%>
</head>
<body class="questions-page">
    <noscript><div id="noscript-padding"></div></noscript>
    <div id="notify-container"></div>
    <div id="overlay-header"></div>
    <div id="custom-header"></div>

    <div class="container">
        <%@ include file="../include/contentHeader.jspf"%>

        <div id="content">
            
            <div id="mainbar">    
				<div class="subheader">
					<div id="tabs">
<a <%="newest".equals(sort)?"class=\"youarehere\"":"" %>  href="/questions?sort=newest" title="the most recently asked questions">最新</a>
<a <%="featured".equals(sort)?"class=\"youarehere\"":"" %> href="/questions?sort=featured" title="questions with open bounties">投票</a>
<a <%="unanswered".equals(sort)?"class=\"youarehere\"":"" %> href="/questions?sort=faq" title="questions with the most links">回答</a>
<a <%="votes".equals(sort)?"class=\"youarehere\"":"" %> href="/questions?sort=votes" title="questions with the most votes">收藏</a>
<a <%="active".equals(sort)?"class=\"youarehere\"":"" %> href="/questions?sort=active" title="questions that have recent activity">active</a>
<a <%="question".equals(sort)?"class=\"youarehere\"":"" %> href="<%=contextPath%>/view/ask.jsp" title="提问">提问</a>
					</div>  
					<h1 id="h-all-questions">问题</h1> 
					
				</div>   
				
				<div id="questions">
<c:forEach items="${doclist}" var="doc">

					<div class="question-summary" id="question-summary-${doc.docid}">
						<div class="statscontainer">
							<div class="statsarrow"></div>
							<div class="stats">
								<div class="vote">
									<div class="votes">
										<span class="vote-count-post"><strong>6</strong></span>
										<div class="viewcount">votes</div>
									</div>
								</div>
								<div class="status answered">
									<strong>3</strong>answers
								</div>
								<div class="views" title="188 views">188 views</div>
							</div>							
						</div>
						<div class="summary">        
							<h3><a href="<%=contextPath%>/s/doc/id/${doc.docid}" class="question-hyperlink">${doc.title}</a></h3>
							<div class="excerpt">
								${doc.content}	 
							</div>
							<div class="tags t-android t-webview t-textview">
								<a href="/questions/tagged/android" class="post-tag" title="show questions tagged 'android'" rel="tag">
									<img src="http://cdn.sstatic.net/img/hosted/tKsDb.png" height="16" width="18" alt="" class="sponsor-tag-img">android</a> 
								<a href="/questions/tagged/webview" class="post-tag" title="show questions tagged 'webview'" rel="tag">webview</a> 
								<a href="/questions/tagged/textview" class="post-tag" title="show questions tagged 'textview'" rel="tag">textview</a> 

							</div>
							<div class="started fr">
								<div class="user-info"> 
									<div class="user-gravatar32">
										<a href="/users/565319/richard">
											<div class=""><img src="${pageScope.contextPath}/${doc.creater.imageurl}" alt="" width="32" height="32"></div>
										</a>
									</div>
									<div class="user-details">
										<a href="/users/${doc.creater.userid}">${doc.creater.username}</a><br>
											<span class="reputation-score" title="reputation score" dir="ltr">296</span>
											<span title="1 silver badge">
												<span class="badge2"></span>
												<span class="badgecount">1</span>
											</span>
											<span title="13 bronze badges">
												<span class="badge3"></span>
												<span class="badgecount">13</span>
											</span>
										</div>
									</div>
									<div class="user-action-time">asked <span title="" class="relativetime">${doc.createdate}</span></div>
							</div>  
						</div>
					</div>
</c:forEach>
				</div>
				<br class="cbt">
				<div class="page-sizer fr">
					<a href="/questions?sort=featured&amp;pagesize=15" title="show 15 items per page" class="current page-numbers">15</a>
					<a href="/questions?sort=featured&amp;pagesize=30" title="show 30 items per page" class="page-numbers">30</a>
					<a href="/questions?sort=featured&amp;pagesize=50" title="show 50 items per page" class="page-numbers">50</a>
					<span class="page-numbers desc">per page</span>
				</div>
				<div class="pager fl" >
					<span class="page-numbers current">1</span>
					<a href="/questions?page=2&amp;sort=featured" title="go to page 2"><span class="page-numbers">2</span></a>
					<a href="/questions?page=3&amp;sort=featured" title="go to page 3"><span class="page-numbers">3</span></a>
					<a href="/questions?page=4&amp;sort=featured" title="go to page 4"><span class="page-numbers">4</span></a>
					<a href="/questions?page=5&amp;sort=featured" title="go to page 5"><span class="page-numbers">5</span></a>
					<span class="page-numbers dots">&hellip;</span>
					<a href="/questions?page=21&amp;sort=featured" title="go to page 21"><span class="page-numbers">21</span></a>
					<a href="/questions?page=2&amp;sort=featured" title="go to page 2" rel="next"><span class="page-numbers next"> next</span></a>
				</div>

			</div>
			
			
			<div id="sidebar">
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
    <%@ include file="../include/footer.jsp"%>
</body>
</html>