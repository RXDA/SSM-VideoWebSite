/**
 * tag标签列表的ajax
 */
 var t=0;
 var vid=$("#videoInfo").val();
 function listVideo() {
	$.ajax({  
    type: "GET",  
    url: "videotag/"+vid,
    dataType: "json",  
    success: function(data){              
        $(data).each(function(){
           t=t+1;
           $("#tagdiv").append("<div class='col-lg-5 m-y-1 text-xs-center tag'>"+this.tagtext+"<a href='/bysj/deletetag/"+this.tid+"'><i class='fa fa-fw fa-minus-circle pull-right'></i></a></div><div class='col-lg-1 m-y-1 text-xs-center '> </div>");
					});
					if(t%2!=0){
					$("#tagdiv").append("<div class='col-lg-6 m-y-1 text-xs-center style='hight:50px;''> \&nbsp </div>");
					}
        },
    error: function(text) {
    		
    
    }  
});  
}
$(document).ready(function(){ 
        listVideo();
}); 