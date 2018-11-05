<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>欢迎访问Skyrim</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/bysj/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/bysj/css/pingendo.min.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body>
	<nav class="navbar navbar-full navbar-light bg-faded" draggable="true">
	<a class="navbar-brand" href="#">Skyrim</a>
	<ul class="nav navbar-nav pull-right">
		<li class="nav-item active"><a class="nav-link"
			href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/regist.jsp">注册</a></li>
		<li class="nav-item"><a class="active nav-link" href="#">登录</a></li>
	</ul>
	</nav>
	<div class="section">
		<div class="container">
			<div class="row" draggable="true">
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
					<form class="" draggable="true"
						action="${pageContext.request.contextPath}/login" id="loginform">
						<div class="form-group">
							<label>用户名</label> <input type="text" class="form-control"
								placeholder="输入用户名" name="uname" id="username">
						</div>
						<div class="form-group">
							<label>Password</label> <input type="password"
								class="form-control" placeholder="输入密码" name="password"
								id="password">
						</div>
						<button type="button" class="btn btn-primary" onclick="checkLogin()">登录</button>
					</form>
				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>
	</div>
	<div class="bg-info col-lg-12 p-a-0 section" style="position:absolute;bottom:0;">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="pi-draggable pi-item" draggable="true">Rxda</h1>
          <p>
            <strong>韩瑞达</strong>
            <br>
            <a href="mailto:sxfscool@gmail.com">sxfscool@gmail.com</a>
          </p>
          <br>
          <br>
          <p></p>
          <div class="m-y-2 m-y-lg row text-center">
            <div class="col-xs-4 text-left">
              <a href="https://www.facebook.com/dfsdf.han"><i class="fa fa-3x fa-facebook text-primary"></i></a>
            </div>
            <div class="col-xs-4 text-left">
              <a href="https://twitter.com/HanRuida"><i class="fa fa-3x fa-twitter text-primary"></i></a>
            </div>
            <div class="col-xs-4 text-left">
              <a href="http://weibo.com/u/2876209190"><i class="fa fa-3x text-primary fa-weibo"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
	<script type="text/javascript"
		src="/bysj/js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript"
		src="/bysj/js/bootstrap.js"></script>
	<script src="/bysj/js/login.js"></script>

</body>

</html>