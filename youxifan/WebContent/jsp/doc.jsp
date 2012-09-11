<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>问题详情  - 天木游戏问答社区</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css"> 
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>

<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/lang/zh_CN.js"></script> 
<link rel="stylesheet" href="<%=contextPath%>/script/kindeditor/themes/default/default.css" />	

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
 <%@ include file="../include/header.jspf"%>
<div class="container">
 
  <div class="content">
  
    <div class="question" id="question-summary-${doc.docid}"> 
    	<div style="clear:both">
	        <h2 id="titlediv${doc.docid}" class="qtitle fltlft"  >${doc.title}</h2> 
<c:if  test="${doc.createrid == loginuser.userid}">		        
	        	<span class="editt"  id="editTitleb${doc.docid}" onclick="editTitle(${doc.docid})" >编辑</span>
</c:if>	     
			  
	        <textarea class="contentarea" id="title${doc.docid}"  ></textarea>
	        <div id="editTitleArea${doc.docid}" style="display:none;width:610px;">
					<button class="editb" onClick="saveTitle(${doc.docid});" >保存</button>
					<button class="editb"   onClick="cancelTitleEdit(${doc.docid});" >取消</button>
			</div> 
			 
	        <br style="clear:both; display:none;"/> 
        </div>      
        <div class="clboth" style="padding-top:10px;" > 
	<c:forEach items="${doc.tags}" var="tag">
                <a href="<%=contextPath %>/tag/${tag.tagid}" class="taglink"  >${tag.tagname}</a> 
	</c:forEach>
         </div> 
        <div class="excerpt" style="margin:10px 0 10px 0;">
             <div id="contentdiv${doc.docid}">
          	${doc.content} 
          	</div>
            <textarea class="contentarea" id="contentarea${doc.docid}"  ></textarea>
			<div id="editbuttona${doc.docid}" style="display:none;width:610px;">
				<button class="editb" id="save${doc.docid}" >保存</button>
				<button class="editb"  id="cancel${doc.docid}" >取消</button>
			</div>
        </div> 
        <div class="qinfo"  >
            <a   href="<%=contextPath%>/user/${doc.createrid}/tab/askq" target="_blank" >${doc.creatername}</a>  
            <span class="qcreatedate">发表于${doc.createdateStr}</span>
<c:if  test="${doc.createrid == loginuser.userid}">
        	<span class="editt" id="editb${doc.docid}" onclick="editContent(${doc.docid})" >编辑</span> 
</c:if>
			<a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  id="del3${doc.docid}${loginuser.userid}" class="attentionlink   ${doc.isFollowed == 0 ? "notdisplay":""}" >取消关注</a>
	        <a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  id="add3${doc.docid}${loginuser.userid}" class="attentionlink   ${doc.isFollowed == 1 ? "notdisplay":""}" >关注</a>
	        
        </div>
    </div>	 <!-- end #question -->
    
    <div class="answers" id="answers"> 
<c:forEach items="${doc.answers}" var="answer">      
    	<div class="answer">
            <div class="votearea"  >
            	<a id="votea_${answer.docid}" href="javascript:${answer.isVoted == 1 ? 'cancelVote' : 'vote'}(${loginuser.userid},${answer.docid});" class="${answer.isVoted == 1 ? 'voted' : 'vote'}">up vote</a>
                <span class="votecount" id="votecount_${answer.docid}">${answer.votes}</span>
                 
            </div> 
            <div class="aarea" > 
            	<div>
            		<div id="contentdiv${answer.docid}">
	            	${answer.content} 
	            	</div>
	                <textarea class="contentarea" id="contentarea${answer.docid}"  ></textarea>
	 				<div id="editbuttona${answer.docid}" style="display:none;width:610px;">
	 					<button class="editb" id="save${answer.docid}" >保存</button>
	 					<button class="editb"  id="cancel${answer.docid}" >取消</button>
	 				</div>
                </div>  
                <div class="ainfo" style="margin-top:5px; clear:both;" >
                    <a href="<%=contextPath%>/user/${answer.createrid}/tab/askq" target="_blank" >${answer.creatername}</a>  
                    <span class="qcreatedate">发表于${answer.createdateStr}</span>
<c:if  test="${answer.createrid == loginuser.userid}">
                    <span class="editt" id="editb${answer.docid}" onclick="editContent(${answer.docid})" >编辑</span>
</c:if>
                </div>
            </div>
            <div style="clear:both; width:100%; border-bottom: 1px solid #BFBFBF; "></div>
        </div> 
</c:forEach>          
        
<script language="javascript" >


function vote(voterid,bevotedid){
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/vote/"+voterid+"/"+bevotedid+"/", 
		dataType: "json",
		success : function(data) {  
			if(data.success == "true"){
				$('#votea_'+bevotedid).attr("href","javascript:cancelVote("+voterid+","+bevotedid+");"); 
				$('#votea_'+bevotedid).attr("class","voted"); 
				var votes = $('#votecount_'+bevotedid).html();
				 $('#votecount_'+bevotedid).html(parseInt(votes)+1);
			}else{
				alert("发生错误，投票没有成功！"); 
			}

		},
		error :function(){
			alert("网络连接出错！请登陆重试。");
		}
	}); 
}


function cancelVote(voterid,bevotedid){
	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/cancelvote/"+voterid+"/"+bevotedid+"/", 
		dataType: "json",
		success : function(data) {  
			if(data.success == "true"){
				$('#votea_'+bevotedid).attr("href","javascript:vote("+voterid+","+bevotedid+");");  
				$('#votea_'+bevotedid).attr("class","vote"); 
				var votes = $('#votecount_'+bevotedid).html();
				 $('#votecount_'+bevotedid).html(parseInt(votes)-1);
			}else{
				alert("发生错误，投票没有成功！"); 
			}

		},
		error :function(){
			alert("网络连接出错！请登陆重试。");
		}
	}); 
}


function  editTitle(docid){
	$('#titlediv'+docid).hide();//标题div隐藏
	$('#title'+docid).val($('#titlediv'+docid).html());
	$('#title'+docid).show(); //显示input输入框
	$('#editTitleb'+docid).hide();//隐藏编辑按钮
	$('#editTitleArea'+docid).show(); //标题修改保存按钮
}

function cancelTitleEdit(docid){
	$('#titlediv'+docid).show();//标题div隐藏
	$('#title'+docid).hide(); //显示input输入框
	$('#editTitleb'+docid).show();//隐藏编辑按钮
	$('#editTitleArea'+docid).hide(); //标题修改保存按钮
}


function saveTitle(docid){

	var titletext= $('#title'+docid).val(); 
	if(titletext.length > 200){
		alert("标题内容过长!");
		return false;
	}

	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/doc/update/"+docid+"/title/",
		data:"post-text="+encodeURIComponent(titletext),
		dataType: "json",
		success : function(data) {  
			if(data.success == "true"){
				$('#titlediv'+docid).html($('#title'+docid).val());
				$('#titlediv'+docid).show();//标题div显示
				$('#title'+docid).hide(); //隐藏input输入框
				$('#editTitleb'+docid).show();//显示编辑按钮
				$('#editTitleArea'+docid).hide(); //标题修改保存按钮
			}else{
				alert(data.msg); 
			}

		},
		error :function(){
			alert("网络连接出错！稍后重试。");
		}
	}); 
	
}

function editContent(docid){
	var editor;
	$('#editbuttona'+docid).show();//保存取消按钮显示
	$('#editb'+docid).hide(); //编辑按钮隐藏
	$('#contentdiv'+docid).hide(); //div块隐藏
	$('#contentarea'+docid).show();
	$('#contentarea'+docid).val($('#contentdiv'+docid).html());
	editor = KindEditor.create('#contentarea'+docid,
						{resizeType : 1,
						allowPreviewEmoticons : true,
						allowImageUpload : false,
						newlineTag : 'br',
						pasteType : 1,
						items : []
						}); 
	$('#cancel'+docid).click(function() {
		if (editor) {
			editor.remove();
			editor = null;
			$('#contentarea'+docid).hide();
			$('#editbuttona'+docid).hide();
			$('#editb'+docid).show();
			$('#contentdiv'+docid).show(); //div显示
		}
	});
	$('#save'+docid).click(function() {
		if (editor) {
			editor.sync();
			$.ajax( {
				type : "POST",
				url : "<%=contextPath%>/doc/update/"+docid+"/content/",
				data:"post-text="+encodeURIComponent($('#contentarea'+docid).val()),
				dataType: "json",
				success : function(data) {  
					 if(data.success == "true"){
						$('#editbuttona'+docid).hide();
						$('#editb'+docid).show();
						editor.remove();
						$('#contentarea'+docid).hide();
						$('#contentdiv'+docid).html($('#contentarea'+docid).val()); //div显示
						$('#contentdiv'+docid).show(); //div显示
						editor = null;
					 }else{
						alert(data.msg); 
					 }
					 
				},
				error :function(){
					alert("网络连接出错！稍后重试。");
				}
			}); 
		}
	});
}


$().ready(function(){ 
	var editor = KindEditor.create('#answertext',
			{resizeType : 1,
			allowPreviewEmoticons : true,
			allowImageUpload : false,
			newlineTag : 'br',
			pasteType : 1,
			items : []
			}); 
	
	$('#submitbutton').click(function() {
		editor.sync();
		$.ajax( {
			type : "POST",
			url : "<%=contextPath%>/doc/answer/${doc.docid}",
			data:"post-text="+encodeURIComponent(editor.html()),
			dataType: "json",
			success : function(data) {  
				if(data.success == "true"){ 
					var docid = data.docid;
					var newanswer = $('<div class="answer">'+
									       '     <div class="votearea"  >'+
									        '    	<a id="votea_'+docid+'" href="javascript:vote(${loginuser.userid},'+docid+');" class="vote">up vote</a> '+
									       '         <span class="votecount" id="votecount_'+docid+'">0</span>'+
									       '     </div> '+
									       '     <div class="aarea" > '+
									       '     	<div>'+
									       '     		<div id="contentdiv'+docid+'">'+$('#answertext').val()+
										   '         	</div>'+
										   '             <textarea class="contentarea" id="contentarea'+docid+'"  ></textarea>'+
										 	'			<div id="editbuttona'+docid+'" style="display:none;width:610px;">'+
										 	'				<button class="editb" id="save'+docid+'" >保存</button>'+
										 	'				<button class="editb"  id="cancel'+docid+'" >取消</button>'+
										 	'			</div>'+
									        '        </div>  '+
									        '        <div class="ainfo" style="margin-top:5px; clear:both;" >' +
									        '            <a href="${contextPath}/user/${loginuser.userid}/tab/askq" target="_blank"  >${loginuser.username}</a>  '+
									        '            <span class="qcreatedate">发表于'+data.nowStr+'</span>'+
									        '            <span class="editt" id="editb'+docid+'" onclick="editContent('+docid+')" >编辑</span>'+
									        '        </div>'+
									        '    </div>'+
									        '    <div style="clear:both; width:100%; border-bottom: 1px solid #BFBFBF; "></div>'+
									       ' </div> ');  
					$("#answers").append(newanswer);
					$('#answertext').val("");    
					editor.html('');
				}else{
					alert(data.msg); 
				}

			},
			error :function(){
				alert("网络连接出错！稍后重试。");
			}
		});//$.ajax( {
	});//$('#answertext').click(function()
});//$().ready(f
	
	 
</script> 
       
    <!-- end #answers --></div>
    
    <div class="" style="padding:0 20px 20px 20px;">
    	<h1>添加答案</h1>
        <textarea id="answertext"  class="postarea" placeholder="添加你的答案" ></textarea>
        <input class="fltrt" id="submitbutton"  type="button"   value="提交答案" style="margin:10px 20px; text-align:center; vertical-align:middle;" />
    </div>
      
    
    
    <!-- end .content --></div>
  
    
  <div class="sidebar">
  
  	<%@ include file="../include/sidebar.jspf"%>
    
  <!-- end .sidebar --></div>
    
  <div class="footer">
    <%@ include file="../include/footer.jspf"%> 
    <!-- end .footer --></div>
  <!-- end .container --></div>

  
<%@ include file="../include/js.jspf"%>  
</body>

</script>
</html>
