/**
 * 跳转链接
 * 
 */

var uid=$("#uidsession").val();
function changehref(){
$("#userinfo").attr("href","/bysj/usercenter/"+uid);
$("#videoupload").attr("href","/bysj/public/uploadvideo.jsp");
$("#videomanage").attr("href","/bysj/public/videomanage.jsp");
$("#subscript").attr("href","/bysj/public/subscript.jsp");
$("#fans").attr("href","/bysj/public/userfans.jsp");
$("#message").attr("href","/bysj/public/privateletter.jsp");
$("#changepasswd").attr("href","/bysj/public/changepasswd.jsp");
}
$(document).ready(function(){ 
	changehref();
}); 
