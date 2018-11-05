/**
 * 
 */
var uid=$("#uidsession").val();
function getFans() {
	$.ajax({  
    type: "GET",  
    url: "subscript/"+uid,
    dataType: "json",  
    success: function(data){              
        $(data).each(function(){
        
       $("#tbody").append("<tr><td class='td2'><a href='http://127.0.0.1:8080/bysj/userpage/"+this.uid+"'><img src='http://127.0.0.1:8080/img/userhead/"+this.uimg+"' class='img-circle'></a></td><td><a href='http://127.0.0.1:8080/bysj/userpage/"+this.uid+"'><p>"+this.nickname+"</p></a></td><td class='td1'><a onclick='beNoFan("+this.uid+")' class='btn btn-block btn-warning btn-sm'><i class='fa fa-fw -circle fa-minus'></i>取消关注</a></td><td class='td1'><a href='http://127.0.0.1:8080/bysj/writeletter/"+this.uid+"' class='btn btn-block btn-info btn-sm'><i class='fa fa-fw -circle fa-envelope'></i>私信</a></td></tr>");
					}); 
        },
    error: function(text) {
    		
    
    }  
});  
}

$(document).ready(function(){ 
        getFans();
}); 

function beNoFan(uid1) {
	$.ajax({  
    type: "POST",  
    url: "nolongerfan",
    data:{uid1:uid1,uid2:uid},
    dataType: "json",  
    success: function(data){              
        if(data.msg=="success"){
        	window.location.href=window.location.href;
        	
        } 
        },
    error: function(text) {
    		alert("error");
    
    }  
});  
}

