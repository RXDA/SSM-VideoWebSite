/**
 * 
 */
function getUserNick(uid){
$.ajax({
		type : "GET",
		url : "getusernick/"+uid,
		dataType : "json",
		async:false,
		success : function(data) {
	    	nick=data.msg;
			 
		},
		error : function(data) {
		}
	});
return nick;

}

function selectType() {
	
	var keyword=$("#keyword").val();
	var videotype=$("#typeselect").val();
	localStorage.setItem("keyword="+keyword, keyword);
	console.log(localStorage.getItem("keyword="+keyword));
	if(keyword!=""){
	$("#row").empty();
	$.ajax({
		type : "POST",
		url : "searchvideo",
		dataType : "json",
		data : {
		  keyword : keyword,
			type : videotype
		},
		success : function(data) {
			$("#resultdiv").empty();
			 $(data).each(function(){	
				var date = new Date(this.vdate);
        var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
				$("#resultdiv").append("<div class='col-lg-2'></div><div class='col-lg-10 p-y-2' style='border:1px solid #ccc;background-color:#fff;width:780px;'><a href='/bysj/video/"+this.vid+"'><div class='row' draggable='true'><div class='col-lg-3'><img class='center-block img-fluid' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' draggable='true'></div><div class='col-lg-8'><div class='col-lg-12'><h6 class='m-a-0 text-info' draggable='true'>"+this.vtitle+"</h6></div><div class='col-lg-12'><a href='/bysj/userpage/"+this.subuid+"'><small class='m-a-0'>"+getUserNick(this.subuid)+"</small></a></div><div class='col-lg-12'><small class='m-a-0'>上传于"+dateStr+"&nbsp;&nbsp;"+this.vplaytime+"次观看</small><div class='col-lg-8 p-a-0'><small class='m-a-0 p-a-0'>"+this.vintroduce+"</small></div></div></div></a></div>");
			       			
			 });
			 
		},
		error : function(data) {
		$("#resultdiv").empty();
		$("#resultdiv").append("<div class='col-lg-12'><h4 class='display-4 text-xs-center'>未找到相关视频</h4></div>");	
		}
	});
	}
}

$(document).ready(function() {
	if(localStorage.keyword){
	/* alert(localStorage.getItem("keyword")); */
	localStorage.setItem("keyword="+keyword, localStorage.keyword);
	console.log(localStorage.getItem("keyword="+keyword));
	var keyword=$("#keyword").val(localStorage.keyword);
	$.ajax({
		type : "POST",
		url : "searchvideo",
		dataType : "json",
		data : {
		  keyword : localStorage.keyword,
			type : "全部"
		},
		success : function(data) {
			$("#resultdiv").empty();
			 $(data).each(function(){	
				var date = new Date(this.vdate);
        var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
				$("#resultdiv").append("<div class='col-lg-2'></div><div class='col-lg-10 p-y-2' style='border:1px solid #ccc;background-color:#fff;width:780px;'><a href='/bysj/video/"+this.vid+"'><div class='row' draggable='true'><div class='col-lg-3'><img class='center-block img-fluid' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"' draggable='true'></div><div class='col-lg-8'><div class='col-lg-12'><h6 class='m-a-0 text-info' draggable='true'>"+this.vtitle+"</h6></div><div class='col-lg-12'><a href='/bysj/userpage/"+this.subuid+"'><small class='m-a-0'>"+getUserNick(this.subuid)+"</small></a></div><div class='col-lg-12'><small class='m-a-0'>上传于"+dateStr+"&nbsp;&nbsp;"+this.vplaytime+"次观看</small><div class='col-lg-8 p-a-0'><small class='m-a-0 p-a-0'>"+this.vintroduce+"</small></div></div></div></a></div>");
			       			
			 });
	
	}
});
}
localStorage.removeItem("keyword");
})
	
$(document).ready(function() {
		/*ocalStorage.clear();*/
		var historylist=new Array();
		console.log(localStorage.getItem(localStorage.key(0)));
		console.log(localStorage.keyword);
		/* localStorage.keyword!=undefined&&localStorage.getItem(localStorage.key(0))!="" */
		//列出搜索记录
		 
		 for(var i=localStorage.length - 1 ; i >=0; i--){		   
		   if(localStorage.getItem(localStorage.key(i))!=""&&historylist.length<=10&&localStorage.getItem(localStorage.key(i))!=""){
			   historylist.push(localStorage.getItem(localStorage.key(i)));
       /*$("#search-history").append("<li id=li"+j+" onclick='setkeyword(this.innerHTML)'>"+localStorage.getItem(localStorage.key(i))+"</li>");*/
       }else{
       	$("#historydiv").append("<p>没有搜索记录</p>");
   	}
     }

     //搜索记录去重复
     for(i=historylist.length-1;i>=0;i--){
     		var y;
     		for(y=1;y<i;y++){
     			if(historylist[i].toString()==historylist[y].toString()){
     				historylist.splice(i,1);     				
     			}

     		}
     
     }
     
     for(i=0;i<history.length;i++){
    	 if(historylist[i].toString()!=null&&historylist[i].toString()!=""){
    		var r=i+1;
    	 $("#search-history").append("<li id=li onclick='setkeyword(this.innerHTML.substring(8))'>"+r+".&nbsp;"+historylist[i].toString()+"</li>");
    	 }
     }
      

	
	})
	
	//搜索记录点击
	function setkeyword(keyword){
  localStorage.setItem("keyword="+keyword, keyword);
  localStorage.setItem("keyword", keyword);
  if(keyword!=null&&keyword!=""){
  window.location.href="/bysj/public/search.jsp";
  }
  
  
  }
	