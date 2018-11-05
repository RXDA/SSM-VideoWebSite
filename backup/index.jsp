<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎访问Skyrim</title>
  <link rel="icon" href="/bysj/img/Skyrim_32px.png">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/bysj/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="/bysj/css/pingendo.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/imgstyle.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/body.css" rel="stylesheet" type="text/css">
</head>

<body>
  <nav class="bg-faded navbar navbar-fixed-top navbar-full navbar-light">
    <a class="navbar-brand"><span>Skyrim</span></a>
    <ul class="nav navbar-nav pull-right">
      <%
		if (session.getAttribute("username") == null||session.getAttribute("username") == "undefined") {
	%>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/regist.jsp">注册</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">登录</a>
      </li>
      <%}else{%>     
       <li class="nav-item">
       <input type="hidden" id="uidsession" value="<%=Integer.parseInt(session.getAttribute("uid").toString())%>"/>
       <a href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><img id="userimg" class="img-circle img-fluid userimg" src="<%=session.getAttribute("uimg").toString() %>"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/usercenter/<%=Integer.parseInt(session.getAttribute("uid").toString())%>"><%=session.getAttribute("nickname").toString()%></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/logout">退出登录</a>
      </li>
      <%}%>
    </ul>
  </nav>
  <div class="section section-fill-height section-opaque-light text-xs-center">
    <div class="background-image" style="background-image : url('/bysj/img/cover-1.jpg')"></div>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="display-1 pi-draggable pi-item">Skyrim</h1>
          <p class="lead pi-draggable pi-item">视频爱好者的分享平台</p>
        </div>
      </div>
    </div>
  </div>
  <div class="section">
    <div class="container">
      <div class="row" draggable="true">
        <div class="col-lg-5">
          <div class="carousel slide" data-interval="false" data-ride="carousel" id="carousel-example">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img  class="img-fluid" src="https://unsplash.imgix.net/photo-1423683249427-8ca22bd873e0?w=1024&amp;q=50&amp;fm=jpg&amp;s=5e57c661d0f772ce269188a6f5325708">
                <div class="carousel-caption">
                  <h2>Slide 1</h2>
                </div>
              </div>
              <div class="carousel-item">
                <img class="img-fluid" src="http://v4.pingendo.com/assets/photos/food/cover-1.jpg">
                <div class="carousel-caption">
                  <h2>Title</h2>
                  <p>Description</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="img-fluid" src="http://v4.pingendo.com/assets/photos/food/photo-1.jpg">
                <div class="carousel-caption">
                  <h2>Title</h2>
                  <p>Description</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="img-fluid" src="http://v4.pingendo.com/assets/photos/food/photo-2.jpg">
                <div class="carousel-caption">
                  <h2>Title</h2>
                  <p>Description</p>
                </div>
              </div>
              <div class="carousel-item">
                <img class="img-fluid" src="http://v4.pingendo.com/assets/photos/food/photo-3.jpg">
                <div class="carousel-caption">
                  <h2>Title</h2>
                  <p>Description</p>
                </div>
              </div>
            </div>
            <a class="left carousel-control" href="#carousel-example" data-slide="prev"><i class="icon-prev  fa fa-angle-left"></i></a>
            <a class="right carousel-control" href="#carousel-example" data-slide="next"><i class="fa fa-angle-right icon-next"></i></a>
          </div>
        </div>
        <div class="col-lg-7">
        <div class="col-lg-3" style="background-color:pink;"> </div>
        <div class="col-lg-1"> </div>
        <div class="col-lg-3" style="background-color:blue;"> </div>
        <div class="col-lg-1"> </div>
        <div class="col-lg-3" style="background-color:green;"> </div>
        <div class="col-lg-1"> </div>
        
        
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <hr class="" draggable="true">
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="row" draggable="true">
            <div class="col-lg-6">
              <div class="row" draggable="true">
                <div class="bg-warning col-lg-4 p-y-2">
                  <a href="#"><h1 class="text-xs-center">动画</h1></a>
                </div>
                <div class="bg-info col-lg-4">
                  <h1 class="p-y-2 text-xs-center">音乐</h1>
                </div>
                <div class="bg-inverse col-lg-4 p-y-2">
                  <h1 class="text-xs-center">科技</h1>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="row" draggable="true">
                <div class="bg-success col-lg-4 p-y-2">
                  <h1 class="text-xs-center">娱乐</h1>
                </div>
                <div class="bg-warning col-lg-4 p-y-2">
                  <h1 class="text-xs-center">电影</h1>
                </div>
                <div class="bg-danger col-lg-4 p-y-2">
                  <h1 class="text-xs-center">游戏</h1>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="http://v4.pingendo.com/assets/photos/business/photo-3.jpg" class="img-fluid">
        </div>
        <div class="col-md-6">
          <h1 class="text-primary">HEADING</h1>
          <h3>A subtitle</h3>
          <p class="lead">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
            pretium quis, sem.</p>
        </div>
      </div>
    </div>
  </div>
  <div class="p-y-3 section" draggable="true">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="text-primary">HEADING</h1>
          <h3>A subtitle</h3>
          <p class="lead">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
            pretium quis, sem.</p>
        </div>
        <div class="col-md-6">
          <img src="http://v4.pingendo.com/assets/photos/food/cover-1.jpg" class="img-fluid">
        </div>
      </div>
    </div>
  </div>
  <div class="p-y-3 section" draggable="true">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="http://v4.pingendo.com/assets/photos/fashion/photo-1.jpg" class="img-fluid img-thumbnail">
        </div>
        <div class="col-md-6">
          <h1 class="text-primary">HEADING</h1>
          <h3>A subtitle</h3>
          <p class="lead">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
            pretium quis, sem.</p>
        </div>
      </div>
    </div>
  </div>
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="text-primary">HEADING</h1>
          <h3>A subtitle</h3>
          <p class="lead">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
            pretium quis, sem.</p>
        </div>
        <div class="col-md-6">
          <img src="http://v4.pingendo.com/assets/photos/wireframe/photo-1.jpg" class="img-fluid">
        </div>
      </div>
    </div>
  </div>
  <div class="p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="http://v4.pingendo.com/assets/photos/wireframe/photo-1.jpg" class="img-fluid img-thumbnail">
        </div>
        <div class="col-md-6">
          <h1 class="text-primary">HEADING</h1>
          <h3>A subtitle</h3>
          <p class="lead">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
            pretium quis, sem.</p>
        </div>
      </div>
    </div>
  </div>
  <div class="p-y-3 section" draggable="true">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="text-primary">HEADING</h1>
          <h3>A subtitle</h3>
          <p class="lead">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu,
            pretium quis, sem.</p>
        </div>
        <div class="col-md-6">
          <img src="http://v4.pingendo.com/assets/photos/wireframe/photo-1.jpg" class="img-fluid">
        </div>
      </div>
    </div>
  </div>
  <div class="bg-info p-y-3 section">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="pi-draggable pi-item" draggable="true">COMPANY</h1>
          <p>
            <strong>Company name, Inc.</strong>
            <br>795 Folsom Ave, Suite 600
            <br>San Francisco, CA 94107
            <br>
            <abbr title="Phone">P:</abbr>(123) 456-7890</p>
          <div class="m-y-2 m-y-lg row text-center">
            <div class="col-xs-4 text-left">
              <a><i class="fa fa-3x fa-facebook text-primary"></i></a>
            </div>
            <div class="col-xs-4 text-left">
              <a><i class="fa fa-3x text-primary fa-chrome"></i></a>
            </div>
            <div class="col-xs-4 text-left">
              <a><i class="fa fa-3x fa-instagram text-primary"></i></a>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="row" draggable="true">
            <div class="col-lg-6">
              <p class="" draggable="true">Lorem ipsum dolor sit amet, consectetur adipisici elit,
                <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                <br>Ut enim ad minim veniam, quis nostrud</p>
            </div>
            <div class="col-lg-6">
              <p class="" draggable="true">Lorem ipsum dolor sit amet, consectetur adipisici elit,
                <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                <br>Ut enim ad minim veniam, quis nostrud</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="bg-faded p-y-0 section">
    <div class="container-fluid"></div>
  </div>
  <div class="section" draggable="true">
    <div class="container-fluid"></div>
  </div>
 <script type="text/javascript" src="/bysj/js/jquery-2.2.4.min.js"></script>
  <script type="text/javascript" src="/bysj/js/bootstrap.js"></script>
	<script src="/bysj/js/userHeadImg.js"></script>
	

</body>

</html>