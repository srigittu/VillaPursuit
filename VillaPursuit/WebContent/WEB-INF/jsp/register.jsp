<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VillaPurusit Register</title>
<link rel="stylesheet" type="text/css" href="css/register.css">
</head>

<body>
  
  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
		</div>
		<br>
		<c:if test="${userAddMessage == null}">
		<div class="register">
			<h2>Create<span>Account!</span></h2>
                <form:form action="register" commandName="user" name="myForm">
                <form:input path="firstName" placeholder="First Name" />
                <form:errors path="firstName"></form:errors>
                <form:input path="lastName" placeholder="Last Name" />
                <form:errors path="lastName"></form:errors>
                <form:input path="userName" placeholder="username" />
                <form:errors path="userName"></form:errors>
                <form:password path="password" placeholder="password" />
                <form:errors path="password"></form:errors>
                <form:input path="mobileNumber" placeholder="Mobile Number" />
                <form:errors path="mobileNumber"></form:errors>
                <form:input path="email" placeholder="Email Id" /><br>
                <form:errors path="email"></form:errors>
                <form:radiobutton path="role" value="buyer" />Buy<span>er</span>
                <form:errors path="role"></form:errors>
                <form:radiobutton path="role" value="seller" />Sell<span>er</span>
                <form:errors path="role"></form:errors>
 			    <input type="submit" value="Register" onclick="return validateForm()">
 			    </form:form>
		</div>
		</c:if>
		
		<c:if test="${userAddMessage != null}">
		
		<div class="message">
			<div>
				You are successfully<span>Registered!</span>Confirmation Mail has
				sent to <span>Your Account!!!</span>
			</div>
			<br>
			<button class="button" style="vertical-align: middle"
				onclick="window.location.href='welcome'">
				<span>Back to Login</span>
			</button>
		</div>
	    </c:if>
		
</body>

</html>