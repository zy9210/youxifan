<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>

<script type="text/javascript" src="js/swfobject.js"></script>
<script type="text/javascript" src="js/jquery.1.3.2.js"></script>
<script type="text/javascript" src="js/jquery.uploadify.v2.1.4.js"></script>
<script src="js/jquery.Jcrop.js"></script>

<link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css" />
<link rel="stylesheet" href="css/uploadify.css" type="text/css" />
<link rel="stylesheet" href="/css/homeprofile.css" type="text/css" />

<script language="Javascript">
var imgname=null;//上传后返回的路径
$().ready(  function() {
    $("#upload").uploadify({
        'uploader'       : 'images/uploadify.swf',
       // 'script'         : 'servlet/Upload',
       	'script' :'<%=(String)request.getContextPath()%>/fileupload',
       
        'queueSizeLimit' : 1,
        'cancelImg'      : 'images/cancel.jpg',
        'folder'         : 'uploads',
        'queueID'        : 'fileQueue',
        'auto'           : true,
        'multi'          : true,
        //'buttonText'     : ' gfdsgfdsg',
        'buttonImg'      : 'images/ual.jpg',
        'simUploadLimit' : 1,//队列中同时存在的文件个数限制
        'fileDesc' : 'word文档,图片', 
       	'fileExt'   : '*.jpg;',
       	'sizeLimit ' : 19871202,
       	'onComplete' :function(event, ID, fileObj, response, data) {
       		imgname= response;
       		insert_img("<%=(String)request.getContextPath()%>/uploads/"+response);//生成时插入图片 
       		//url_img="/tmp/"+response;
		   // insert_img("http://image.rootour.com/tmp/"+response);//生成时插入图片    
       	} //完成后回调方法
    });
    $("#saveimg").click(function (){
    	if(imgname==null){
    		alert("请您先上传头像!");
    	}
    	else if(x==null)
    	{
    		alert("请您在右侧大图中框选头像!");
    	}
    	else{
    		saveimg();
    	}
    });
});
</script>
<script language="Javascript">
jQuery(window).load(function(){
	//on_load();

});

//生成时插入图片 
function insert_img(imgsrc){
	var cxtsmall='<img src="'+imgsrc+'" id="preview" style="border:0px;margin:auto;padding:0px;"/>';
	var cxtbig='<img src="'+imgsrc+'" id="cropbox" style="border:0px;margin:auto;padding:0px;"/>';
	$("#imgsmall_div").html(cxtsmall);
	$("#imgbig_div").html(cxtbig);
	
	judgement();//判断浏览器类型,做不同图片加载处理
}

//判断浏览器类型
function judgement(){
	var Sys = {}; 
	var ua = navigator.userAgent.toLowerCase(); 
	var s; 
	(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] : 
	(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] : 
	(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] : 
	(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] : 
	(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0; 
	
	//以下进行测试 
	if (Sys.ie) {//alert('IE: ' + Sys.ie); 
		EnhancedImg_ie();
	}
	else {
		EnhancedImg_firebox();
	}
}
var interval_ie = null;
function EnhancedImg_ie(){
	if($("#cropbox").attr("readyState")=="complete"){
		opeimgwidth();//控制图片呈现的宽高
    	clearTimeout(interval_ie);
	}
	else
		interval_ie = setTimeout("EnhancedImg_ie()",1000);
}//ie判断图片加载是否完成
var interval_firebox = null;
function EnhancedImg_firebox(){
    if($("#cropbox").attr("width")> 0 && $("#cropbox").attr("height") > 0){
    	opeimgwidth();//控制图片呈现的宽高
        clearTimeout(interval_firebox);
    }
    else
		interval_firebox = setTimeout("EnhancedImg_firebox()",1000);
}//ie判断图片加载是否完成

//主图片的宽高比例
function opeimgwidth(){
	var width= $("#cropbox").attr("width");
	var height= $("#cropbox").attr("height");
	if(width>height){//竖版的
		$("#cropbox").attr("width","300");
    	$("#cropbox").attr("height",$("#cropbox").attr("height"));
	}else{//横版的
		$("#cropbox").attr("height","300");
    	$("#cropbox").attr("width",$("#cropbox").attr("width"));
	}
    
    on_load();//加载 图片裁剪 模式
}

function on_load(){
	jQuery('#cropbox').Jcrop({
		onChange: showPreview,
		onSelect: showPreview,
		aspectRatio: 1,
		setSelect: [5,5,100,100]
	});
}
var x=null; 
var y=null; 
var w=null;
var h=null;

function showPreview(coords)
{
	x=coords.x;   
	y=coords.y;
	w=coords.w;
	h=coords.h;
	if (parseInt(coords.w) > 0)
	{
		var rx = 50 / coords.w;
		var ry = 50 / coords.h;
		jQuery('#preview').css({
			width: Math.round(rx * $("#cropbox").attr("width")) + 'px',
			height: Math.round(ry * $("#cropbox").attr("height")) + 'px',
			marginLeft: '-' + Math.round(rx * coords.x) + 'px',
			marginTop: '-' + Math.round(ry * coords.y) + 'px'
		});
	}
  
}

function saveimg( ){ 
	$.ajax({type:"POST", 
	        url:"<%=request.getContextPath()%>/user.do", 
	        data:"method=saveHeadImg"+"&x="+x+"&y="+y+"&w="+w+"&h="+h+"&filename="+imgname, 
	        dataType:"text",
	        success:function (data) {
	        	if(data=="true"){
	        		alert("保存成功!");
	        		imgname=null;
	        		document.location.href="/homepage.jsp";
	        	}else
	        		alert("保存失败!");
	        }
		});
}
</script>

</head>

<body>

 

<div style="margin:auto;width:750px"> 
	<script>$("#uploadify").addClass("blue_hover");</script>
	<div >
		<ul class="big_img blue_border"  id="imgbig_div" style="float:left;margin:auto;">
			
		</ul>
		<ul   style="width:350px;float:left;" >
			<h2 class="sblue">上传头像</h2> 
			<div id="fileQueue">
				<span class="display_block flow_left margin_bot">点击浏览从电脑选择一张照片</span>
				<input type="file" name="upload" id="upload" />
			</div> 
			<p>提示：支持JPG的图片，最大1M.</p>
			<h2 class="sblue">显示头像</h2> 
			<div class="small_img blue_border" id="imgsmall_div">
				
			</div>
			<p>
				显示头像50*50像素			
			</p>
			<div>
				<input id="saveimg" type="image" src="images/upload.jpg" />
			</div>
		</ul>
	</div>
</div>
 


</body>

</html>
