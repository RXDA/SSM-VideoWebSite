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
  <div class="section section-fill-height section-opaque-light text-xs-center">
    <div class="background-image" style="background-image : url('img/cover-1.jpg')"></div>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="display-1 pi-draggable pi-item">Skyrim</h1>
          <p class="lead pi-draggable pi-item">视频爱好者的分享平台</p>
        </div>
      </div>
    </div>
  </div>
  <br>
  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-lg-12 text-xs-center">
          <ul class="lead m-y-1 nav nav-tabs p-a-0" style="display:blcok;width:600px;margin-left:auto;margin-right:auto;">
            <li class="nav-item">
              <a class="active nav-link" href="#">主页</a>
            </li>
            <li class="nav-item">
              <a href="/bysj/type=animation" class="nav-link">动画</a>
            </li>
            <li class="nav-item">
              <a href="/bysj/type=music" class="nav-link">音乐</a>
            </li>
            <li class="nav-item">
              <a href="/bysj/type=tec" class="nav-link">科技</a>
            </li>
            <li class="nav-item">
              <a href="/bysj/type=ent" class="nav-link">娱乐</a>
            </li>
            <li class="nav-item">
              <a  href="/bysj/type=movie" class="nav-link">电影</a>
            </li>
            <li class="nav-item">
              <a href="/bysj/type=game" class="nav-link">游戏</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="section">
    <div class="container">
      <div class="row" draggable="true">
      <div class="col-lg-6"><h3>热门视频</h3></div><div class="col-lg-6"><h3>&nbsp;&nbsp;&nbsp;最新上传</h3></div>
        <div class="col-lg-6">
          
          <div class="carousel slide" data-interval="3000" data-ride="carousel" id="carousel-example">
          	
            <div class="carousel-inner" id="scrollContainer">
            
            </div>
            <a class="left carousel-control" href="#carousel-example" data-slide="prev"><i class="icon-prev  fa fa-angle-left"></i></a>
            <a class="right carousel-control" href="#carousel-example" data-slide="next"><i class="fa fa-angle-right icon-next"></i></a>
          </div>
        </div>
        <div class="col-lg-6" id="newVideoContainer">
        
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <hr class="" draggable="true">
        </div>
      </div>
      
    </div>
  </div>
  
<!--   动画区 -->
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container1" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">动画区</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">动画排行榜</h3>
          <ol style="font-size:15px;" id="ol1">
            
          </ol>
        </div>
      </div>
    </div>
  </div>

 
 <!--  音乐区 -->
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container2" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">音乐区</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">音乐排行榜</h3>
          <ol style="font-size:15px;" id="ol2">
            
          </ol>
        </div>
      </div>
    </div>
  </div> 
  
  <!--   科技区 -->
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container3" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">娱乐区</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">娱乐排行榜</h3>
          <ol style="font-size:15px;" id="ol3">
            
          </ol>
        </div>
      </div>
    </div>
  </div>


<!--   娱乐区 -->
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">娱乐区</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">娱乐排行榜</h3>
          <ol style="font-size:15px;" id="ol4">
            
          </ol>
        </div>
      </div>
    </div>
  </div>
  

<!--   电影区 -->
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container5" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">电影区</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">电影排行榜</h3>
          <ol style="font-size:15px;" id="ol5">
            
          </ol>
        </div>
      </div>
    </div>
  </div>

<!--   游戏区 -->
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-8" id="container6" style="background-color:#fff;height:464px;border: 1px solid #ddd">
        <div class="col-md-12">
        <h3 class="text text-xs-left p-y-1">游戏区</h3>
        </div>
        </div>
        <div class="col-md-4" style="background-color:#fff;height:464px;border: 1px solid #ddd">
          <h3 class="text text-xs-left p-y-1">游戏排行榜</h3>
          <ol style="font-size:15px;" id="ol6">
            
          </ol>
        </div>
      </div>
    </div>
  </div>








  <div class="bg-info p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="pi-draggable pi-item" draggable="true">COMPANY</h1>
          <p>
            <strong>Company name, Inc.</strong>
            <br>795 Folsom Ave, Suite 600
            <br>San Francisco, CA 94107
            <br>
            <abbr title="Phone">P:</abbr>(123) 456-7890</p>
          <div class="m-y-2 m-y-lg row text-center">
            <div class="col-xs-4 text-left">
              <a><i class="fa fa-3x fa-facebook text-primary"></i></a>
            </div>
            <div class="col-xs-4 text-left">
              <a><i class="fa fa-3x text-primary fa-chrome"></i></a>
            </div>
            <div class="col-xs-4 text-left">
              <a><i class="fa fa-3x fa-instagram text-primary"></i></a>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="row" draggable="true">
            <div class="col-lg-6">
              <p class="" draggable="true">Lorem ipsum dolor sit amet, consectetur adipisici elit,
                <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                <br>Ut enim ad minim veniam, quis nostrud</p>
            </div>
            <div class="col-lg-6">
              <p class="" draggable="true">Lorem ipsum dolor sit amet, consectetur adipisici elit,
                <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                <br>Ut enim ad minim veniam, quis nostrud</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="bg-faded p-y-0 section">
    <div class="container-fluid"></div>
  </div>
  <div class="section" draggable="true">
    <div class="container-fluid"></div>
  </div>
  <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/searchbox.js"></script>
	<script>
	
		function getTopSeven(videotype) {
	  $.ajax({
		type : "GET",
		url : "video/top",
		data : {
				type : videotype,
				limit:7
			},
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
				$("#ol"+videotype).append("<a href='video/"+this.vid+"'><li>"+this.vtitle+"</li></a>");
			       			
			 });
		},
		error : function(data) {
		}
	});
}

	function getNewFour(videotype) {
	  $.ajax({
		type : "GET",
		url : "video/new",
		data : {
				type : videotype,
				limit:4
			},
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
			$("#container"+videotype).append("<div class='col-md-5'><a href='video/"+this.vid+"'><img src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' class='img-fluid img-thumbnail'><p style='width:270px;white-space:nowrap;overflow:hidden;font-size:15px;font-color:black' class='text-xs-center'>"+this.vtitle+"</p></a></div><div class='col-md-1'>");
				 });
		},
		error : function(data) {
		}
	});
}
	
	function getAllNewFour() {
	  $.ajax({
		type : "GET",
		url : "video/new",
		data : {
				type : 0,
				limit:4
			},
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
			$("#newVideoContainer").append("<a href='video"+this.vid+"'><div class='col-lg-5'><img src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' class='img-fluid img-thumbnail'><p style='width:200px;white-space:nowrap;overflow:hidden;font-size:15px;' class='text-xs-center'>"+this.vtitle+"</p></div></a><div class='col-lg-1'> </div>");
				 });
		},
		error : function(data) {
		}
	});
}


function getAllHotFive() {
	  $.ajax({
		type : "GET",
		url : "video/top",
		data : {
				type : 0,
				limit:4
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
	
	
$(document).ready(function() {
  getAllHotFive();
  getAllNewFour();
	var i=1;
	for(i=1;i<=6;i++){
	getTopSeven(i);
	getNewFour(i);
	
	}
	
});
	
	</script>
	













</body>

</html>