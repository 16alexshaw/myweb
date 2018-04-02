<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"  href="bootstrap/css/bootstrap.min.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="container"  >
     <div class="form-horizontal"> 
    
    <h1>测试界面</h1>
     <div class="col-md-8 form-group">
     
     <label class="col-md-3 control-label ">username</label>
      <div class="col-md-5">
      <input type="text" class="form-control " placeholder="请输入关键字"/>
     </div>
      </div>
         <div class="col-md-8 form-group">
          <label class="col-md-3 control-label "></label>
            <div class="col-md-5">
     <input type="button" class="btn btn-success" value="submit"/>
      </div>
    </div>
    
    </div>
    </div>
</body>

</div>
</div>








<%-- <div>

<c:forEach items="${alluser}" var="user">
${user.username } <br />
		</c:forEach>
</div>
<div>
${pwd}
</div> --%>
</body>
</html>