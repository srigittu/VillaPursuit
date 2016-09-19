<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${sessionScope['userId'] == null}">
     <c:redirect url="welcome"/>
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Seller</title>
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
	position: fixed;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -700px;
	width: auto;
	height: auto;
	background-image: url(images/login.jpg);
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
	border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 200;
}

.ad table tr th {
	color: #00ffff;
	border: #fff;
	font-family: 'Exo', sans-serif;
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

.logout {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(96% - 50px);
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

.seller {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(86% - 50px);
	z-index: 2;
}

.seller input[type=submit]{
	width: 75px;
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

.ad input[type=submit] {
	width: 110px;
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
.home {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(80% - 50px);
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

.postAd {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(86% - 50px);
	z-index: 2;
}

.postAd input[type=submit] {
	width: 100px;
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

.editAddress input[type=submit]:hover {
	opacity: 0.6;
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

.logout input[type=submit]:hover {
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
 			<input type="submit" value="Post Ad">
 	    </form>
 	    </div>
 	    
 	    <div class="home">
		<form action="home">
 			<input type="submit" value="Home">
 	    </form>
 	    </div>
 	    
 	    <div class="logout">
			<form action="logout">
				<input type="submit" value="Logout">
			</form>
		</div>
		
 	    <div class="register">
		<c:if test="${addAddress != null}">
			<h2>Add<span>Address!</span></h2>
                <form:form action="user_address" commandName="address">
                <form:input path="number" placeholder="Number"/>
                <form:input path="street" placeholder="Street"/>
                <form:input path="city" placeholder="City"/>
                <form:input path="state" placeholder="State"/>
                <form:input path="pincode" placeholder="Pincode"/>
 			    <input type="submit" value="Save">
 			    </form:form>
		</c:if>
		</div>
		<c:if test="${sellerAdvertisements.size() == 0}">
		    <div class="message">
			<div>
				Post your First<span>Advertisement!!!</span>
			</div>
			<br>
			<button class="button" style="vertical-align: middle"
				onclick="window.location.href='advertisement_form'">
				<span>Click here</span>
			</button>
		</div>
		</c:if>
		<c:if test="${sellerAdvertisements.size() != 0}">
		    <div class="ad">
				<table>
					<tr>
						<th colspan="2">Pursuit Dream Villa</th>
						<th>Price</th>
						<th>Availability</th>
						<th>Posted On</th>
					</tr>
						<c:forEach var="advertisement" items="${sellerAdvertisements}">
							 <td>
							    <c:forEach var="image" items="${advertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="50px" height="50px"/>
									<br>
								</c:forEach>
						     </td>
						     <td>
							    <div class="maintitle"><c:out value="${advertisement.getTitle()}" /></div>
							    <div class="title"><c:out value="${'House Type: '}"/>
								<span><c:out value="${advertisement.getHouseType()}" /></span></div>
								<div class="title"><c:out value="${'Rent Type: '}"/>
								<span><c:out value="${advertisement.getRentType()}" /></span></div>
								<c:set value="${advertisement.getFacility()}" var="facility"/>
								<div class="title"><c:out value="${'Bedroom: '}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title"><c:out value="${'Area Size: '}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
                                <c:set value="${advertisement.getAddress()}" var="address"/>
                                <div class="title"><c:out value="${'Address: '}"/>
                                <span><c:out value="${address.getNumber()}"/>,
                                <c:out value="${address.getStreet()}"/>,<br>
                                <c:out value="${address.getCity()}"/>,
                                <c:out value="${address.getState()}"/>,
                                <c:out value="${address.getPincode()}"/>.</span>
                                </div>
                                <br>
							</td>
							<td>
							    <c:out value="${advertisement.getPrice()}" />
							</td>
							<td>
							    <c:out value="${advertisement.getAvailability()}" />
							</td>
							<td>
							    <c:out value="${advertisement.getDate()}" />
							</td>
							<tr>
							    <td colspan="5">
							        <div class="viewer"><c:out value="${'Viewer Details'}"/><br></div>
							    </td>
							</tr>
							<c:if test="${advertisement.getAdvertisementViewer().size() == 0}">
							<tr>
							    <td colspan="5">
							        <div class="emptyViewer"><c:out value="${'NO ONE VIEWED'}"/><br></div>
							    </td>
							</tr>
							</c:if>
							<c:forEach var="viewer" items="${advertisement.getAdvertisementViewer()}">
							<tr>
							    <td colspan="5">
                                    <div class="title">Name:<span><c:out value="${viewer.getFirstName()}"/>
                                    <c:out value="${viewer.getLastName()}"/></span></div>
                                    <div class="title">Mobile:<span><c:out value="${viewer.getMobileNumber()}"/></span></div>
                                    <div class="title">Email:<span><c:out value="${viewer.getEmail()}"/></span></div>
							    </td>
							</tr>
							</c:forEach>
							<tr>
						        <td colspan="5">
							        <div class="viewer"><c:out value="${'Buyer Reviews'}"/><br></div>
							    </td>
		         		    </tr>
		         		    <tr>
						        <td colspan="3">
							        <div class="viewer"><c:out value="${'Comments'}"/><br></div>
							    </td>
							    <td colspan="2">
							        <div class="viewer"><c:out value="${'Ratings'}"/><br></div>
							    </td>
		         		    </tr>
		         		    <c:if test="${advertisement.getAdvertisementReviews().size() == 0}">
							<tr>
							    <td colspan="5">
							        <div class="emptyViewer"><c:out value="${'NOT YET REVIEWED'}"/><br></div>
							    </td>
							</tr>
							</c:if>
		         		    <c:forEach var="review" items="${advertisement.getAdvertisementReviews()}">
							<tr>
							    <td colspan="3">
							    <c:out value="${review.getComment()}"/>
							    </td>
							    <td colspan="2">
							    <c:out value="${review.getRating()}"/>
							    </td>
						    </tr>
						    </c:forEach>
						    <tr>
						    <td colspan="5"><c:out value="${'***************************************************************************************'}"/></td>
							</tr>
				    </c:forEach>
				</table>
		    </div>
		</c:if>

</body>
</html>
