<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>myweb news</title>
</head>
<body>
	<%-- hhhh
<%
String hi=request.getAttribute("hello").toString();
response.getWriter().write(hi);
${hello}
%> --%>
	<div style="width: 100%; height: 95px; border-bottom: soild 1px gray">
		${top_nav}</div>
	<div>

		<c:forEach items="${the_news}" var="newstitle">
${newstitle}
</c:forEach>
		<hr />
		<c:forEach items="${the_news2}" var="news">
			<a href="#">${news.newstitle}</a>
			<br />
		</c:forEach>

	</div>
	<div>
		<c:forEach items="${newsList}" var="news">
			<a href="/news/${news.newsid}">${news.newstitle}</a>
			<br />
		</c:forEach>
	</div>
	<div>
		<c:forEach items="${userlist}" var="user">
${user.username } <br />
		</c:forEach>
	</div>
	<div>${pagebar}</div>
	<div
		style="width: 100%; height: 95px; border-bottom: soild 1px gray; margin-top: 300px">
		${bottom_bar} &copy;2014 程序员在囧途</div>
</body>
</html>