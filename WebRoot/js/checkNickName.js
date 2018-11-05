/**
 * 
 */

function checkNickIsExist() {
	$("#showNickResult").html("正在检查昵称是否可用...");
	var nickname = $.trim($("#nickname").val());
	$.ajax({
		type : "GET", // http请求方式
		url : "checkNickExist",
		data : "nickname=" + nickname,
		// 发送给服务器的参数
		dataType : "json", // 告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
		error : function(data) {
			$("#showNickResult").html("账号检索错误");
		},
		success : function(data) {
			$("#showNickResult").html(data.msg);

		}
	}// 定义交互完成,并且服务器正确返回数据时调用回调函数
	);

}

function clearNickCss() {
	$("#showNickResult").html("");
}