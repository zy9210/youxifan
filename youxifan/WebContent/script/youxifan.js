 function addFollow(upper,follower,type){
	  	$.ajax( {
	  		type : "POST",
	  		url : "<%=contextPath%>/follow/"+type+"/" + upper + "/" + follower,
	  		dataType: "json",
	  		success : function(data) { 
	  			if(data.state == "success"){ 
	  				alert("添加关注成功！");
	  				$("#msg").html("添加关注成功！");  
	  			}else{
	  				alert("已经添加关注！");
	  				$("#msg").html("");
	  			} 
	  		},
	  		error :function(){
	  			alert("网络连接出错！");
	  		}
	  	});
	  }