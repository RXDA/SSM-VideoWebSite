<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新用户注册</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="/bysj/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/bysj/css/pingendo.min.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body>
	<nav class="navbar navbar-full navbar-light bg-faded"> <a
		class="navbar-brand" href="#">Skyrim</a>
	<ul class="nav navbar-nav pull-right">
		<li class="nav-item active"><a class="nav-link"
			href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
		<li class="nav-item"><a class="active nav-link" href="#">注册</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/login.jsp">登录</a>
	</ul>
	</nav>
	<div class="section">
		<div class="container">
			<div class="row" draggable="true">
				<div class="col-lg-7 col-md-offset-2">
					<form class="cmxform" id="signupForm"
						action="${pageContext.request.contextPath}/regist" method="post">
						<div class="form-group">
							<label>账号</label> 
							<input type="text" class="form-control" id="username" placeholder="账户名，用于登录认证" name="uname"	 onblur="checkUnameIsExist()" onfocus="clearCss()"> 
							<small class="text-muted" id="showResult"></small>
						</div>
						<div class="form-group">
							<label>用户名</label> <input type="text" id="nickname"
								class="form-control" placeholder="输入昵称" name="nickname" onblur="checkNickIsExist()" onfocus="clearNickCss()">
								<small class="text-muted" id="showNickResult"></small>
						</div>
						<div class="form-group">
							<label>密码</label> <input type="password" id="password"
								class="form-control" placeholder="输入密码" name="password">
						</div>
						<div class="form-group">
							<label>重复密码</label> <input type="password" class="form-control"
								placeholder="再次输入密码" name="confirm_password">
						</div>
						<fieldset class="form-group">
							<label>性别</label>
							<div class="radio">
								<!-- 隐藏input用来获取sex的值 ，配合js使用-->
								<input type="hidden" id="hidSex" /> <label> <input
									type="radio" value="男" name="sex" >男
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" value="女" name="sex">女
								</label>
							</div>
						</fieldset>
						<button type="button" class="btn btn-primaryubmit"
							onclick="this.form.submit()">提交</button>
					</form>
				</div>
				<div class="col-lg-1 col-md-offset-2"></div>
			</div>
		</div>
	</div>
	<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/prototype/1.7.3.0/prototype.js"></script>
	<script
		src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
	<script type="text/javascript"
		src="/bysj/js/bootstrap.js"></script>
	<!--   引入jquery-validation -->

	<script
		src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
	<script
		src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
		<script src="/bysj/js/regist.js"></script>
		<script src="/bysj/js/checkNickName.js"></script>

</body>

</html>