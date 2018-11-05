<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>个人中心</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/bysj/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/bysj/css/pingendo.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet"
	type="text/css">

<link href="${pageContext.request.contextPath}/css/fanstable.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body>
	<nav class="navbar navbar-full navbar-light bg-faded" draggable="true">
		<a class="navbar-brand" href="#">Skyrim</a>
		<ul class="nav navbar-nav pull-right">
			<li class="nav-item"><input type="hidden" id="uidsession"
				value="<%=Integer.parseInt(session.getAttribute("uid").toString())%>" /> <a
				href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><img
					id="userimg" class="img-circle img-fluid userimg"
					src="<%=session.getAttribute("uimg").toString()%>"></a></li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><%=session.getAttribute("nickname").toString()%></a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/logout">退出登录</a></li>
		</ul>
	</nav>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="display-3">个人中心</h1>
				</div>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<ul class="nav nav-pills nav-stacked">
            <li class="nav-item">
              <a id="userinfo" class="nav-link" href="">个人信息</a>
            </li>
            <li class="nav-item">
              <a id="videoupload" class="nav-link" href="">视频上传</a>
            </li>
            <li class="nav-item">
              <a id="videomanage" class="nav-link" href="">视频管理</a>
            </li>
            <li class="nav-item">
              <a id="subscript" class="nav-link" href="#">关注</a>
            </li>
            <li class="nav-item">
              <a id="fans" class="nav-link active" href="#">粉丝</a>
            </li>
            <li class="nav-item">
              <a id="message" class="nav-link" href="#">私信</a>
            </li>
            <li class="nav-item">
            <a id="changepasswd" class="nav-link" href="#">修改密码</a>
            </li>
          </ul>
				</div>
				<div class="col-md-9" id="panel">
				
				<div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
              <h3 class="text-info">粉丝列表</h3>
            </div>
            <!-- Table -->
            <table class="table">
              <tbody id="tbody">
                
              </tbody>
            </table>
          </div>
				
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="/bysj/js/jquery-2.2.4.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.2/js/bootstrap.js"></script>
	<script src="/bysj/js/href.js"></script>
  <script src="/bysj/js/fans.js"></script>



</body>

</html>