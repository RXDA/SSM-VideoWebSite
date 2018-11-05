/**
 * 用户注册页面的相关js
 */

$.validator.setDefaults({
	submitHandler : function() {
		
	}
});
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	$("#signupForm").validate({
		rules : {
			uname : {
				required : true,
				minlength : 4
			},
			password : {
				required : true,
				minlength : 6
			},
			confirm_password : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			}
		},
		messages : {

			uname : {
				required : "请输入用户名",
				minlength : "用户名必需由4个以上字母组成"
			},
			password : {
				required : "请输入密码",
				minlength : "密码长度不能小于 6 个字母"
			},
			confirm_password : {
				required : "请输入密码",
				minlength : "密码长度不能小于 6 个字母",
				equalTo : "两次密码输入不一致"
			},
		}
	});
});

function checkUnameIsExist() {
	if($("#username").val()!=null&&$("#username").val()!=""&&$("#username").val().length>=4){
		$("#showResult").html("正在检查账号可用性...");
		
	}
	
	var username = $.trim($("#username").val());
	$.ajax({
		type : "GET", // http请求方式
		url : "checkUserExist",
		data : "username=" + username,
		// 发送给服务器的参数
		dataType : "json", // 告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
		error : function(data) {
			$("#showResult").html("账号检索错误");
		},
		success : function(data) {
			if($("#username").val()!=null&&$("#username").val()!=""&&$("#username").val().length>=4){
			$("#showResult").html(data.msg);
			}
		}
	}// 定义交互完成,并且服务器正确返回数据时调用回调函数
	);

}

function clearCss() {
	$("#showResult").html("");
}




var hidRadio = $("#hidSex").val();
var radios = document.getElementsByName("sex");
if (hidRadio == "True") {
	radios[0].checked = true;
} else {
	radios[1].checked = true;
}
