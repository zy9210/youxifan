<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bounty Questions - Stack Overflow</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/all.css">
<link rel="shortcut icon" href="http://cdn.sstatic.net/stackoverflow/img/favicon.ico">

</head>

<body class="question-page">
	
	<noscript>
	<div id="noscript-padding"></div>
	</noscript> 
	<div id="notify-container"></div> 
	<div id="overlay-header"></div> 
	<div id="custom-header"></div>
 
	<div class="container">
        <%@ include file="../include/contentHeader.jspf"%>

		<div id="content">   
			<div id="mainbar">    
				<div class="subheader">
					<h1  style="float:left;"> Is a left outer join the same thing as a left join? </h1>
				</div> 
				
				<div id="question">  
					<div class="question-content" id="question-content-{doc.docid}">
						<div class="votecell">   
							<a class="vote-up-off" title="This question shows research effort; it is useful and clear (click again to undo)">up
							vote</a> 
							<span class="vote-count-post">0</span> 
							<a class="vote-down-off" title="This question does not show any research effort; it is unclear or not useful (click again to undo)">down
							vote</a> 
							<a class="star-off" href="#" title="This is a favorite question (click again to undo)">favorite</a>
					
							<div class="favoritecount">
								<span class="vote-count-post">3</span> 
							</div>
						</div>
						
						<div class="question-details"  >        
                            <div class="post-text">
                                <p>The keyword OUTER is optional, but in my opinion it should be
                                mandatory. Until such time as it is (and of course thereafter, too),
                                my advice is always to write it, to remind yourself that it's an outer
                                join.</p> 
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
											<div class=""><img src="${doc.creater.imageurl}" alt="" width="32" height="32"></div>
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
				</div>  <!--question -->
                
				<div id="answers"> 
                    <div id="answers-header"> 
                        <div class="subheader answers-subheader"> 
                            <h2>1 Answer</h2> 
                            <div id="tabs">
                                <a class="youarehere" href="#" title="Answers with the latest activity first">active</a> 
                                <a href="#" title="Answers in the order they were provided">oldest</a> 
                                <a href="#" title="Answers with the highest score first">votes</a>
                            </div> 
                    	</div> 
                    </div> 
                    
					<div id="answer-9890067" class="answer" data-answerid="9890067">
                    	<div class="votecell"> 
							<div class="vote">
                                <input type="hidden" value="9890067"> 
                                <a class="vote-up-off" title="This answer is useful (click again to undo)">up vote</a> 
                                <span class="vote-count-post">0</span> 
                                <a class="vote-down-off" title="This answer is not useful (click again to undo)">down vote</a> 
                            </div> 
                        </div>
                    	<div class="answer-details"  >        
                            <div class="post-text">
                                <p>The keyword OUTER is optional, but in my opinion it should be
                                mandatory. Until such time as it is (and of course thereafter, too),   my advice is always to write it, to remind yourself that it's an outer join.</p> 
                            </div> 
							<div class="started fr">
								<div class="user-info"> 
									<div class="user-gravatar32">
										<a href="/users/565319/richard">
											<div class=""><img src="${doc.creater.imageurl}" alt="" width="32" height="32"></div>
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
								<div class="user-action-time">answered <span title="2012-03-27 13:02:13Z" class="relativetime">17 secs ago</span></div>
							</div>  
						</div>
                    </div>  
                    
                    <div id="answer-9890067" class="answer" data-answerid="9890067">
                    	<div class="votecell"> 
							<div class="vote">
                                <input type="hidden" value="9890067"> 
                                <a class="vote-up-off" title="This answer is useful (click again to undo)">up vote</a> 
                                <span class="vote-count-post">0</span> 
                                <a class="vote-down-off" title="This answer is not useful (click again to undo)">down vote</a> 
                            </div> 
                        </div>
                    	<div class="answer-details"  >        
                            <div class="post-text">
                                <p>The keyword OUTER is optional, but in my opinion it should be
                                mandatory. Until such time as it is (and of course thereafter, too),   my advice is always to write it, to remind yourself that it's an outer join.</p> 
                            </div> 
							<div class="started fr">
								<div class="user-info"> 
									<div class="user-gravatar32">
										<a href="/users/565319/richard">
											<div class=""><img src="${doc.creater.imageurl}" alt="" width="32" height="32"></div>
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
								<div class="user-action-time">answered <span title="2012-03-27 13:02:13Z" class="relativetime">17 secs ago</span></div>
							</div>  
						</div>
                    </div> 
                    
                </div><!--answers -->
                <div id="youranswer">
                	<form id="post-form" action="/questions/9890031/answer/submit" method="post" class="post-form">
                        <input id="fkey" name="fkey" type="hidden" value="48d6caf95afb4bfce2f35ded5fec4df4"> 
                        
                        <h2 class="space">Your Answer</h2>
                        <textarea id="wmd-input" class="wmd-input" name="post-text" cols="92"
        rows="15" tabindex="101"></textarea>
                        <div class="form-submit cbt">
                            <input id="submit-button" type="submit" value="Post Your Answer" tabindex="110"> 
                        </div> 
					</form>
    			</div><!--youranswer -->
			</div>  <!--mainbar -->
            
			<div id="sidebar"> 
				<div class="module"> 
					<p class="label-key">tagged</p> 
					<div class="tagged">
                    	<a href="/questions/tagged/sql" class="post-tag" title="show questions tagged 'sql'" rel="tag">sql</a>&nbsp;
                        <span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">74649</span></span><br>
						<a href="/questions/tagged/database" class="post-tag" title="show questions tagged 'database'" rel="tag">database</a>&nbsp;<span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">32724</span></span><br>
						<a href="/questions/tagged/table" class="post-tag" title="show questions tagged 'table'" rel="tag">table</a>&nbsp;<span class="item-multiplier"><span class="item-multiplier-x">&times;</span>&nbsp;<span class="item-multiplier-count">7627</span></span><br>
					</div>
                </div>
                
                <div class="module">
                	<h4 id="h-related">Related</h4> 
					<div class="related"> 
						<div class="spacer">
                        	<a href="/questions/78468/" class="question-hyperlink">Linq to Entity</a>
                        </div>

                        <div class="spacer">
                            <a href="/questions/896204" class="question-hyperlink">How to implement outer join expression tree?</a>
                        </div>
                    </div>
                </div>
            </div> <!--sidebar -->
        
        </div> <!--content -->
    </div> <!--container -->
    
	<%@ include file="../include/footer.jsp"%>
</body>

</html>