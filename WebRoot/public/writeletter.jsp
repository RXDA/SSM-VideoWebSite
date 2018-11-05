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
              <a id="message" class="nav-link active" href="#">私信</a>
            </li>
            <li class="nav-item">
            <a id="changepasswd" class="nav-link" href="#">修改密码</a>
            </li>
          </ul>
        </div>
        <div class="col-lg-9" id="pannel">
          <h3 class="text-info">发送私信</h3>
          <form class="" draggable="true">
          <%java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
							java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
							String str_date1 = formatter.format(currentTime); %>
            <input type="hidden" id="senddate" value="<%=str_date1%>">
          <input type="hidden" name="receiveruid" value="${receiveruid}"/>
            <div class="form-group" >
              <label style="width:300px;">收信人:&nbsp;&nbsp; ${receivernickname}</label>

            </div>
            <div class="form-group">
              <label>私信:</label>
              <textarea class="form-control" style="resize: none;" rows="5" name="message" required="required" id="privateletter" onkeydown="checkNumberOfText()"></textarea>
              <small class="text-muted" id="label">还可以输入140个字符</small></div>
            <button type="button" class="btn btn-primary" id="button" onclick="sendLetter()">发送</button>
          </form>
        </div>
      </div>
    </div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
  <script src="/bysj/js/href.js"></script>
  <script src="/bysj/js/writeletter.js"></script>
	<script>
	var senderuid=$("#uidsession").val();
	var receiveruid=${receiveruid};
	var sendDate=$("#senddate");
	//注意:在这里取message必为空值，因为是在页面加载时取的值，此时textarea还没有填写
/* 	var message=$("#privateletter").val(); */
	function sendLetter() {
	var message=$("#privateletter").val();
	$.ajax({  
    type: "POST",  
    url: "sendletter",
    data:{senderuid:senderuid,receiveruid:receiveruid,message:message,sendDate:sendDate},
    dataType: "json",  
    success: function(data){
      if(data.msg=="success"){           
        $("#pannel").prepend("<div class='alert alert-success alert-dismissible' role='alert'><strong>发送成功!</strong> 你的私信已经送达.</div>");
      }
    },
    error: function(text) {
    		$("#pannel").prepend("<div class='alert alert-danger alert-dismissible' role='alert'><strong>发送失败!</strong> 私信发送时发生错误，请重试.</div>");
    
    }  
});  
}
	
	
	
	</script>




</body>

</html>