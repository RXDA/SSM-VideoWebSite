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
<!-- <link href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.2/css/bootstrap.css" rel="stylesheet"> -->
<link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet"
	type="text/css">
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
              <a id="fans" class="nav-link" href="#">粉丝</a>
            </li>
            <li class="nav-item">
              <a id="message" class="nav-link" href="#">私信</a>
            </li>
            <li class="nav-item">
            <a id="changepasswd" class="nav-link active" href="#">修改密码</a>
            </li>
          </ul>
				</div>
        <div class="col-lg-9" id="pannel">
          <h3 class="text-info">修改密码</h3>
          <form draggable="true">
            <div class="form-group">
              <label>旧密码：</label>
              <input type="password" class="form-control" placeholder="Password" style="width:300px;" required="required" id="oldPassword">
            </div>
            <div class="form-group">
              <label>新密码：</label>
              <input type="password" class="form-control" placeholder="Password" style="width:300px;" required="required" id="newPassword">
              <small class="text-muted" id="newPasswordResult"></small>
            </div>
            <div class="form-group">
              <label>再次输入新密码：</label>
              <input type="password" class="form-control" placeholder="Password" style="width:300px;" required="required" id="reNewPassword">
              <small class="text-muted" id="reNewPasswordResult"></small>
            </div>
            <button type="button" class="btn btn-primary" id="button" onclick="changePassword()">确定</button>
          </form>

        </div>

      </div>
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script type="text/javascript" src="/bysj/js/href.js"></script>>
	<script>
	$("#newPassword").blur(function(){
	if($("#newPassword").val().length<6){
	$("#newPasswordResult").html("密码长度不能低于6个字符");
	$("#button").attr("disabled", "disabled");
	$("#button").attr("class", "btn btn-danger");
	}else{
	$("#newPasswordResult").html("");
	$("#button").removeAttr("disabled");
	$("#button").attr("class", "btn btn-primary");
	}
  
  });
  
	$("#reNewPassword").blur(function(){
	if($("#newPassword").val()!=$("#reNewPassword").val()){
	$("#reNewPasswordResult").html("两次输入的密码不同！");
	$("#button").attr("disabled", "disabled");
	$("#button").attr("class", "btn btn-danger");
	}else{
	$("#reNewPasswordResult").html("");
	$("#button").removeAttr("disabled");
	$("#button").attr("class", "btn btn-primary");
	}
  
  });
	
	function changePassword() {
	$(".alert").remove();
	var oldpasswd = $("#oldPassword").val();
	var newpasswd = $("#newPassword").val();
	var renewpasswd = $("#reNewPassword").val();
	var uid=$("#uidsession").val();
	$.ajax({
				type : "POST",
				url : "changepassword",
				data : {
				  uid : uid,
					oldpassword : oldpasswd,
					newpassword : newpasswd,
					renewpassword : renewpasswd
				},
				dataType : "json",
				success : function(data) {
					if (data.msg == "success") {
						$("#pannel").prepend("<div class='alert alert-success alert-dismissible' role='alert'><strong>修改成功!</strong> 请使用新密码登录.</div>");
						setTimeout("javascript:location.href='http://127.0.0.1:8080/bysj'", 3000)
					}else{
						$("#pannel").prepend("<div class='alert alert-danger alert-dismissible' role='alert'><strong>修改失败!</strong> "+data.msg+".</div>");
					
					}
				},
				error : function(text) {
					$("#pannel").prepend("<div class='alert alert-danger alert-dismissible' role='alert'><strong>修改失败!</strong> 修改密码时发送时发生错误，请重试.</div>");

				}
			});
}
	
	
	
	</script>









</body>

</html>