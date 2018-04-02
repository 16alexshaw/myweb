<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<a:import url="/loadpage">
 <a:param name="type"  value="top"></a:param>
</a:import>
 
<style type="text/css">
#logintab td {
	text-align: center;
}
</style>
>

<body>
 <p style="color:red;text-align:center">${result}</p>
<div class="container">
	<form method="post" action="login" id="loginfrm">

    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>用户登录</h4>
            <input type="text" name="username" id="username" class="form-control input-sm chat-input" placeholder="用户名" />
            </br>
            <input type="password" name="userpsw" id="userpsw" class="form-control input-sm chat-input" placeholder="密码" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                <button type="submit" class="btn btn-primary btn-md">登录</button>
            </span>
            </div>
            </div>
        
        </div>
    </div>
    </form>
</div>




	
</body>
