/**
 * 
 */
var uid=$("#uidsession").val();
var i=1;
function getFans() {
	$.ajax({  
    type: "GET",  
    url: "getletter/"+uid,
    dataType: "json",  
    success: function(data){              
        $(data).each(function(){
        
       $("#tbody").append("<tr><td id='td1' class='p-y-1'><span>"+i+"</span></td><td id='td2' class='p-y-1'><a href='#'>"+this.nickname+"</a></td><td id='td3' class='p-y-1'><a href='#'>"+this.message+"</a></td><td id='td4' class='m-a-0'><a href='#' class='btn btn-primary btn-sm m-a-0'>删除</a></td></tr>");
       i=i+1;			
        });
        
        },
    error: function(text) {
    		
    
    }  
});  
}

$(document).ready(function(){ 
        getFans();
});