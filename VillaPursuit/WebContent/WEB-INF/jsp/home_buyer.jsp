<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
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
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -200px;
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

.grad {
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
}

.ad table tr {
	background: #000;
	opacity: 0.8;
	border: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 200;
}

.blank table tr {
	background: #000;
	opacity: 0.5;
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
	left: calc(80% - 50px);
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

.editAddress {
	position: absolute;
	top: calc(14% - 75px);
	left: calc(86% - 50px);
	z-index: 2;
}

.editAddress input[type=submit] {
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
	
	<c:if test="${userAddMessage == null}">
	<c:if test="${sessionScope['userId'] != null}">
		<c:if test="${role == null }">
            <c:redirect url="welcome"/>
        </c:if>
		<div class="logout">
			<form action="logout">
				<input type="submit" value="Logout">
			</form>
		</div>
		
		<div class="home">
		<form action="home">
 			<input type="submit" value="Home">
 	    </form>
 	    </div>
		
		<div class="editAddress">
			<form action="address_form">
				<input type="submit" value="Edit Address">
			</form>
		</div>
		
		<div class="register">
			<c:if test="${addAddress != null}">
				<h2>
					Add<span>Address!</span>
				</h2>
				<form:form action="user_address" commandName="address" required="required">
					<form:input path="number" placeholder="Number" required="required"/>
					<form:input path="street" placeholder="Street" required="required"/>
					<form:input path="city" placeholder="City" required="required"/>
					<form:input path="state" placeholder="State" required="required"/>
					<form:input path="pincode" placeholder="Pincode" required="required"/>
					<input type="submit" value="Save">
				</form:form>
			</c:if>
		</div>
		<div class="ad">

			<c:if test="${advertisements != null}">
				<table>
					<tr>
						<th colspan="2">Pursuit Dream Villa</th>
						<th>Price</th>
						<th>Availability</th>
						<th>Posted On</th>
					</tr>
						<c:forEach var="advertisement" items="${advertisements}">
						<tr>
							 <td>
							    <c:forEach var="image"
									items="${advertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="50px" height="50px"/>
									<br>
								</c:forEach>
						     </td>
						     <td>
							    <div class="maintitle"><c:out value="${advertisement.getTitle()}" /></div>
							    <div class="title"><c:out value="${'House Type:'}"/>
								<span><c:out value="${advertisement.getHouseType()}" /></span></div>
								<div class="title"><c:out value="${'Rent Type:'}"/>
								<span><c:out value="${advertisement.getRentType()}" /></span></div>
								<c:set value="${advertisement.getFacility()}" var="facility"/>
								<div class="title"><c:out value="${'Bed Rooms:'}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title"><c:out value="${'Area:'}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
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
							<c:set value="${advertisement.getUser()}" var="user"/>
							<c:if test="${user.getId() != sessionScope['userId']}">
							<tr>
							<td colspan="4">
							<form action="review_form">
						        <input type="hidden" value="${advertisement.getAdvertisementId()}" name="advertisementId">
						        <input type="submit" value="Add Review">
					        </form>
							</td>
							<td  colspan="3">
							    <form action="view_seller">
						            <input type="hidden" value="${advertisement.getAdvertisementId()}" name="advertisementId">
						            <input type="submit" value="view Contact">
					            </form>
					        </td>
							</tr>
							</c:if>
							</tr>
						    <tr class="blank">
						       
						    </tr> 
						</c:forEach>
				</table>
			</c:if>
		</div>
		
		<div class="ad">

			<c:if test="${addReview != null}">
				<table>
					<tr>
						<th colspan="2">Pursuit Dream Villa</th>
						<th>Price</th>
						<th>Availability</th>
						<th>Posted On</th>
						<th></th>
					</tr>
						<c:set var="advertisement" value="${reviewAdvertisement}"/>
						<tr>
							 <td>
							    <c:forEach var="image"
									items="${advertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="50px" height="50px"/>
									<br>
								</c:forEach>
						     </td>
						     <td>
							     <div class="maintitle"><c:out value="${advertisement.getTitle()}" /></div>
							    <div class="title"><c:out value="${'House Type:'}"/>
								<span><c:out value="${advertisement.getHouseType()}" /></span></div>
								<div class="title"><c:out value="${'Rent Type:'}"/>
								<span><c:out value="${advertisement.getRentType()}" /></span></div>
								<c:set value="${advertisement.getFacility()}" var="facility"/>
								<div class="title"><c:out value="${'Bed Rooms:'}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title"><c:out value="${'Area:'}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
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
							<td>
							<form:form action="add_review" commandName="review">
					        <form:input path="comment" placeholder="Comment" />
					        <form:select path="rating">
                            <form:option value="NONE" label="--- Rating ---"/>
                            <form:option value="1" label="--- * ---" />
                            <form:option value="2" label="--- ** ---" />
                            <form:option value="3" label="--- *** ---" />
                            <form:option value="4" label="--- **** ---" />
                            <form:option value="5" label="--- ***** ---" />
                            </form:select><br>
					        <input type="hidden" value="${advertisement.getAdvertisementId()}" name="advertisementId">
					        <input type="submit" value="Submit">
				            </form:form>
							</td>
							</tr>
				</table>
			</c:if>
		</div>
		<c:if test="${sessionScope['role'] == 'seller'}">
		<div class="seller">
			<form action="seller">
				<input type="submit" value="My Posts">
			</form>
		</div>
		</c:if>
		</c:if>
		</c:if>
		
		<c:if test="${viewSellerAdvertisement != null}">
		    <div class="ad">
				<table>
					<tr>
						<th colspan="2">Pursuit Dream Villa</th>
						<th>Availability</th>
						<th>Posted On</th>
					</tr>
					     <tr>
							 <td>
							    <c:forEach var="image" items="${viewSellerAdvertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="50px" height="50px"/>
									<br>
								</c:forEach>
						     </td>
						     <td>
							    <div class="maintitle"><c:out value="${viewSellerAdvertisement.getTitle()}" /></div>
							    <div class="title">Price:
							    <span><c:out value="${viewSellerAdvertisement.getPrice()}" /></span></div>
							    <div class="title">House Type:
								<span><c:out value="${viewSellerAdvertisement.getHouseType()}" /></span></div>
								<div class="title">Rent Type:
								<span><c:out value="${viewSellerAdvertisement.getRentType()}" /></span></div>
								<c:set value="${viewSellerAdvertisement.getFacility()}" var="facility"/>
								<div class="title">Bedrooms:
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title">Area:
                                <span><c:out value="${facility.getArea()}"/></span></div>
                                <c:set value="${viewSellerAdvertisement.getAddress()}" var="address"/>
                                <div class="title">Address:</div>
                                <c:out value="${address.getNumber()}"/>,
                                <c:out value="${address.getStreet()}"/>,
                                <c:out value="${address.getCity()}"/>,
                                <c:out value="${address.getState()}"/>,
                                <c:out value="${address.getPincode()}"/>.
                                <br>
							</td>
							<td>
							    <c:out value="${viewSellerAdvertisement.getAvailability()}" />
							</td>
							<td>
							    <c:out value="${viewSellerAdvertisement.getDate()}" />
							</td>
							
							<tr>
						        <td colspan="2">
							        <div class="viewer"><c:out value="${'Seller Detail'}"/><br></div>
							    </td>
		         		    </tr>
		         		    
							<tr>
							    <td colspan="4">
							        <c:set value="${viewSellerAdvertisement.getUser()}" var="seller"/>
                                    <div class="title">Name:<span><c:out value="${seller.getFirstName()}"/>
                                    <c:out value="${seller.getLastName()}"/></span></div>
                                    <div class="title">Mobile:<span><c:out value="${seller.getMobileNumber()}"/></span></div>
                                    <div class="title">Email:<span><c:out value="${seller.getEmail()}"/></span></div>
							    </td>
							</tr>
							
							<tr>
						        <td colspan="2">
							        <div class="viewer"><c:out value="${'Buyer Reviews'}"/><br></div>
							    </td>
		         		    </tr>
		         		    <tr>
						        <td colspan="2">
							        <div class="viewer"><c:out value="${'Comments'}"/><br></div>
							    </td>
							    <td colspan="2">
							        <div class="viewer"><c:out value="${'Ratings'}"/><br></div>
							    </td>
		         		    </tr>
		         		    
		         		    <c:if test="${viewSellerAdvertisement.getAdvertisementReviews().size() == 0}">
							<tr>
							    <td colspan="4">
							        <div class="emptyViewer"><c:out value="${'NOT YET REVIEWED'}"/><br></div>
							    </td>
							</tr>
							</c:if>
		         		    <c:forEach var="review" items="${viewSellerAdvertisement.getAdvertisementReviews()}">
							<tr>
							    <td colspan="2">
							    <c:out value="${review.getComment()}"/>
							    </td>
							    <td colspan="2">
							    <c:out value="${review.getRating()}"/>
							    </td>
						    </tr>
							</c:forEach>
				</table>
		    </div>
		</c:if>
</body>
</html>
