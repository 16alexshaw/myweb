<script type="text/javascript">
<!--

//-->
$(document).ready(function(){
	 $("#msgAlert").addClass("msg");
 
	//消息循环
	 function getMsgAlert(){
		 
	 
	 $.post("/myweb/getmsg",null,function(result){
		 if(result!=null){
			 if(result=="0")
				 {
				 $("#msgAlert").removeClass("msg");

				 setTimeout("getMsgAlert()",5000);
				 }
			 else if(result=="1")
				 {
				 $("#msgAlert").addClass("msg");
				 }
			 else
				 {
				 $("#msgAlert").removeClass("msg");

				 }
		 }
	 });
	 }
	 getMsgAlert();
})
</script>
  
 尾巴
</body>
</html>