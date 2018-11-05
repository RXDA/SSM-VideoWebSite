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
    
    <title>Skyrim-Search</title>
  <link rel="icon" href="/bysj/img/Skyrim_32px.png">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/bysj/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="/bysj/css/pingendo.min.css" rel="stylesheet" type="text/css">
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
        <a class="nav-link" href="${pageContext.request.contextPath}/logout">退出登录</a>
      </li>
      <%}%>
    </ul>
    
    <br>
  </nav>
  <div class="section">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        <br>
        <br>
        <br>
        <br>
          <h1 class="text-center text-xs-center">Skyrim|综合搜索</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-md-8 col-md-offset-1" style="left:114px;">
          <form role="form">
            <div class="form-group">
              <div class="input-group">
                <span class="input-group-btn">
                 <select id="typeselect" class="btn btn-info" style="height:38px;" onchange="selectType();">
                   <option value="全部" selected="selected">全部</option>
                   <option value="动画">动画</option>
                   <option value="音乐">音乐</option>
                   <option value="科技">科技</option>
                   <option value="娱乐">娱乐</option>
                   <option value="电影">电影</option>
                   <option value="游戏">游戏</option>
                 </select>
                </span>
                <input id="keyword" type="text" class="form-control" placeholder="搜索你想要的内容...">
                <span class="input-group-btn">
                  <button class="btn btn-success" type="button" id="searchbutton" onclick="selectType()">搜索</button>
                  </span>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="section">
    <div class="container" id="resultdiv">
      <div class="row" id="row">
        <div class="col-lg-2">&nbsp;</div>
        <div class="col-lg-4" style="border:2px solid #dddddd;">
          <p class="text-success">&nbsp;&nbsp;&nbsp;&nbsp;热门搜索
            <br><small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Daily Hot</small></p>
          <div class="col-lg-12">
            <ul class="list-inline">
              <li>1.&nbsp;Dota WTF-ep1</li>
              <li>1.&nbsp;Dota WTF-ep1</li>
              <li>1.&nbsp;Dota WTF-ep1</li>
              <li>1.&nbsp;Dota WTF-ep1</li>


            </ul>
          </div>


        </div>
        <div class="col-lg-1" style="width:10px;"> </div>
        <div class="col-lg-4" style="border:2px solid #dddddd;">
          <p class="text-success">&nbsp;&nbsp;&nbsp;&nbsp;搜索历史
            <br><small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search History</small></p>
          <div class="col-lg-12">
            <ul class="list-inline">
              <li>1.&nbsp;Dota WTF-ep1</li>
              <li>1.&nbsp;Dota WTF-ep1</li>
              <li>1.&nbsp;Dota WTF-ep1</li>
              <li>1.&nbsp;Dota WTF-ep1</li>


            </ul>
          </div>

        </div>
        <div class="col-lg-1">&nbsp;</div>

      </div>
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
	<script>
	
	/* function search() {
	
	var keyword=$("#keyword").val();
	if(keyword!=""){
	$("#row").empty();
	$.ajax({
		type : "GET",
		url : "searchvideo/keyword="+keyword,
		dataType : "json",
		success : function(data) {
			$("#resultdiv").empty();
			 $(data).each(function(){	
				var date = new Date(this.vdate);
        var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
				$("#resultdiv").append("<div class='col-lg-2'></div><div class='col-lg-10 p-y-2' style='border:1px solid #ccc;background-color:#fff;width:780px;'><a href='/bysj/video/"+this.vid+"'><div class='row' draggable='true'><div class='col-lg-3'><img class='center-block img-fluid' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' draggable='true'></div><div class='col-lg-8'><div class='col-lg-12'><h6 class='m-a-0 text-info' draggable='true'>"+this.vtitle+"</h6></div><div class='col-lg-12'><a href='/bysj/userpage/"+this.subuid+"'><small class='m-a-0'>"+getUserNick(this.subuid)+"</small></a></div><div class='col-lg-12'><small class='m-a-0'>上传于"+dateStr+"&nbsp;&nbsp;"+this.vplaytime+"次观看</small><div class='col-lg-8 p-a-0'><small class='m-a-0 p-a-0'>"+this.vintroduce+"</small></div></div></div></a></div>");
			       			
			 });
			 
		},
		error : function(data) {
		$("#resultdiv").append("<div class='col-lg-12'><h4 class='display-4 text-xs-center'>未找到相关视频</h4></div>");	
		}
	});
	}
} */

function getUserNick(uid){
$.ajax({
		type : "GET",
		url : "getusernick/"+uid,
		dataType : "json",
		async:false,
		success : function(data) {
	    	nick=data.msg;
			 
		},
		error : function(data) {
		}
	});
return nick;

}

function selectType() {
	
	var keyword=$("#keyword").val();
	var videotype=$("#typeselect").val();
	if(keyword!=""){
	$("#row").empty();
	$.ajax({
		type : "POST",
		url : "searchvideo",
		dataType : "json",
		data : {
		  keyword : keyword,
			type : videotype
		},
		success : function(data) {
			$("#resultdiv").empty();
			 $(data).each(function(){	
				var date = new Date(this.vdate);
        var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
				$("#resultdiv").append("<div class='col-lg-2'></div><div class='col-lg-10 p-y-2' style='border:1px solid #ccc;background-color:#fff;width:780px;'><a href='/bysj/video/"+this.vid+"'><div class='row' draggable='true'><div class='col-lg-3'><img class='center-block img-fluid' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' draggable='true'></div><div class='col-lg-8'><div class='col-lg-12'><h6 class='m-a-0 text-info' draggable='true'>"+this.vtitle+"</h6></div><div class='col-lg-12'><a href='/bysj/userpage/"+this.subuid+"'><small class='m-a-0'>"+getUserNick(this.subuid)+"</small></a></div><div class='col-lg-12'><small class='m-a-0'>上传于"+dateStr+"&nbsp;&nbsp;"+this.vplaytime+"次观看</small><div class='col-lg-8 p-a-0'><small class='m-a-0 p-a-0'>"+this.vintroduce+"</small></div></div></div></a></div>");
			       			
			 });
			 
		},
		error : function(data) {
		$("#resultdiv").empty();
		$("#resultdiv").append("<div class='col-lg-12'><h4 class='display-4 text-xs-center'>未找到相关视频</h4></div>");	
		}
	});
	}
}

$(document).ready(function() {
	if(localStorage.keyword){
	/* alert(localStorage.getItem("keyword")); */
	var keyword=$("#keyword").val(localStorage.keyword);
	$.ajax({
		type : "POST",
		url : "searchvideo",
		dataType : "json",
		data : {
		  keyword : localStorage.keyword,
			type : "全部"
		},
		success : function(data) {
			$("#resultdiv").empty();
			 $(data).each(function(){	
				var date = new Date(this.vdate);
        var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
				$("#resultdiv").append("<div class='col-lg-2'></div><div class='col-lg-10 p-y-2' style='border:1px solid #ccc;background-color:#fff;width:780px;'><a href='/bysj/video/"+this.vid+"'><div class='row' draggable='true'><div class='col-lg-3'><img class='center-block img-fluid' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' draggable='true'></div><div class='col-lg-8'><div class='col-lg-12'><h6 class='m-a-0 text-info' draggable='true'>"+this.vtitle+"</h6></div><div class='col-lg-12'><a href='/bysj/userpage/"+this.subuid+"'><small class='m-a-0'>"+getUserNick(this.subuid)+"</small></a></div><div class='col-lg-12'><small class='m-a-0'>上传于"+dateStr+"&nbsp;&nbsp;"+this.vplaytime+"次观看</small><div class='col-lg-8 p-a-0'><small class='m-a-0 p-a-0'>"+this.vintroduce+"</small></div></div></div></a></div>");
			       			
			 });
	
	}
});
}
localStorage.removeItem("keyword");
})
	

	
	</script>

</body>

</html>