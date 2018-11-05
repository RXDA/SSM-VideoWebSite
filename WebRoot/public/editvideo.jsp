<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人中心</title>
    
	
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/bysj/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="/bysj/css/pingendo.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/tag.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body>
  <nav class="navbar navbar-full navbar-light bg-faded" draggable="true">
    <a class="navbar-brand" href="#">Skyrim</a>
    <ul class="nav navbar-nav pull-right">   
       <li class="nav-item">
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
              <a id="userinfo" class="nav-link" href="">个人信息</a>
            </li>
            <li class="nav-item">
              <a id="videoupload" class="nav-link" href="">视频上传</a>
            </li>
            <li class="nav-item">
              <a id="videomanage" class="nav-link active" href="">视频管理</a>
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
        <div class="col-lg-9" >
         <div class="col-lg-3 p-a-0">
            <span class="label label-default m-y-2">视频名称</span>
            <br>
            <span class="label label-default m-y-1">选择分类</span>
            <br>
            <span class="label label-default m-y-2">视频封面</span>

            <br>
            <span class="label label-default m-y-1">视频简介</span>
            <br>
            
            
            <span class="label label-default m-y-3">添加新标签</span>
            <br>
            <br>
            
            <span class="label label-default m-y-2">编辑标签</span>
          </div>
          <div class="col-lg-6">
            <form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/updatevideo/${video.vid}" id="videoform">
             <input type="hidden" name="vid" value="${video.vid}">  
            <input type="hidden" name="subuid" value="<%=Integer.parseInt(session.getAttribute("uid").toString())%>">    
            <input type="hidden" id="videoInfo" value="<%=Integer.parseInt(session.getAttribute("videoInfovid").toString())%>">      
              <div class="form-group text-xs-left">
                <input type="text" class="form-control m-y-1" required="required" name="vtitle" id="vtitle" placeholder="输入视频的新标题" value="${video.vtitle}">
              </div>
              <div class="form-group">
              

                <select class="form-control" name="vtype">
                  <option value="动画">动画</option>
                  <option value="音乐">音乐</option>
                  <option value="科技">科技</option>
                  <option value="娱乐">娱乐</option>
                  <option value="电影">电影</option>
                  <option value="游戏">游戏</option>
                </select>
              </div>

              <div class="form-group m-y-2">
                <input type="file" class="form-control-file" accept="image/*" required="required" name="vcover" >
              </div>
              <div class="form-group">
                <textarea class="form-control m-y-1" style="resize: none;" rows="2" name="vintroduce" >${video.vintroduce}</textarea>
              </div>
              <div class="form-group">
                <textarea class="form-control m-y-1" style="resize: none;" rows="2" name="tagString"></textarea>
              </div>
              <p class="" draggable="false">*输入多个标签时请使用半角逗分隔</p>
    
            </form>
             <div class="" id="tagdiv">
             
              </div>
 
        		<div><button type="button" class="btn btn-primary" onclick="document.getElementById('videoform').submit();">提交</button></div>
              
          </div>
          
        </div>
        
      </div>
      
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/tag.js"></script>
  <script src="/bysj/js/href.js"></script>








</body>

</html>