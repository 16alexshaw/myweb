<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myweb Home</title>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
abc();
function getmsg() {
	setTimeout("abc()",3000);
	
}
function abc() {
	$.post("/myweb/getmsg",{},function(t){
		alert(t);
		getmsg();
		
		});
}

</script>

</head>
<body>
<%-- hhhh
<%
String hi=request.getAttribute("hello").toString();
response.getWriter().write(hi);
${hello}
%> --%>
<div style="width:100%;height: 95px;border-bottom: soild 1px gray">
${top_nav} <a href="/unlog">注销登录</a>
</div>${result}
<div>

</div>
<div>
content
</div>
<div style="width:100%;height: 95px;border-bottom: soild 1px gray;margin-top: 300px">
${bottom_bar}  &copy;2014 程序员在囧途
</div>
</body>
</html>