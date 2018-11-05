/**
 * 视频管理的ajax
 */
function listVideo() {
	$.ajax({  
    type: "GET",  
    url: "videomanagelist",
    dataType: "json",  
    success: function(data){              
        $(data).each(function(){
        if(this.vdate!=null){
				var date = new Date(this.vdate);
				var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate();
        }else{
        var dateStr="null";
        
        }
       $("#videolist").append("<tr><td><a href='/bysj/video/"+this.vid+"'><img style='width:50px;' src='http://127.0.0.1:8080/img/videocover/"+this.vcover+"'/></a></td><td width='200px'><a href='/bysj/video/"+this.vid+"'>"+this.vtitle+"</a></td><td>"+dateStr+"</td><td>"+this.vplaytime+"</td><td>"+this.vcoll+"</td><td><div class='btn-group'><button type='button' class='btn btn-sm btn-info dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>管理 <span class='caret'></span></button><ul class='dropdown-menu'><li><a href='/bysj/videoinfo/"+this.vid+"'>编辑</a></li><li><a href='/bysj/deletevideo/"+this.vid+"'>删除</a></li></ul></div></td></tr>");
					}); 
        },
    error: function(text) {
    		
    
    }  
});  
}

$(document).ready(function(){ 
        listVideo();
}); 