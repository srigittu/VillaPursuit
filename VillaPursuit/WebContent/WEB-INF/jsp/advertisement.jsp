<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
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

.register{
	position: absolute;
	top: calc(20% - 75px);
	left: calc(15% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 14px;
	font-weight: 400;
	z-index: 2;
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
	width: 127px;
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

.editAddress{
	position: absolute;
	top: calc(14% - 75px);
	left: calc(93% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.editAddress input[type=submit]{
	width: 100px;
	height: 35px;
	background: #000;
    opacity: 0.4;
	border: 1px solid #010;
	cursor: pointer;
	border-radius: 2px;
	color: #0fffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 2px;
	margin-top: 10px;
}

.postAd{
	position: absolute;
	top: calc(14% - 75px);
	left: calc(93% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.postAd input[type=submit]{
	width: 115px;
	height: 35px;
	background: #000;
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
	outline: none;
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

<body>

    <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
		</div>
		<br>
 	    <div class="postAd">
		<form action="advertisement_form">
 			<input type="submit" value="Post Ad Again">
 	    </form>
 	    </div>
 	    <div class="register">
 	    
		<c:if test="${advertisement != null}">
			<h2>Enter<span>Villa Detail!</span></h2>
                <form:form name="advertisement" action="addAdvertisement" modelAttribute="advertisement" >
                    <form:input path="title" placeholder="Title"/>
                    <form:input path="status" type="hidden" value="active"/>
                    <form:input path="availability" placeholder="Availability"/>
 			            <form:select path="houseType">
                            <form:option value="Individual" label="Individual" />
                            <form:option value="Appartment" label="Appartment" />
                        </form:select>
                        <form:select path="rentType">
                            <form:option value="Rent" label="Rent" />
                            <form:option value="Lease" label="Lease" />
                        </form:select><br><br>
                
                    <form:input path="images[0].imagePath" placeholder="images"/>
                    <form:input path="images[1].imagePath" placeholder="images"/>
                <br><br>
                
                    <form:checkbox path="facility.parking"/>Parking<td />
                    <form:checkbox path="facility.drainage"/>Drainage<td />
                    <form:checkbox path="facility.transport"/>Transport<br>
                        <form:select path="facility.bedroom">
                            <form:option value="0" label="--- Bedroom ---"/>
                            <form:option value="1" label="--- 1BHK ---" />
                            <form:option value="2" label="--- 2BHK ---" />
                            <form:option value="3" label="--- 3BHK ---" />
                        </form:select><br>
                        <form:input path="facility.area" placeholder="Area-Size"/><br><br>
 			    
                    <form:input path="address.number" placeholder="Number"/>
                    <form:input path="address.street" placeholder="Street"/>
                    <form:input path="address.city" placeholder="City"/>
                    <form:input path="address.state" placeholder="State"/>
                    <form:input path="address.pincode" placeholder="Pincode"/>
 			    <input type="submit" value="Post">
 			</form:form>
		</c:if>
		</div>

</body>
</html>