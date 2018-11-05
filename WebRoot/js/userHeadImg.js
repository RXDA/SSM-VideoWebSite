/**
 * 用来获取用户头像的ajax
 */

function getUserImg() {
	var uid = $("#uidsession").val();
	$.ajax({
		type : "POST", // http请求方式
		url : "getUserImg.action",
		data : "uid=" + uid,
		// 发送给服务器的参数
		dataType : "json", // 告诉JQUERY返回的数据格式(注意此处数据格式一定要与提交的controller返回的数据格式一致,不然不会调用回调函数complete)
		error : function(data) {
		},
		success : function(data) {
			/* $("#userimg").src=data.msg; 没有这个函数*/
			$(".userimg").attr("src","http://127.0.0.1:8080/img/userhead/"+data.msg);

		}
	}// 定义交互完成,并且服务器正确返回数据时调用回调函数
	);

}

if($("#uidsession").val()!=null&&$("#uidsession").val()!=undefined){
	getUserImg();
}