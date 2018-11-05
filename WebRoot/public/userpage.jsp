<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
 <nav class="bg-faded navbar navbar-fixed-top navbar-full navbar-light">
    <a class="navbar-brand"><span>Skyrim</span></a>
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
  </nav>
  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <br>
          <br>
        </div>
        <div class="bg-info col-lg-12">
          <div class="col-lg-4">
            <div class="col-lg-4">
              <img src="http://127.0.0.1:8080/img/userhead/${user.uimg}" class="img-circle img-fluid m-y-2" draggable="true" style="width:85px;height: 85px;">
            </div>
            <div class="col-lg-8">
              <h3 class="m-y-3">${user.nickname}</h3>
            </div>
          </div>
          <div class="bg-info col-lg-6"></div>
          <div class="col-lg-2">
            <a href="#" class="btn btn-block btn-warning m-y-3"><i class="fa fa-fw fa-bookmark"></i>关注</a>
          </div>
        </div>
        <div class="col-lg-12">
          <hr class="" draggable="true">
          <div class="col-lg-12">
            <ul class="nav nav-tabs" draggable="true">
              <li class="nav-item">
                <a href="#" class="active nav-link">视频投稿</a>
              </li>
             
            </ul>
          </div>
        </div>
        <div class="col-lg-12 p-a-0">
          <div class="col-lg-8" id="videopanel">
          </div>             
          <div class="col-lg-4">
            <br>
            <div class="col-lg-12">
              <h3 class="text-justify">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关注：<strong>&nbsp;${fansNum}</strong></h3>
              <br>
              <h3 class="text-justify">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;粉丝：<strong>&nbsp;${followNum}</strong></h3>
              <hr class="" draggable="true">
            </div>

            <div class="col-lg-12">
              <div class="col-lg-6">
                <h5 class="text-primary text-xs-left">UID&nbsp;:&nbsp;${user.uid}</h5>
              </div>
              <div class="col-lg-6">
                <h5 class="text-primary text-xs-left">性别:&nbsp;${user.sex}</h5>
              </div>
              <div class="col-lg-6">
                <h5 class="text-primary text-xs-left">积分:&nbsp;${user.point}</h5>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script>
  
function getVideos() {
	$.ajax({  
    type: "GET",  
    url: "videolist/"+${user.uid},
    dataType: "json",  
    success: function(data){              
        $(data).each(function(){
           $("#videopanel").append("<div class='col-lg-4'><div class='col-lg-10 text-xs-left'><a href='http://127.0.0.1:8080/bysj/video/"+this.vid+"'><img class='center-block img-fluid img-rounded m-y-1'src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"'><span style='display:block;width:140px;height:40px;overflow: hidden;font-size:12px;'>"+this.vtitle+"</span></a></div><div class='col-lg-2'></div>");
       
					}); 
        },
    error: function(text) {
    		
    
    }  
});  
}

$(document).ready(function(){ 
        getVideos();
});

  </script>
  
  

</body>

</html>