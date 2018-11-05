/**
 * 
 */

 function getFilename(){

    var file = $("#videofile").val();
    if($("#videotitle").val()==null||$("#videotitle").val()==""){
    /* var pos=file.lastIndexOf("\\");
    var filename=file.substring(pos+1);   */
    var filename=file.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");  
    $("#videotitle").val(filename);
    }
}