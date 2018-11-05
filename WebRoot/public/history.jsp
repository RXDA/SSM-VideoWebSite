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
      <div class="row" draggable="true">
    <div class="col-md-12">
    <h1 class="" draggable="true">播放历史</h1>
    
    </div>
        <div class="col-md-12">
          <div class="table-responsive" draggable="true">
            <table class="table" id="historytable">
              <thead>
                <tr>
                  <th>#</th>
                  <th>视频名称</th>
                  <th>播放日期</th>
                  <th>删除</th>
                </tr>
              </thead>
              
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  
  
  <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/searchbox.js"></script>
	<script type="text/javascript">
	var uid = $("#uidsession").val();
	title="";
	function listHistory() {
	$.ajax({  
    type: "GET",  
    url: "listhistory",
    dataType: "json",
    data:{uid:uid},  
    success: function(data){
        var i=1;              
        $(data).each(function(){
        if(this.playdate!=null){
				var date = new Date(this.playdate);
				var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
        }else{
        var dateStr="null";
        
        }
       $("#historytable").append("<tr><td>"+i+"</td><td><a href='/bysj/video/"+this.vid+"'>"+getVideoTitle(this.vid)+"</a></td><td>"+dateStr+"</td><td><button type='button' class='btn btn-primary' onclick='deleteHistory("+this.hid+")'>删除</button></td></tr>");
					i++; 
					
					});
					
        },
    error: function(text) {
    		
    
    }  
});  
}



function deleteHistory(hid) {
	$.ajax({  
    type: "GET",  
    url: "deletehistory",
    dataType: "json",
    data:{hid:hid},  
    success: function(data){
      
					
        },
    error: function(text) {
    		
    
    }  
});  
}


	
function getVideoTitle(vid){
$.ajax({
		type : "GET",
		url : "getvideotitle/"+vid,
		dataType : "json",
		async:false,
		success : function(data) {
	    	title=data.msg;
			 
		},
		error : function(data) {
		}
	});
return title;

}	
	
	$(document).ready(function() {
  listHistory();
	

	
});
	
	
	
	
	
	</script>



</body>

</html>