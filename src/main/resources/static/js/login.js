
'use strict';
layui.use(['jquery','layer'],function(){
	layer = parent.layer === undefined ? layui.layer : parent.layer,
	window.jQuery = window.$ = layui.jquery;
   $(".layui-canvs").width($(window).width());
   $(".layui-canvs").height($(window).height());
   $(".submit_btn").click(function() {
		var administerName = $(".adminname").val();
		var password = $(".adminpwd").val();
		if($.trim(administerName) != "" && $.trim(password) != "") {
			$.ajax({
				type: "POST", //提交方式 
				url: baseurl+"/admin/login",
				dataType: 'json',
				data: {
					administerName: administerName,
					password: password
				}, //数据，这里使用的是Json格式进行传输 
				success: function(data) { //返回数据根据结果进行相应的处理 
					if(data.meta.code == 203 || data.meta.code==202) {
						layer.msg('账号密码不正确', {
							icon: 5
						});
					} else if(data.meta.code==204){
						layer.msg('无此管理员', {icon: 5});
					}else {
						console.log(data);
						localStorage.clear();
						localStorage.setItem("administerId", data.data.administer.adminId);
						localStorage.setItem("administerName", data.data.administer.adminName);
						localStorage.setItem("nickName", data.data.administer.adminNickname);
						localStorage.setItem("administerType",data.data.administer.adminType);
						localStorage.setItem("headimg",data.data.administer.adminHeadurl);
						localStorage.setItem("token",data.data.token);
						window.location.href = baseurl+"/back/index.html";
						} 
					}
				})
			}else{
				layer.msg('账号/密码不能为空');
			}
		})
});
