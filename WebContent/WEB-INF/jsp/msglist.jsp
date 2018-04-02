 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<a:import url="/loadpage">
 <a:param name="type"  value="top"></a:param>
</a:import>
<script>
var userName='{CurrentUserName}';
 function setMsgState(sender,sendtime,msgcnt,aobj)
 {
	 if(userName=='') return ;
	 
	  $.post("/myweb/addmsg",{"sender":sender,"receiver":userName,"sendtime":sendtime,"msgcnt":msgcnt},function(result){
		  
	     if(result.toString()=="1")
	    	 {
	    	   //记录成功
	    	  $(aobj).parent().parent().remove();
	    	// alert("success");
	    	 }
	     else
	    	 {
	    	   alert("操作失败");
	    	 }
	  });
 }

</script>



 <div class="container " style="margin:30px auto">
    
     <div class="col-md-8 col-md-offset-2">
      <table class="table table-striped">
   <caption>我的未读消息 | <a href="/myweb/msglist2">我的已读消息</a></caption>
   <thead>
      <tr>
         <th>消息内容</th>
         <th>发送时间</th>
         <th>发送者</th>
      </tr>
   </thead>
   <tbody>
        <a:forEach items="${msglist}" var="msg">
           <tr>
            <td>${msg.split("_")[2] }</td>
            <td>${msg.split("_")[0] }</td>
            <td>${msg.split("_")[1] }</td>
            <td><a href="#"  onclick="setMsgState('${msg.split("_")[1] }','${msg.split("_")[0] }','${msg.split("_")[2] }',this);return false;">设置为已读</a></td>
           
           </tr>
        </a:forEach>
       
   </tbody>
   <tr>
    <td colspan="3">
     <a:import url="/pagination">
		 <a:param name="sum"  value="${sum }"></a:param>
		 <a:param name="cp"  value="${page}"></a:param>
		 <a:param name="max"  value="10"></a:param>
		 <a:param name="size"  value="10"></a:param>
		  <a:param name="url"  value="/myweb/msglist"></a:param>
		</a:import>
    </td>
   </tr>
</table>
     </div>
     
   
     
 
    </div>




<a:import url="/loadpage">
 <a:param name="type"  value="bottom"></a:param>
</a:import>