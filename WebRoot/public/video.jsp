<%@page import="com.skyrim.controller.FollowAndFansContorller"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Skyrim-${video.vtitle}</title>
  <link rel="icon" href="/bysj/img/Skyrim_32px.png">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/bysj/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="/bysj/css/pingendo.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body style="background-color:#F1F1F1">
  <nav class="bg-faded navbar navbar-fixed-top navbar-full navbar-light">
    <a class="navbar-brand" href="#"><span>Skyrim</span></a>
    <ul class="nav navbar-nav pull-right">
      <%
		if (session.getAttribute("username") == null||session.getAttribute("username") == "undefined") {
	%>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/regist.jsp">注册</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">登录</a>
      </li>
      <%}else{%>     
       <li class="nav-item">
       <input type="hidden" id="uidsession" value="<%=Integer.parseInt(session.getAttribute("uid").toString())%>"/>
       <a href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><img id="userimg" class="img-circle img-fluid userimg" src="<%=session.getAttribute("uimg").toString() %>"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><%=session.getAttribute("nickname").toString()%></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/bysj/public/history.jsp">历史记录</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/bysj/public/collect.jsp">收藏</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/logout">退出登录</a>
      </li>
      <%}%>
    </ul>
    <div class="input-group text-xs-right" style="width:300px;float:right;right:30px;">
      <input id="keywordinput" type="text" class="form-control" placeholder="请输入要查找的内容" aria-describedby="basic-addon2">
      <span class="input-group-addon btn-success" id="basic-addon2" onclick="setkeyword()">搜索</span>
    </div>
    <br>
  </nav>
  <div class="section">
    <div class="container">
      <div class="row">
        <br>
        <br>
        <br>
        <div id="videodiv" class="col-md-8" style="">
          <div class="embed-responsive embed-responsive-16by9" draggable="true">
            <video id="video" src="http://127.0.0.1:8080/video/${video.vurl}" controls="controls" poster="http://127.0.0.1:8080/img/videocover/${video.vcover}" ></video>
          </div>
          <input type="hidden" id="vid" value="${video.vid }"/>
          
          <br>
          <div class="col-md-12" style="background-color:#fff;border: 1px solid #E8E8E8">
            <h4>${video.vtitle}</h4>
            <input type="hidden" id="uperuid" value="${uper.uid }"/>
            <input type="hidden" id="fansNumber" value="${fansNumber}"/>
            <a href="/bysj/userpage/${uper.uid }"><img style="width:50px;height:50px;" src="http://127.0.0.1:8080/img/userhead/${uper.uimg } " class="img-fluid img-rounded" ></a>
            <a href="/bysj/userpage/${uper.uid }"><p style="width:50px;position:absolute;top:30px;left:80px;">${uper.nickname } </p></a>
            <div id="subscriptdiv" class="btn-group" role="group" aria-label="..." style="width:150px;position:absolute;top:55px;left:80px;">
            
              
            </div>
            <p style="position:absolute;top:60px;left:600px;" class="lead text-xs-right">${video.vplaytime}次观看</p>
            <br>
          </div>

          <div class="col-md-12" style="background-color:#fff;border: 1px solid #E8E8E8">
						<input id="vdate" type="hidden" value="${video.vdate}"/>
            <p>
              <small id="formatdate"></small>
              <br>
              <span>${video.vintroduce}</span>

            </p>

          </div>
           <div id="tagdiv" class="col-md-12" style="background-color:#fff;border: 1px solid #E8E8E8">
            
          </div>
          <div class="col-md-12 p-y-1" style="background-color:#fff;border: 1px solid #E8E8E8;height:130px;">
            <div class="col-md-2">
            <%if(session.getAttribute("username") != null&&session.getAttribute("username") != "undefined") {%>
              <img id="userheadimg" style="width:45px;height:45px;"  src="<%=session.getAttribute("uimg").toString()%>" class="img-fluid img-rounded" >
              </div>
            <div class="col-md-10">
              <textarea id="discusstext" class="form-control"  rows="2" style="resize: none;position:absolute;top:0px;left:0px;"></textarea>
              <button id="discusssubmit" class="btn btn-info btn-sm" type="button" style="position:absolute;top:70px;left:500px;" onclick="getDiscuss()">评论</button>
              <%}else{ %>
              <img id="userheadimg" style="width:45px;height:45px;"  src="http://127.0.0.1:8080/img/userhead/default.png" class="img-fluid img-rounded" >
              </div>
            <div class="col-md-10">
            <div style="display:inline;position:absolute;z-index:30;left:180px;width:300px;top:15px;"><p style="display:inline-block;">请</p><a href="/bysj/login.jsp"><button class="btn btn-info btn-sm" type="button" onclick="" style="">登录</button></a><p style="display:inline-block;">后发表评论!</p></div>
              <textarea id="discusstext" class="form-control"  rows="2" style="resize: none;position:absolute;top:0px;left:0px;z-index: 20;background-color:#DDDDDD" disabled="disabled"></textarea>
              
              <%}%>
            
            </div>

          </div>



          
        </div>
        <div class="col-md-4" style="background-color:#fff;border: 1px solid #E8E8E8" id="recommend">
          <h4>&nbsp;视频推荐</h4>

          
        </div>

      </div>
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/video.js"></script>
  <script src="/bysj/js/searchbox.js"></script>
</body>
</html>

