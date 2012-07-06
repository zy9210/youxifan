var exReplys={//显示信息的留言层
	notice_id : null,
	json : null,
	html : null,
	init : function(notice_id){
		exReplys.notice_id=notice_id;
		$("#replys_load_"+exReplys.notice_id).show();
		exReplys.ajax();
	},
	
	toggle : function(notice_id){//点击显示产品详情
		$("#items_"+notice_id).toggle();
		if($("#items_"+notice_id).css("display")=="block"){//展开操作
			exReplys.init(notice_id);
		}else{
			$("#replys_load_"+exReplys.notice_id).hide();
		}
	},
	
	ajax : function(){
		$.ajax({type:"POST",
				url:"/noticeExhibit",
				data:"act=getReplys&notice_id="+exReplys.notice_id,
				dataType:"json",
				success:function (data) {
					exReplys.json=data;
					exReplys.show();
				}
		});
	},
	show : function(){
		//alert("show");
		exReplys.getHtml();
		$("#replys_load_"+exReplys.notice_id).hide();
		$("#items_"+exReplys.notice_id).html(exReplys.html);
		$("#items_"+exReplys.notice_id).show();
	},
	getHtml : function(){
		exReplys.html=""+
		'<div class="edit_rep sidebother padding_top_5 margin_bot">'+
		' <div id="rep_alr_'+exReplys.notice_id+'" class="line_height2 text_right marright">'+
		' '+exReplys.getReplyHead()+
		' </div>'+
		' <ul id="reply_ul_'+exReplys.notice_id+'">'+
		' '+exReplys.getReplysBody()+
		' </ul>'+
		' <div class="edit_dis clear_flow">'+
		' <span class="edir_input"><input id="reply_txt_'+exReplys.notice_id+'" name="'+exReplys.notice_id+'" type="text" /></span>'+
		' <span class="edit_bot">'+
		" <input type='image' id='on' src='/images/homepage/bottom_comment.jpg' onclick=\"ope_rep.saveRaply('reply_txt_'+"+exReplys.notice_id+")(this.disabled=true)\" />"+
		' </span>'+
		' </div>'+
		'</div>';
	},
	getReplyHead : function(){//留言头
		var replyHead="";
		if(exReplys.json.value.length==0)
			replyHead+='赶紧抢先留言吧!';
		else
			replyHead+='<font id="rep_ct_'+exReplys.notice_id+'">'+exReplys.json.value.length+'</font>条留言，<a class="blue_link" ef="/notice/'+exReplys.notice_id+'.html">点击查看</a>';
		return replyHead;
	},
	getReplysBody : function(){//留言体
		var replys="";
		if(exReplys.json.value.length>0){
			for(var i in exReplys.json.value){
				replys+=''+
				'<li>'+
				' <div class="flow_left marginall_5_10">'+
				' <img class="img-side img_size_30" src="'+exReplys.json.value[i].headImgUrl+'" />'+
				' </div>'+
				' <div class="flow_left martop_5 line_height2">'+
				' <p class="edit_cont"><a class="blue_link" href="/profile/'+exReplys.json.value[i].user_id+'-1.html">'+exReplys.json.value[i].nickName+'</a>&nbsp;:&nbsp;'+exReplys.json.value[i].content+'<font class="font_grey">&nbsp;('+exReplys.json.value[i].replyTime+')</font></p>'+
				' </div>'+
				' <div class="clear_flow botline marleri"></div>'+
				'</li>';
			}			
		}
		return replys;
	}
} 















var ope_rep={//notice展示部分 处理留言的js操作
	saveRaply : function(txt_id){
		if(rootour.user_id==null)
		{//先判断时候登陆
			enterrep();
			return;//如果未登录,退出
		}
		var reply_txt=$("#"+txt_id).val();
		if(reply_txt.length==0){
			message.alert("请输入留言内容!");
			$("#"+txt_id).get(0).focus();
			return;
		}
		var notice_id=$("#"+txt_id).attr("name");
		ope_rep.doReply(reply_txt,notice_id,txt_id);
	},//Ajax添加留言
	saveRaplyS : function(){//notice.jsp 添加
		if(login.init())//先判断时候登陆
		return;
		var reply_txt=$("#replay_txt").val();
		var notice_id=$("#notice_id").val();
		ope_rep.doReply(reply_txt,notice_id,null);
	},//Ajax添加留言
	showReply : function(reply_txt,notice_id,txt_id){
		//留言层上数据更改
		var innerStr='<li>'+ope_rep.getIsExImg()+
			'<div class="flow_left martop2 line_height2">'+
			'<p class="edit_cont"><span><a class="blue_link" href="/profile/'+rootour.user_id+'-1.html">'+rootour.user_name+'</a></span>&nbsp;:<a href="#">'+reply_txt+'</a></p>'+
			'</div>'+
			'<div class="clear_flow botline marleri"/></li>';
		$("#reply_ul_"+notice_id).prepend(innerStr);
		var rep_ct_str=$("#rep_ct_"+notice_id).text();
		var rep_ct=1;
		if(rep_ct_str!="")
			rep_ct=parseInt(rep_ct_str)+1;//获得评论的数量
		var innerHTML='<font id="rep_ct_'+notice_id+'">'+rep_ct+'</font>条留言，<a class="blue_link" href="/notice.jsp?notice_id='+notice_id+'">点击查看</a>';
		$("#rep_alr_"+notice_id).html(innerHTML);
		//留言(0)更改
		$("#rep_ct_btm_"+notice_id).html(rep_ct);
		$("#"+txt_id).val("");
	},//Ajax添加留言展示
	showReplyS : function(reply_txt,notice_id,txt_id){
		//留言层上数据更改
		var innerStr='<li>'+
			'<div class="xuline-x2 heightauto_100">'+ope_rep.getIsExImgS()+
			' <div class="martop2 edit_con02">'+
			' <div class="line_height2">'+
			' <span class="flow_left s14">'+
			' <a href="/profile/'+rootour.user_id+'-1.html" class="s14blue_link">'+rootour.user_name+'</a>'+
			' <a class="s14grey_link">: </a>'+reply_txt+
			' </span>'+
			' </div>'+
			' <div class="line_height clear_flow f_grey"> '+
			' <span class="flow_left marright_20">1分钟内</span>'+
			' </div>'+
			' <div class="clear_flow"></div>'+
			' </div>'+
			'</div></li>';
		$("#reply_ul").prepend(innerStr);
		var rep_ct_str=$("#rep_ct").text();
		var rep_ct=1;
		if(rep_ct_str!="")
			rep_ct=parseInt(rep_ct_str)+1;//获得评论的数量
		$("#rep_ct").text(rep_ct);
		$("#replay_txt").val("");
	},//Ajax添加留言展示
	getIsExImg : function(){
		return '<div class="flow_left marginall_5_10"><img class="img-side img_size_30" src="'+rootour.user_img+'" /></div>';
	},
	getIsExImgS : function(){
		return '<div class="flow_left marginall_20 dis_inline"><img class="img-side img_size" src="'+rootour.user_img+'" /></div>';
	},
	doReply : function(reply_txt,notice_id,txt_id){
		message.info("正在提交请稍候.......");
		var rdata="reply_txt="+reply_txt+"&act=reply"+"&notice_id="+notice_id;
		$.ajax({type:"POST",
				url:"/notice",
				data:rdata,
				dataType:"text",
				success:function (data) {
					if(data=="true"){
						message.close();
						message.alert("您的留言已经发布 !");
						if(txt_id!=null)//列表中留言
							ope_rep.showReply(reply_txt,notice_id,txt_id);
						else{//消息页面留言
							ope_rep.showReplyS(reply_txt,notice_id);
						}
					}
				}
		});
	}
} 





//查看价格登录弹出对话框
function enter(){
$("#enter").attr("style", "position: absolute; visibility: visible; z-index: 1000; left: 369px; top: 163px; display: block;");
$("#enter").show();
$("#filter").show();
$("#filter1").show();
} 







<div class="alert_login"
	style="position: absolute; visibility: visible; z-index: 1000; left: 369px; top: 163px; display: none;"
	id="enter">
	<table width="560" height="190" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="5" colspan="3" class="top_bg2"></td>
		</tr>
		<tr>
			<td width="5" class="centerbg"></td>
			<td height="152" valign="top">
				<div class="hui_bj2 whitebg height_200">
					<div class="login_prompt" style="display: none;"
						id="wrong_ico">
						<div>
							<span class="wrong_ico">登陆或密码错误</span>
							<a href="#" class="close"></a>
						</div>
					</div>
					<div class="login">
						<h2>已有旅途网账号，可直接登录</h2>
						<div class="login_name margin_top_15">
							<input name="email" id="email"
								type="text" value="" />
						</div>
						<div class="login_name margin_top_15">
							<input name="password" id="password"
								type="password" class=pss value="" />
						</div>
						<div
							class="clear_flow line_height25 margin_top_15">
							<span
								class="margin_align display_block flow_left">
								<input name="state" id="state"
									type="checkbox" value="" />
								<input type="hidden" value="0"
									id="notice_id" />
							</span>
							<span class="display_block flow_left">
								记住我的登录状态
							</span>
							<span class="flow_right">
								<input type="image"
									onclick="enter2();" src="/images/homepage/login.jpg" />
							</span>
						</div>
					</div>
					<div class="regist">
						<h2>还没开通？赶快免费注册一个吧！</h2>
						<a class="resgist_bot"
							href="/register.html">
							<img
								src="/images/homepage/regist_booton.jpg" width="159"
								height="38" alt="注册旅途网" />
						</a>
						<p class="font_hei14">
							注册旅途网，可随时，随地发布旅途消息，并群发给你的客户，好友！
						</p>
					</div>
					<div class="shut_02">
						<img src="/images/homepage/shut_02.jpg"
							onclick="enter1();" width="11" height="10" />
					</div>
				</div>
			</td>
			<td width="5" class="centerbg"></td>
		</tr>
		<tr>
			<td height="5" colspan="3" class="bottom_bg2"></td>
		</tr>
	</table>
</div>