 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<a:import url="/loadpage">
 <a:param name="type"  value="top"></a:param>
</a:import>


 <div class="container " style="margin:30px auto;min-height:500px">
    
    <div class="col-md-8 col-md-offset-3">
    
       <div class="col-md-2">
        请填写接收者:
       </div>
     <div class="col-md-5">
        <input type="text" class="form-control" id="txtUserName" placeholder="输入接收者用户名"/>
       </div>
    </div>


  <div class="col-md-8 col-md-offset-3" style="margin-top:20px">
    
       <div class="col-md-2">
        输入消息内容:
       </div>
     <div class="col-md-5">
        <textarea id="txtMsgContent" style="height:200px"class="form-control" placeholder="内容不要超过200字" ></textarea>
       </div>
    </div>
    
      <div class="col-md-8 col-md-offset-3" style="margin-top:20px">
    
       <div class="col-md-2  col-md-offset-3">
       <button id="sendBtn" class="btn btn-info">发送</button>
       </div>
 <script type="text/javascript">
 
 $("#sendBtn").click(function(){
	 var getUserName=$("#txtUserName").val();
	 var getMsgContent=$("#txtMsgContent").val();
		//alert(getUserName);
	 if(getUserName.replace(/(^\s+)|(\s+$)/g,"")=="" ||  getMsgContent.replace(/(^\s+)|(\s+$)/g,"")=="" ) 
	  {
	  alert("接收者和消息内容不能为空");
	  }
  else
{
	  $.post("/myweb/sendmsg",{"UserName":getUserName,"MsgContent":getMsgContent},function(result){
		  if(result=="0"){
			  alert("pls login");
		  }
		  else
			  {
			  alert("send ok");
			  }
	  })
	  }
 })
 </script>
    </div>
</div>

<a:import url="/loadpage">
 <a:param name="type"  value="bottom"></a:param>
</a:import>