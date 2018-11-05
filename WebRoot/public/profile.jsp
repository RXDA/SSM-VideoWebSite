<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <link href="/bysj/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="/bysj/css/pingendo.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body>
  <nav class="navbar navbar-full navbar-light bg-faded" draggable="true">
    <a class="navbar-brand" href="#">Skyrim</a>
    <ul class="nav navbar-nav pull-right">   
     <li class="nav-item">
       <input type="hidden" id="uidsession" value="<%=Integer.parseInt(session.getAttribute("uid").toString())%>"/>
       <a href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><img id="userimg" class="img-circle img-fluid userimg" style="width:35px;" src="<%=session.getAttribute("uimg").toString() %>"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><%=session.getAttribute("nickname").toString()%></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/logout">退出登录</a>
      </li>


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
              <a id="userinfo" class="nav-link active" href="">个人信息</a>
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
            <a id="changepasswd" class="nav-link" href="#">修改密码</a>
            </li>
          </ul>
        </div>
        <div class="col-lg-9">
          <div class="col-lg-3">
            <span class="label label-default m-y-2">用户uid</span>
            <br>
            <span class="label label-default m-y-1">昵称</span>
            <br>
            <span class="label label-default m-y-1">性别</span>
            <br>
            <span class="label label-default m-y-2">积分</span>
            <br>
            <span class="label label-default m-y-1">头像</span>
          </div>
          <div class="col-lg-6">
          <form action="${pageContext.request.contextPath}/updateuser" method="post" enctype="multipart/form-data">

            <input type="text" class="form-control m-y-1"  name="uid" value="${user.uid}" readonly = "readonly">
            <input type="text" class="form-control m-y-1" name="nickname"  id="nickname" value="${user.nickname}" onblur="checkNickIsExist()" onfocus="clearNickCss()">
            <span id="showNickResult"></span>
            <input type="text" class="form-control m-y-1" name="sex" value="${user.sex}">
            <input type="text" class="form-control m-y-1" name="point" value="${user.point}" readonly = "readonly">
            <img class="center-block img-fluid userimg"  style="width: 200px;"  src="<%=session.getAttribute("uimg").toString() %>">
            <input type="file" class="form-control m-y-1" accept="image/*" name="uimg">
            <button type="submit" class="btn btn-primary" >修改信息</button>
       		</form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/href.js"></script>
  <script src="/bysj/js/checkNickName.js"></script>
</body>

</html>