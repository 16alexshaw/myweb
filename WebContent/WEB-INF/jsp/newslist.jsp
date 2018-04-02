 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<a:import url="/loadpage">
 <a:param name="type"  value="top"></a:param>
</a:import>
 

 <div class="container " style="margin:30px auto">
    
   			<div class="col-md-9 ">
    
     <a:forEach items="${newslist}" var="news">
   
   <div class="panel panel-default">
					 <div class="panel-heading" >
					      <h3 class="panel-title" >
					<a href="/myweb/newsdetail?newsid=${news.getId()}">${news.getNews_title() }</a>
					      </h3>
		  		 </div>
				   <div class="panel-body">
				       ${news.getNews_content() }
				   </div>
		   		<div class="panel-footer">发布:${news.getPubtime() }   作者:${news.getPubuser() }   阅读:${news.getClicknum() }</div>
			</div>
   
   </a:forEach>
  <a:import url="/pagination">
 <a:param name="sum"  value="${sum}"></a:param>
 <a:param name="cp"  value="${page}"></a:param>
 <a:param name="max"  value="10"></a:param>
 <a:param name="size"  value="${size}"></a:param>
  <a:param name="url"  value="/myweb/newslist"></a:param>
</a:import>
 

    
   	 
    
   		</div>
   		<div class="col-md-3  ">
   			<div class="list-group">
		      <span class="list-group-item">
			   <span class="btn  "><span class="glyphicon   glyphicon-heart"></span> </span> <a href="#"  style="font-size: 12pt;color: #222;">最热新闻</a>
			  </span>
			  
			   <ul class="nav list-group-item">
			   <li  ><a href="/my"  >最热新闻1</a></li>
			     <li  ><a href="/my"  >最热新闻2</a></li>
			       <li  ><a href="/my"  >最热新闻3</a></li>
			         <li  ><a href="/my"  >最热新闻4</a></li>
			   </ul>
			</div>
   		</div>
   
  
   </div>

<a:import url="/loadpage">
 <a:param name="type"  value="bottom"></a:param>
</a:import>