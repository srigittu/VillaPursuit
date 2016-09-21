<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${role != null }">
    <c:redirect url="home"/>
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VillaPurusit Login</title>
</head>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>

  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
		</div>
		<br>
		<c:if test="${loginMessage != null}">
		<script>
		   window.alert("<c:out value="${loginMessage}"/>");
		</script>
		</c:if>
		<div class="login">
		        <h2>Log<span>in!</span></h2>
				<form action="login" method="post">
				<input type="text" placeholder="username" name="userName" required="required"><br>
				<input type="password" placeholder="password" name="password" required="required"><br>
 				<input type="submit" value="Login">
 				</form>
		</div>
		<div class="register">
        <form action="register_form">
            <input type="submit" value="Register">
        </form>
        </div>
</body>
</html>