<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${role == null }">
    <c:redirect url="welcome"/>
</c:if>
<title>Home Buyer</title>
</head>
<style>
@import url(http://fonts.googleapis.com/css?family=Exo:100,200,400);

@import	url(http://fonts.googleapis.com/css?family=Source+Sans+Pro:700,400,300);

body {
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body {
	position: fixed;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -200px;
	width: auto;
	height: auto;
	background-image: url(images/background.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	-moz-filter: blur(5px);
	-o-filter: blur(5px);
	-ms-filter: blur(5px);
	filter: blur(5px);
	z-index: 0;
}

.grad {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	
	z-index: 1;
}

.header {
	position: absolute;
	top: calc(10% - 35px);
	left: calc(25% - 255px);
	z-index: 2;
}

.header div {
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span {
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

.home {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(74% - 50px);
	z-index: 2;
}

.home input[type=submit] {
	width: 75px;
	height: 35px;
	background: #000;
	opacity: 0.5;
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

.home input[type=submit]:hover {
	opacity: 0.6;
}

.user {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(84% - 50px);
	z-index: 2;
}

.user input[type=submit] {
	width: 75px;
	height: 35px;
	background: #000;
	opacity: 0.5;
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

.user input[type=submit]:hover {
	opacity: 0.6;
}

.ad {
	position: absolute;
	top: calc(25% - 35px);
	left: calc(37% - 255px);
	z-index: 2;
}

.ad table {
	font-family: 'Exo', sans-serif;
	font-size: 24px;
	font-weight: 100;
	border-collapse: collapse;
}

.ad table tr {
	background: #000;
	opacity: 0.8;
	font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 200;
}

.ad table tr th {
	color: #00ffff;
	font-family: 'Exo', sans-serif;
	font-size: 22px;
	font-weight: 200;
	padding: 6px;
}

.ad table tr td {
	color: #fff;
	border-bottom: 1px solid #ddd;
	font-family: 'Exo', sans-serif;
	font-size: 18px;
	font-weight: 200;
	padding: 6px;
}

.hoverTable{
    width:100%; 
	border-collapse:collapse; 
}
.hoverTable td{ 
	padding:7px; border:#4e95f4 1px solid;
}
.hoverTable tr{
	background: #b8d1f3;
}
.hoverTable tr:hover {
    background-color: #545858;
}
.ad input[type=submit] {
	width: 110px;
	height: 35px;
	background: #fff;
	border: 1px solid #010;
	cursor: pointer;
	border-radius: 75px;
	color: #0dded5;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 2px;
	margin-top: 10px;
}

.ad input[type=submit]:hover {
	opacity: 0.6;
}

.viewer {
    color: #00ffff;
	border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 22px;
	font-weight: 200;
	padding: 6px;
}

.emptyViewer {
    color: #fff;
	border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 18px;
	font-weight: 200;
	padding: 20px;
}

.register {
	position: absolute;
	top: calc(33% - 75px);
	left: calc(67% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.register h2 {
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.register h2 span {
	color: #00ffff
}

.register input[type=text] {
	width: 250px;
	height: 30px;
	background: #000;
	opacity: 0.5;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #00ffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 500;
	padding: 4px;
}

.register input[type=password] {
	width: 250px;
	height: 30px;
	background: #000;
	opacity: 0.5;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #00ffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 500;
	padding: 4px;
}

.register input[type=submit] {
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

.register input[type=submit]:hover {
	opacity: 0.6;
}

.register input[type=text]:hover {
	opacity: 0.6;
}

.register input[type=password]:hover {
	opacity: 0.6;
}

.register input[type=button]:active {
	opacity: 0.6;
}

.register input[type=text]:active {
	opacity: 0.6;
}

.register input[type=text]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.register input[type=password]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.register input[type=submit]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.seller {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(90% - 50px);
	z-index: 2;
}

.seller input[type=submit] {
	width: 75px;
	height: 35px;
	background: #000;
	opacity: 0.5;
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

.seller input[type=submit]:hover {
	opacity: 0.6;
}

.user {
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 50px);
	z-index: 2;
}

.user input[type=submit] {
	width: 200px;
	height: 35px;
	background: #000;
	opacity: 0.5;
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

.user input[type=submit]:hover {
	opacity: 0.6;
}

.adv {
	position: absolute;
	top: calc(60% - 75px);
	left: calc(50% - 50px);
	z-index: 2;
}

.adv input[type=submit] {
	width: 200px;
	height: 35px;
	background: #000;
	opacity: 0.5;
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

.adv input[type=submit]:hover {
	opacity: 0.6;
}

.logout {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(98% - 50px);
	z-index: 2;
}

.logout input[type=submit] {
	width: 75px;
	height: 35px;
	background: #000;
	opacity: 0.5;
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
.logout input[type=submit]:hover {
	opacity: 0.6;
}

::-webkit-input-placeholder {
	color: #fff;
}

::-moz-input-placeholder {
	color: #fff;
}
.title{
    font-family: 'Exo', sans-serif;
	font-size: 16px;
	color: #0dded5;
}
.maintitle{
    font-family: 'Exo', sans-serif;
	font-size: 25px;
	color: #0dded5;
}

.maintitle span {
	color: #fff;
}

.title span {
	color: #fff;
}
</style>

<body>

    <div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Villa<span>Pursuit</span>
		</div>
	</div>
	<br>
	<c:if test="${deletionSuccessMessage != null}">
		<script>
		   window.alert("<c:out value="${deletionSuccessMessage}"/>");
		</script>
	</c:if>
	<c:if test="${updationSuccessMessage != null}">
		<script>
		   window.alert("<c:out value="${updationSuccessMessage}"/>");
		</script>
	</c:if>
    <div class="logout">
	    <form action="logout">
			<input type="submit" value="Logout">
		</form>
	</div>
	<div class="seller">
		<form action="admin">
			<input type="submit" value="Home">
		</form>
	</div>
	<c:if test="${users == null}">
	<c:if test="${advertisements == null}">
    <div class="user">
		<form action="user_admin">
		    <input type="submit" value="User Operations">
	    </form>
	</div>
	<div class="adv">
		<form action="ad_admin">
		    <input type="submit" value="Advertisement Operations">
	    </form>
	</div>
	</c:if>
	</c:if>
	<c:if test="${users != null}">
 	    <div class="ad">
	        <table class="hoverTable">
			    <tr>
				    <th>User Name</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Mobile Number</th>
					<th>Email</th>
					<th>Role</th>
					<th>User Operations</th>
					</tr>
				    <c:forEach var="user" items="${users}">
				        <tr>
						    <td>
							    <c:out value="${user.getUserName()}" />
							</td>
							<td>
							    <c:out value="${user.getFirstName()}" />
							</td>
							<td>
							    <c:out value="${user.getLastName()}" />
							</td>
							<td>
							    <c:out value="${user.getMobileNumber()}" />
							</td>
							<td>
							    <c:out value="${user.getEmail()}" />
							</td>
							<td>
							    <c:out value="${user.getRole()}" />
							</td>
							<td>
							<form action="delete_user">
							   <input type="hidden" value="${user.getId()}" name="userId">
							   <input type="submit" value="Delete User"> 
							</form>
							</td>
						</tr>
						</c:forEach>
				</table>
		     </div>
		</c:if>
		<c:if test="${advertisements == null}">
		    <c:out value= "${'No Recent Advertisements'}"/>
		</c:if>
		<c:if test="${advertisements != null}">
 	        <div class="ad">
				<table class="hoverTable">
					<tr>
					    <th>Images</th>
						<th>Villa</th>
						<th>Price</th>
						<th>Availability</th>
						<th>Posted On</th>
					</tr>
				    <c:forEach var="advertisement" items="${advertisements}">
						     <tr>
							 <td>
							   <c:if test="${advertisement.getImages() == null }">
							       <c:out value= "${'No image For This Ad'}"/>
							   </c:if>
							   <c:if test="${advertisement.getImages() != null }">
							       <c:forEach var="image"
								       items="${advertisement.getImages()}">
									   <img src="upload/<c:out value="${image.getImagePath()}"/>" width="50px" height="50px"/>
									   <br>
								    </c:forEach>
								</c:if>
						     </td>
						     <td>
							    <div class="maintitle"><c:out value="${advertisement.getTitle()}" /></div>
							    <div class="title"><c:out value="${'House Type: '}"/>
								<span><c:out value="${advertisement.getHouseType()}" /></span></div>
								<div class="title"><c:out value="${'Rent Type: '}"/>
								<span><c:out value="${advertisement.getRentType()}" /></span></div>
								<c:set value="${advertisement.getFacility()}" var="facility"/>
								<div class="title"><c:out value="${'Bed Rooms: '}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title"><c:out value="${'Area: '}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
							</td>
							<td>
							 <c:out value="${advertisement.getPrice()}" />
							</td>
							<td>
							    <c:out value="${advertisement.getAvailability()}" />
							</td>
							<td>
							    <c:out value="${advertisement.getDate()}" /><br>
							</td>
							<td>
							<form action="update_status">
							   <input type="hidden" value="${advertisement.getAdvertisementId()}" name="advertisementId">
							   <input type="submit" value="Approve"> 
							</form>
							</td>
							</tr>
						</c:forEach>
				</table>
		     </div>
		</c:if>
</body>
</html>
