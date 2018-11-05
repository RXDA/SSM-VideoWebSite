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
  <div class="section" style="top:100px;">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <div class="alert alert-success" role="alert" >
            <strong style="float:left">视频投稿成功</strong><br><div id="alertbox" style="float:left"></div>秒后跳转至视频页...</div>
        </div>
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
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  	<script src="/bysj/js/userHeadImg.js"></script>
<script>
//设定倒数秒数  
var t = 4;  
//显示倒数秒数  
function showTime(){  
    t -= 1;  
    document.getElementById('alertbox').innerHTML=t;
    if(t==0){  
        location.href="${pageContext.request.contextPath}/video/<%=session.getAttribute("vid")%>";  
    }  
    //每秒执行一次,showTime()  
    setTimeout("showTime()",1000);
    } 
  
  
//执行showTime()  
showTime();  
</script>    
</html>  