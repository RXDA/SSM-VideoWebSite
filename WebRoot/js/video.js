/**
 * 
 */

/* 日期格式化 */
var date = new Date($("#vdate").val());
var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
$("#formatdate").text(dateStr + "发布");

/* 发送评论 */
var uid = $("#uidsession").val();
var vid = $("#vid").val();
function getDiscuss() {
	var newdds = $("#discusstext").val();
	$.ajax({
		type : "POST",
		url : "addDiscuss",
		data : {
			uid : uid,
			vid : vid,
			newDiscuss : newdds
		},
		dataType : "json",
		success : function(data) {
		},
		error : function(data) {
		}
	});
}

/* 訂閲按鈕 */
var uid2 = $("#uidsession").val();
var uid1 = $("#uperuid").val();
var fansNumber=$("#fansNumber").val();

var followButton = "<button id='followbutton' type='button' class='btn btn-danger btn-sm' onclick='beFan()'>订阅</button><p id='fansNumber' class='btn btn-default btn-sm' style='border:1px solid #CCCCCC;'>"+fansNumber+"</p>";
var notFollowButton = "<button id='notfollowbutton' type='button' class='btn btn-info btn-sm' onclick='nolongerfan()'>取消订阅</button><p id='fansNumber' class='btn btn-default btn-sm' style='border:1px solid #CCCCCC;'>"+fansNumber+"</p>";
var disabledButton = "<button id='followbutton' type='button' class='btn btn-danger btn-sm' onclick='beFan()' disabled='disabled'>订阅</button><p id='fansNumber' class='btn btn-default btn-sm' style='border:1px solid #CCCCCC;'>"+fansNumber+"</p>";

function checkFans() {
	if (uid2 != undefined) {
		if (uid2 != uid1) {
			$.ajax({
				type : "GET",
				url : "checkfollow",
				data : {
					uid1 : uid1,
					uid2 : uid2
				},
				dataType : "json",
				success : function(data) {
					if (data.msg == false) {
						$("#subscriptdiv").append(followButton);
					} else {
						$("#subscriptdiv").append(notFollowButton);
					}
				},
				error : function(text) {
				}
			});
		} else {
			$("#subscriptdiv").append(disabledButton);
		}
	} else {
		$("#subscriptdiv").append(followButton);
	}
}

function beFan() {
	if (uid2 != undefined) {
		$.ajax({
			type : "POST",
			url : "befan",
			data : {
				uid1 : uid1,
				uid2 : uid2
			},
			dataType : "json",
			success : function(data) {
				$("#followbutton").remove();
				$("#fansNumber").remove();
				$("#subscriptdiv").append(notFollowButton);
				$("#fansNumber").text(data.number);
			},
			error : function(text) {
			}
		});
	} else {
		alert("尚未登录");
	}
}

function nolongerfan() {
	if (uid2 != undefined) {
		$.ajax({
			type : "POST",
			url : "nolongerfan",
			data : {
				uid1 : uid1,
				uid2 : uid2
			},
			dataType : "json",
			success : function(data) {
				$("#notfollowbutton").remove();
				$("#fansNumber").remove();
				$("#subscriptdiv").append(followButton);
				$("#fansNumber").text(data.number);
			},
			error : function(text) {
			}
		});
	}
}



var x = document.getElementById("video");
function checkTime() {
	if (x.currentTime / x.duration >= 0.5) {
		addPlayTime();
		clearInterval(func1);
	}
}
function addPlayTime() {
	var vid = $("#vid").val();
	$.ajax({
		type : "POST",
		url : "/addplaytime/"+vid,
		
		dataType : "json",
		success : function(data) {
		},
		error : function(data) {
		}
	});
}

function listDiscuss() {
	$.ajax({
		type : "GET",
		url : "listDiscuss/"+vid,
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
				
				$("#videodiv").append("<div class='col-md-12 p-y-1' style='background-color:#fff;border: 1px solid #E8E8E8'><div class='col-md-2'><img style='width:45px;height:45px;' src='http://127.0.0.1:8080/img/userhead/"+this.uimg+"' class='img-fluid img-rounded' draggable='true'></div><div class='col-md-10'><small style='position:absolute;top:0;left:0;'>"+this.nickname+"</small><p style='position:absolute;top:20;left:0;'>"+this.discusstext+"</p></div></div>");
			       			
			 });
		},
		error : function(data) {
		}
	});
}

function listTags() {
	$.ajax({
		type : "GET",
		url : "videotag/"+vid,
		dataType : "json",
		success : function(data) {
			$(data).each(function(){
				$("#tagdiv").append("<a href='/bysj/searchvideo/keyword="+this.tagtext+"'><span class='label label-info' style='font-size:15px'>"+this.tagtext+"</span></a>&nbsp;&nbsp;");
			       			
			 });
		},
		error : function(data) {
		}
	});
}

function addHistory() {
	$.ajax({
		type : "POST",
		url : "addhistory",
		data : {
			uid : uid,
			vid : vid
		},
		dataType : "json",
		success : function(data) {
		},
		error : function(data) {
		}
	});
}



function getYestodayHot() {
  $.ajax({
	type : "GET",
	url : "video/topyestoday",
	data : {
			type : 1,
			limit:4
		},
	dataType : "json",
	success : function(data) {
		$(data).each(function(){
		$("#recommend").append("<a href='/bysj/video/"+this.vid+"'><div class='col-md-12'><img src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' draggable='true' class='img-fluid' style='width:120px;'><strong style='position:absolute;top:0;left:140px;font-size:8px;display:inline-block;overflow:hidden;height:20px;' class='text-muted'>"+this.vtitle+"</strong><small style='position:absolute;top:25px;left:140px;width:200px;height:55px;display:inline-block;overflow:hidden;font-size:8px;' class='text-muted'>"+this.vintroduce+"</small><hr class='' draggable='true'></div></a>");
		});
	},
	error : function(data) {
	}
});
}

$(document).ready(function() {
	func1 = setInterval("checkTime()", 900);// 每隔0.9秒检测一次播放进度是否超过50%，不能使用var，用了的话就是局部变量了
	checkFans();
	listTags();
	listDiscuss();
	addHistory();
	getYestodayHot();
	
});




