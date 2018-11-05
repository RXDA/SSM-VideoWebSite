/**
 * 
 */

function checkLogin() {
	var username = $.trim($("#username").val());
	var password = $.trim($("#password").val());
	
	$.ajax({
		type : "POST", // http请求方式
		url : "checkUserLogin",
		data:{username:username,password:password},
		// 发送给服务器的参数
		dataType : "json", // 告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
		error : function(data) {
			alert("用户名检索错误");
		},
		success : function(data) {
			if(data.msg=="1"){
				$("#loginform").submit();
			}else{
				if(data.msg=="0"){
					alert("用户名或密码错误");
				
				}else{
					alert("用户名不能为空");
				}	
			}
		}
	}// 定义交互完成,并且服务器正确返回数据时调用回调函数
	);

}