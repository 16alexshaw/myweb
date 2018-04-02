   <script>
   $(document).ready(function(){
	   
var newsid=${newsid};
var page=1;
var pagesize=5;
	 var newstype=${newstype};
	   $("#cmdReview").click(function(){
		   var getReivewCnt=$("#txtReview").val();
		   if(getReivewCnt.trim()=="")
			   {
			     alert("评论内容不能为空");
			   }
		   else
			   {
			   var btn=$(this).button("loading");
			      $.post("/myweb/addreview",{"rcnt":getReivewCnt,"newsid":newsid},function(result){
			    	  btn.button('reset');
			    	  if(result=="unlogin")
			    		  {
			    		    alert("请先登录后评论");
			    		  }
			    	  else if(result=="1")
			    		  {
			    		      alert("评论增加成功");
			    		  }
			      });
			   }
		
	   });
	   function loadReview(btn)
	   {
		   $.post("/myweb/loadreview",{"newsid":newsid,"newstype":newstype,"page":page,"pagesize":pagesize,"isload":1},function(result){
				page++;
				if(btn!=null)  
					{
				
					 btn.button('reset');
					}
			  		alert(result);
			   var getReview=eval("("+result+")");
			   //alert(getReview);
			   if(getReview.length>0) //说明有评论 
				   {
				     var tplHtml=$("#reviewTpl").prop("outerHTML");
				    alert(tplHtml);// display:none
				        tplHtml = tplHtml.replace('id="reviewTpl"',"");
				        tplHtml = tplHtml.replace('display:none',"");
				      for(var i=0;i<getReview.length;i++)
				    	  {
				    	  //id="reviewTpl"
				    	       var newHtml=tplHtml.replace("{reviewtime}",getReview[i].addtime);
				    	       newHtml=newHtml.replace("{reviewcontent}",getReview[i].rcnt);
				    	  $("#reviewList").append(newHtml)
				    	       
				    	  }
				   }
			   else
				   {
				     alert("后面没有更多评论了");
				   }
		   });
	   }
	   $("#cmdLoadReview").click(function(){
		   var btn=$(this).button("loading");
		   loadReview(btn);
	   });
	    // loadReview(null);

   })
  </script>
 
  <div class="panel panel-default">
						 <div class="panel-heading" >
						      <h3 class="panel-title" >
						     用户评论
						      </h3>
			  		 </div>
					   <div class="panel-body"  >
					      <div class="row clearfix"> <!-- 发表评论 -->
								<div class="col-md-12 column">
										<div class="form-group">
											<textarea id="txtReview" class="form-control" rows="5" autocomplete="off"></textarea>
										</div>
									  <button id="cmdReview" autocomplete="off" data-loading-text="正在提交" type="button" class="btn btn-success">提交</button>
								</div>
						</div>	
						      <div class="row clearfix col-md-11" style="margin-top:5px;display:none"  id="reviewTpl">	<!-- 评论列表 -->
						       <div class="panel panel-default ">
								        <div class="panel-heading" >
								      <h3 class="panel-title" >
								     用户名 发表时间：{reviewtime}
								      </h3>
					  		 </div>
						       			   <div class="panel-body"  >
						       			         <div class="col-md-9">{reviewcontent}</div>
						       			   </div>
						       </div>
						      </div>
					   
						<div class="row clearfix col-md-11" style="margin-top:5px">
					        <button id="cmdLoadReview" autocomplete="off"  class="btn btn-default col-md-12" data-loading-text="正在加载...">加载更多评论</button>
					      </div>
						
						
					   </div>
			   		 
				</div>