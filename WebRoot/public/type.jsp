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
    
    <title>Skyrim</title>
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
<input id="type" type="hidden" value="${type}">
<input id="typeId" type="hidden" value="${typeId}">
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
  <div class="section section-fill-height section-opaque-light text-xs-center" style="height:120px;">
    <div class="background-image" style="background-image : url('/bysj/img/cover-1.jpg')"></div>
    <div class="container">
      <div class="row"></div>
    </div>
  </div>
  <div class="section">
  
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-xs-center">
          <ul class="lead m-y-1 nav nav-tabs p-a-0" style="display:blcok;width:600px;margin-left:auto;margin-right:auto;">
            <li class="nav-item">
              <a class="nav-link" href="#">主页</a>
            </li>
            <li class="nav-item">
              <a id="url1" href="/bysj/type=animation" class="nav-link">动画</a>
            </li>
            <li class="nav-item">
              <a id="url2" href="/bysj/type=music" class="nav-link">音乐</a>
            </li>
            <li class="nav-item">
              <a id="url3" href="/bysj/type=tec" class="nav-link">科技</a>
            </li>
            <li class="nav-item">
              <a id="url4" href="/bysj/type=ent" class="nav-link">娱乐</a>
            </li>
            <li class="nav-item">
              <a id="url5"  href="/bysj/type=movie" class="nav-link">电影</a>
            </li>
            <li class="nav-item">
              <a id="url6" href="/bysj/type=game" class="nav-link">游戏</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="section">
  
    <div class="container">
    <div class="col-lg-6">
    <h3>热门视频</h3></div><div class="col-lg-6"><h3>&nbsp;&nbsp;&nbsp;最新视频</h3></div>
      <div class="row" draggable="true">
        <div class="col-lg-6">
          <div class="carousel slide" data-interval="3000" data-ride="carousel" id="carousel-example">
            <div class="carousel-inner" id="scrollContainer">
              
            </div>
            <a class="left carousel-control" href="#carousel-example" data-slide="prev"><i class="icon-prev  fa fa-angle-left"></i></a>
            <a class="right carousel-control" href="#carousel-example" data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
          </div>
        </div>
        <div class="col-lg-6" id="newVideoContainer">
        
        </div>
      </div>
      </div>
      <div class="col-lg-12">
        <hr class="" draggable="true">
      </div>
      
  </div>
  
  
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container1" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">今日热门</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">本区排行榜</h3>
          <ol style="font-size:15px;" id="ol1">
            
          </ol>
        </div>
      </div>
    </div>
  </div> 
  
  
  
  <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/searchbox.js"></script>
	<script>
	var type=$("#type").val();
	var typeId=$("#typeId").val();
	function getHotFive() {
	  $.ajax({
		type : "GET",
		url : "video/top",
		data : {
				type : typeId,
				limit:5
			},
		dataType : "json",
		success : function(data) {
			var i=1;
			$(data).each(function(){
			$("#scrollContainer").append("<div id='con"+i+"' class='carousel-item'><a href='video/"+this.vid+"'><img class='img-fluid' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"'><div class='carousel-caption'><h4>"+this.vtitle+"</h4></div></a></div>");
				 });
			$("#con1").attr("class","carousel-item active");
		},
		error : function(data) {
		}
	});
}
	
		function getNewFour() {
	  $.ajax({
		type : "GET",
		url : "video/new",
		data : {
				type : typeId,
				limit:4
			},
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
			$("#newVideoContainer").append("<a href='video/"+this.vid+"'><div class='col-lg-5'><img src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' class='img-fluid img-thumbnail'><p style='width:200px;white-space:nowrap;overflow:hidden;font-size:15px;' class='text-xs-center'>"+this.vtitle+"</p></div></a><div class='col-lg-1'> </div>");
				 });
		},
		error : function(data) {
		}
	});
}


function getTopTen() {
	  $.ajax({
		type : "GET",
		url : "video/top",
		data : {
				type : typeId,
				limit:10
			},
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
				$("#ol1").append("<a href='video/"+this.vid+"'><li>"+this.vtitle+"</li></a>");
			       			
			 });
		},
		error : function(data) {
		}
	});
}
	
	
	function getYestodayHot() {
	  $.ajax({
		type : "GET",
		url : "video/topyestoday",
		data : {
				type : typeId,
				limit:4
			},
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
			$("#container1").append("<div class='col-md-5'><a href='video/"+this.vid+"'><img src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' class='img-fluid img-thumbnail'><p style='width:270px;white-space:nowrap;overflow:hidden;font-size:15px;font-color:black' class='text-xs-center'>"+this.vtitle+"</p></a></div><div class='col-md-1'>");
			});
		},
		error : function(data) {
		}
	});
}
	
	
	
	function changActiveUrl(){
	$("#url"+typeId).attr("class","nav-link active")
	
	
	
	}
	
	
	$(document).ready(function() {
  changActiveUrl();
	getHotFive();
	getNewFour();
	getTopTen();
	getYestodayHot();
	
});
	
	
	</script>



</body>

</html>