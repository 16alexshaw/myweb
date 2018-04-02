 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<a:import url="/loadpage">
 <a:param name="type"  value="top"></a:param>
</a:import>



 <div class="container " style="margin:30px auto">
    
     <div class="col-md-8 col-md-offset-2">
      <table class="table table-striped">
   <caption><a href="/myweb/msglist">我的未读消息</a>  |  我的已读消息</caption>
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
            <td>${msg.getMsgcnt()}</td>
            <td>${msg.getSendtime() }</td>
            <td>${msg.getSender() }</td>
           </tr>
        </a:forEach>
       
   </tbody>
 
</table>
     </div>
     
   
     
 
    </div>




<a:import url="/loadpage">
 <a:param name="type"  value="bottom"></a:param>
</a:import>