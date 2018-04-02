
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<a:import url="/loadpage">
	<a:param name="type" value="top"></a:param>
</a:import>

<div class="container" style="margin-top: 30px">
	<div class="col-md-9">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">${NewsDetail.getNews_title() }</h3>
			</div>
			<div class="panel-body" style="min-height: 500px; _height: 500px">
				${NewsDetail.getNews_content() }</div>
			<div class="panel-footer">发布:${NewsDetail.getPubtime() }
				作者:${NewsDetail.getPubuser() } 阅读:${newsClickNum}</div>
		</div>
		 <!-- 评论功能 -->  
				<a:import url="/loadreview"> 
 					 <a:param name="newsid"  value="${newsid }"></a:param>
 					<a:param name="newstype"  value="1"></a:param>
		</a:import> 
	

		<div class="col-md-3">
			<div class="list-group">
				<span class="list-group-item"> <span class="btn  "><span
						class="glyphicon   glyphicon-heart"></span> </span> <a href="#"
					style="font-size: 12pt; color: #222;">最热新闻</a>
				</span>

				<ul class="nav list-group-item">
					<li><a href="/my">最热新闻1</a></li>
					<li><a href="/my">最热新闻2</a></li>
					<li><a href="/my">最热新闻3</a></li>
					<li><a href="/my">最热新闻4</a></li>
				</ul>
			</div>

		</div>

	</div>






	<a:import url="/loadpage">
		<a:param name="type" value="bottom"></a:param>
	</a:import>