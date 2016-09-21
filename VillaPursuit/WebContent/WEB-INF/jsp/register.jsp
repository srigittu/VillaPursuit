<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VillaPurusit Register</title>
</head>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);
@import url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);
body{
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image: url(images/city-road.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
    -moz-filter: blur(5px);
    -o-filter: blur(5px);
    -ms-filter: blur(5px);
    filter: blur(5px);
	z-index: 0;
}

.body span{
    color: #00ffff
}

.grad{
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: #000;
    opacity: 0.2;
	z-index: 1;
	
}

.header{
	position: absolute;
	top: calc(10% - 35px);
	left: calc(25% - 255px);
	z-index: 2;
}

.header div{
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span{
	color: #00ffff !important;
}

.message {
	position: absolute;
	top: calc(30% - 35px);
	left: calc(25% - 255px);
	z-index: 2;
}

.message div {
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 400;
}

.message div span {
	color: #00ffff !important;
}

.message button {
	width: 130px;
	height: 35px;
	background: #fff;
	opacity: 0.4;
	border: 1px solid #010;
	cursor: pointer;
	border-radius: 75px;
	color: #0fffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 2px;
	margin-top: 10px;
}

.message button:hover {
	opacity: 0.6;
}

.register{
	position: absolute;
	top: calc(33% - 75px);
	left: calc(67% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 14px;
	font-weight: 400;
	z-index: 2;
}

.register span{
    color: #00ffff
}

.register h2{
    float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.register h2 span{
    color: #00ffff
}

.register input[type=text]{
	width: 250px;
	height: 30px;
	background: #000;
	opacity: 0.5;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #00ffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 500;
	padding: 4px;
}

.register input[type=password]{
	width: 250px;
	height: 30px;
	background: #000;
	opacity: 0.5;
	border: 1px solid rgba(255,255,255,0.6);
	border-radius: 2px;
	color: #00ffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 500;
	padding: 4px;
}

.register input[type=submit]{
	width: 260px;
	height: 35px;
	background: #000;
    opacity: 0.4;
	border: 1px solid #010;
	cursor: pointer;
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.register input[type=radiobutton]{
	width: 15px;
	height: 15px;
	background: #000;
    opacity: 0.4;
	border: 1px solid #010;
	cursor: pointer;
	border-radius: 15px;
	color: #00ffff;
	padding: 6px;
}

.register input[type=submit]:hover{
	opacity: 0.6;
}

.register input[type=text]:hover{
	opacity: 0.6;
}

.register input[type=password]:hover{
	opacity: 0.6;
}

.register input[type=button]:active{
	opacity: 0.6;
}

.register input[type=text]:active{
	opacity: 0.6;
}

.register input[type=text]:focus{
	outline:
	border: 1px solid rgba(255,255,255,0.9);
}

.register input[type=password]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

.register input[type=submit]:focus{
	outline: none;
	border: 1px solid rgba(255,255,255,0.9);
}

::-webkit-input-placeholder{
     color: #fff;
}

::-moz-input-placeholder{
     color: #fff;
}
</style>

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