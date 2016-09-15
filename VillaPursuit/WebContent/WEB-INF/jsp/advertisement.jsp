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
.ad {
	position: absolute;
	top: calc(30% - 35px);
	left: calc(35% - 255px);
	z-index: 2;
}

.ad table {
	width: 300px border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 24px;
	font-weight: 100;
}

.ad table tr {
	color: #fff;
	border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 200;
}

.ad table tr th {
	color: #00ffff;
	border: #fff;
	width: 800px font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 200;
	padding: 6px;
}

.ad table tr td {
	color: #fff;
	border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 18px;
	font-weight: 200;
	padding: 6px;
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

.logout {
    float: right;
    width: 20%;
    height:20%;
    position: absolute;
	top: calc(14% - 75px);
	left: calc(93% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}
a {
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
	margin-top: 40px;
}
p, a span {
    color: #000;
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
 	    <div class="ad">
 	        <div class="logout">
                <a href="logout">Logout</a>
            </div>
		<c:if test="${advertisement != null}">
		    <table>
					<tr>
						<th colspan="4">Enter Villa Details</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
                <form:form name="advertisement" action="add_advertisement" modelAttribute="advertisement" >
                    <tr>
                    <td>
                    <form:input path="images[0].imagePath" placeholder="images"/><br>
                    <form:input path="images[1].imagePath" placeholder="images"/><br>
                    </td>
                    
                    <td>
                    <form:input path="title" placeholder="Title"/><br>
                    <form:input path="status" type="hidden" value="active"/><br>
                    <form:input path="availability" placeholder="Availability"/><br>
 			            <form:select path="houseType">
                            <form:option value="Individual" label="Individual" />
                            <form:option value="Appartment" label="Appartment" />
                        </form:select><br>
                        <form:select path="rentType">
                            <form:option value="Rent" label="Rent" />
                            <form:option value="Lease" label="Lease" />
                        </form:select><br>
                    </td>
                    
                    <td>
                    <form:checkbox path="facility.parking"/>Parking<br>
                    <form:checkbox path="facility.drainage"/>Drainage<br>
                    <form:checkbox path="facility.transport"/>Transport<br>
                        <form:select path="facility.bedroom">
                            <form:option value="NONE" label="--- Bedroom ---"/>
                            <form:option value="1BHK" label="--- 1BHK ---" />
                            <form:option value="2BHK" label="--- 2BHK ---" />
                            <form:option value="3BHK" label="--- 3BHK ---" />
                        </form:select><br>
                        <form:input path="facility.area" placeholder="Area-Size"/><br>
 			        </td>
 			        
 			        <td>
                    <form:input path="address.number" placeholder="Number"/><br>
                    <form:input path="address.street" placeholder="Street"/><br>
                    <form:input path="address.city" placeholder="City"/><br>
                    <form:input path="address.state" placeholder="State"/><br>
                    <form:input path="address.pincode" placeholder="Pincode"/><br>
 			        <input type="submit" value="Post">
 			        </td>
 			        </tr>
 			     </form:form>
 			</table>
		</c:if>
		</div>

</body>
</html>