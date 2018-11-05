<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>setTimeout</title>
</head>  
<body>  
    <form id="form1">  
        <div id="div1">  
        </div>  
    </form>  
</body>
<script>
//设定倒数秒数  
var t = 5;  
//显示倒数秒数  
function showTime(){  
    t -= 1;  
    document.getElementById('div1').innerHTML="登录成功，"+ t+"秒后跳转到首页...";  
    if(t==0){  
        location.href="${pageContext.request.contextPath}/index.jsp";  
    }  
    //每秒执行一次,showTime()  
    setTimeout("showTime()",1000);  
}  
  
  
//执行showTime()  
showTime();  
</script>    
</html>  
  
  
