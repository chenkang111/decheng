<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="UTF-8">
	<title>得橙后台登录</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<!-- load css -->
	<link rel="stylesheet" type="text/css" href="../../decheng/static/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="../../decheng/static/css/login.css" media="all">
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
	<h1>
		 <strong>得橙教育管理后台</strong>
		 <em>Management System</em>
	</h1>
	<div class="layui-user-icon larry-login">
		 <input type="text" placeholder="账号" name="adminname" class="login_txtbx adminname"/>
	</div>
	<div class="layui-pwd-icon larry-login">
		 <input type="password" placeholder="密码" name="adminpwd" class="login_txtbx adminpwd"/>
	</div>
    <div class="layui-submit larry-login">
    	<input type="button" value="立即登陆" class="submit_btn"/>
    </div>
</div>
<script type="text/javascript" src="../../decheng/static/layui/layui1.0.9/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="../../decheng/static/js/login.js"></script>
<script type="text/javascript" src="../../decheng/static/jsplug/jparticle.jquery.js"></script>
<script type="text/javascript" src="../../decheng/static/js/common.js"></script>
<script type="text/javascript">
$(function(){
	$(".layui-canvs").jParticle({
		background: "#141414",
		color: "#E6E6E6"
	});
	//登录链接测试，使用时可删除

});
</script>
</body>
</html>