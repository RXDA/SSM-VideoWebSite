<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>登录失败</title>
    <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>  
<body>  
    <form id="form1">  
        <div id="div1"></div>
          
    </form>  
</body>
<script>
//设定倒数秒数  
var t = 5;  
//显示倒数秒数  
function showTime(){  
    t -= 1;
    document.getElementById('div1').color="red";  
    document.getElementById('div1').innerHTML="用户名或密码错误"+ t+"秒后跳转到登录页面...";  
    if(t==0){  
        location.href="${pageContext.request.contextPath}/login.jsp";  
    }  
    //每秒执行一次,showTime()  
    setTimeout("showTime()",1000);  
}  
  
  
//执行showTime()  
showTime();  
</script>    
</html>  
  
  
