 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html> 
<html>
<head>

 <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
  <script src="bootstrap/js/jquery.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
.msg{background: background: yellow;url(/myweb/images/hd.png) no-repeat right top}
</style>
 </head>
 <body>
   <nav class="nav navbar-inverse  " style="filter:alpha(Opacity=90);-moz-opacity:0.9;opacity: 0.9" role="navigation">
   	<div class="container">
	   		<div class="navbar-header">
	   	     <a href="#" class="navbar-brand">
	   	         <strong>程序员在囧途</strong>
	   	     </a>
	   		</div>
	
		   	<ul class="nav navbar-nav">
		   			<li class="active"><a href="#">首页</a></li>
		   			<li><a href="#">新闻</a></li>
		   			<li><a href="#">观点</a></li>
		   			<li><a href="#">科技</a></li>
		   	</ul>
	   		<div class="navbar-form navbar-right">
	   			<div class="form-group">	
		   			<div class="input-group">
		   				<input type="text" class="form-control" placeholder="请输入文章关键字"  />
		   				<div class="input-group-btn">
		   					<button class="btn btn-block"><span class="glyphicon glyphicon-search"></span></button>
		   				</div>
		   			</div>	
	   			</div>
	   			<div class="form-group" style="padding-left: 10px; margin: 0px 12px;">
	   			
	   			<a:if test="${UserName==null}">
	   			<a href="/myweb/login" style="color: #D2D2D2;">登录</a>
		   			<span  style="color: #D2D2D2;padding-left: 5px;">|</span>
		   			<a href="#" style="color: #D2D2D2;padding-left: 5px;">注册</a>
	   			</a:if>
		   			<a:if test="${UserName!=null}">
		   		<div id="msgAlert" class="form-group">
		   			welcome:<a href="/myweb/msglist">${UserName}</a></div><span  style="color: #D2D2D2;padding-left: 5px;">|</span>
		   			<a href="/myweb/unlog" style="color: #D2D2D2; padding-left: 5px;">退出</a>
	   			
		   		</a:if>
		   			
		   				</div>
	   		</div>	
   	  </div>
   </nav> 