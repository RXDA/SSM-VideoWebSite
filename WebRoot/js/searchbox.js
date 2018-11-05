/**
 * 
 */
function setkeyword(){
  var keyword=$("#keywordinput").val();
  localStorage.setItem("keyword="+keyword, keyword);
  localStorage.setItem("keyword", keyword);
  if(keyword!=null&&keyword!=""){
  window.location.href="/bysj/public/search.jsp";
  }
  
  
  }