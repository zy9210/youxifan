<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<title>问题详情</title> 
<link type="text/css" rel="stylesheet" href="<%=contextPath %>/css/all.css"> 
<script language="javascript" src="<%=contextPath%>/script/jquery.min.js"></script>

<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/kindeditor-min.js"></script>
<script charset="utf-8" src="<%=contextPath%>/script/kindeditor/lang/zh_CN.js"></script> 
<link rel="stylesheet" href="<%=contextPath%>/script/kindeditor/themes/default/default.css" />	
		
</head>

<body>

<div class="container">

  <%@ include file="../include/header.jspf"%>
    
    
    
    
  <div class="content">
  
    <div class="question" id="question-summary-${doc.docid}"> 
        <h1 id="titlediv${doc.docid}" class="fltlft" style="width:570px; color:#ec9902; "  >${doc.title}</h1>
        <textarea class="contentarea" id="title${doc.docid}"  ></textarea>
        <div id="editTitleArea${doc.docid}" style="display:none;width:610px;">
				<button class="editb" onClick="saveTitle(${doc.docid});" >保存</button>
				<button class="editb"   onClick="canselTitleEdit(${doc.docid});" >取消</button>
		</div>
        <span id="editTitleb${doc.docid}" onclick="editTitle(${doc.docid})" >编辑</span>
        
        <a href="javascript:void(0);" onclick="editFollow('del',${doc.docid},${loginuser.userid},3)"  id="del3${doc.docid}${loginuser.userid}" class="attentionlink fltrt ${doc.followed == 0 ? "notdisplay":""}" >取消关注</a>
        <a href="javascript:void(0);" onclick="editFollow('add',${doc.docid},${loginuser.userid},3)"  id="add3${doc.docid}${loginuser.userid}" class="attentionlink fltrt ${doc.followed == 1 ? "notdisplay":""}" >关注</a>
                
        <div class="clboth" style="border-top:10px;" > 
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
				<button class="editb"  id="cansel${doc.docid}" >取消</button>
			</div>
        </div> 
        <div class="qinfo"  >
            <span class="qcreator" onclick="location='<%=contextPath%>/user/${doc.createrid}/tab/askq'"  >${doc.creatername}</span>  
            <span class="qcreatedate">发表于${doc.createdateStr}</span>
        	<span id="editb${doc.docid}" onclick="editContent(${doc.docid})" >编辑</span>
        </div>
    </div>	 <!-- end #question -->
    
    <div class="answers"> 
<c:forEach items="${doc.answers}" var="answer">      
    	<div class="answer">
            <div class="votearea"  >
            	<a href="" class="upvote">up vote</a>
                <span class="votecount" id="votecount_id">214</span>
                <a href="" class="downvote">down vote</a>
            </div> 
            <div class="aarea" > 
            	<div>
            		<div id="contentdiv${answer.docid}">
	            	${answer.content} 
	            	</div>
	                <textarea class="contentarea" id="contentarea${answer.docid}"  ></textarea>
	 				<div id="editbuttona${answer.docid}" style="display:none;width:610px;">
	 					<button class="editb" id="save${answer.docid}" >保存</button>
	 					<button class="editb"  id="cansel${answer.docid}" >取消</button>
	 				</div>
                </div>  
                <div class="ainfo" style="margin-top:5px; clear:both;" >
                    <span class="qcreator">${answer.creater.username}</span>  
                    <span class="qcreatedate">发表于${answer.createdateStr}</span>
                    <span id="editb${answer.docid}" onclick="editContent(${answer.docid})" >编辑</span>
                </div>
            </div>
            <hr style="clear:both; "/>
        </div> 
</c:forEach>          
        
<script language="javascript" >

function  editTitle(docid){
	$('#titlediv'+docid).hide();//标题div隐藏
	$('#title'+docid).val($('#titlediv'+docid).html());
	$('#title'+docid).show(); //显示input输入框
	$('#editTitleb'+docid).hide();//隐藏编辑按钮
	$('#editTitleArea'+docid).show(); //标题修改保存按钮
}

function canselTitleEdit(docid){
	$('#titlediv'+docid).show();//标题div隐藏
	$('#title'+docid).hide(); //显示input输入框
	$('#editTitleb'+docid).show();//隐藏编辑按钮
	$('#editTitleArea'+docid).hide(); //标题修改保存按钮
}

function saveTitle(docid){


	$.ajax( {
		type : "POST",
		url : "<%=contextPath%>/doc/update/"+docid+"/title/",
		data:"post-text="+$('#title'+docid).val(),
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
						items : []
						}); 
	$('#cansel'+docid).click(function() {
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
				data:"post-text="+$('#contentarea'+docid).val(),
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

</script> 
       
    <!-- end #answers --></div>
    
    <div class="" style="padding:0 20px 20px 20px;">
    	<h1>添加答案</h1>
        <textarea  class="postarea" placeholder="添加你的答案" ></textarea>
        <input class="fltrt"  type="button" value="提交答案" style="padding:2px; text-align:center; vertical-align:middle;" />
    </div>
      
    
    
    <!-- end .content --></div>
  
    
  <div class="sidebar">
  
  	<%@ include file="../include/sidebar.jspf"%>
    
  <!-- end .sidebar --></div>
    
  <div class="footer">
    <p>此 .footer 包含声明 position:relative，以便为 .footer 指定 Internet Explorer 6 hasLayout，并使其以正确方式清除。如果您不需要支持 IE6，则可以将其删除。</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>

  
<%@ include file="../include/js.jspf"%>  
</body>

</script>
</html>
