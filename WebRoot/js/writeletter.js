/**
 * 检测字数
 */

function checkNumberOfText() {
	var num = $("#privateletter").val().length;
	var surplus = 140 - num;
	if (surplus >= 0) {
		$("#label").text("还可以输入" + surplus + "个字符");
		$("#button").removeAttr("disabled");
		$("#button").attr("class", "btn btn-primary");
	} else {
		$("#label").text("已超出" + (-surplus) + "个字符");
		$("#button").attr("disabled", "disabled");
		$("#button").attr("class", "btn btn-danger");
	}
}

