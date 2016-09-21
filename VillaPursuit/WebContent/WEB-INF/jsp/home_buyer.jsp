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

.location {
	position: fixed;
	top: calc(25% - 32px);
	left: calc(8% - 94px);
	color: #00ffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 2px;
	z-index: 3;
}

.myselect select {
	background: #000;
	opacity:0.5;
    width: 200px;
    height:30px;
    padding: 2px;
    color: #00ffff;
    font-size: 16px;
    line-height: 1;
    border: #fff;
    border-radius: 0;
   -webkit-appearance: none;
}

.myselect {
   width: 200px;
   height:30px;
   overflow: hidden;
   color: #00ffff;
   background: #000;
   opacity:0.5;
   border: 1px solid #fff;
   opacity:0.5;
   }

.location input[type=submit] {
	width: 100px;
	height: 35px;
	background: #000;
	opacity: 0.5;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #0fffff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 2px;
	margin-top: 10px;
}

.location input[type=submit]:hover {
	opacity: 0.6;
}

.location input[type=range]{
    /* fix for FF unable to apply focus style bug  */
    border: 1px solid white; 

    /*required for proper track sizing in FF*/
    width: 180px;
}

.location input[type=range]::-moz-range-track {
    width: 180px;
    height: 5px;
    background: #000;
    opacity:0.4;
    border: none;
}

.location input[type=range]::-moz-range-thumb {
    border: none;
    height: 16px;
    width: 16px;
    background: #00ffff;
    opacity:0.4;
}

/*hide the outline behind the border*/
.location input[type=range]:-moz-focusring{
    outline: 1px solid #fff;
    opacity:0.8;
    outline-offset: 1px;
}

.location input[type=range]:focus::-moz-range-track {
    background: #00ffff;
    opacity:0.4;
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
	font-weight: 400;
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

.ad {
	position: absolute;
	top: calc(29% - 35px);
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
	border: #000;
	font-family: 'Exo', sans-serif;
	font-size: 32px;
	font-weight: 200;
	padding-top: .5em;
	border
}
.ad table .backNo {
   background: none;
}

.ad table tr th {
	color: #00ffff;
	border-collapse: collapse;
	font-family: 'Exo', sans-serif;
	font-size: 36px;
	font-weight: 400;
	padding: 10px;
}

.ad table tr td {
	color: #fff;
	border-collapse: collapse;
	font-family: 'Exo', sans-serif;
	font-size: 18px;
	font-weight: 400;
	padding: 6px;
}

.ad input[type=submit] {
	width: 110px;
	height: 30px;
	background: #000;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 75px;
	color: #0dded5;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 500;
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
	font-weight: 400;
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
	left: calc(74% - 50px);
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

.imaging {
    position: absolute;
	top: calc(10% - 75px);
	left: calc(10% - 50px);
	height: 100px;
	width: 100px;
	padding: 10px;
	z-index: 3;
}

.title {
    font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 350;
	color: #0dded5;
}

.maintitle {
    font-family: 'Exo', sans-serif;
	font-size: 25px;
	font-weight: 500;
	color: #0dded5;
}

.maintitle span {
	color: #fff;
}

.title span {
	color: #ffffff;
}

</style>

<body>

	<div class="body"></div>
	
	<div class="header">
		<div>
			Villa<span>Pursuit</span>
		</div>
	</div>
	<br>
	<c:if test="${sessionScope['userId'] != null}">
	
        <c:if test="${reviewAddMessage != null}">
		<script>
		   window.alert("<c:out value="${reviewAddMessage}"/>");
		</script>
		</c:if>
		
		<c:if test="${addressAddMessage != null}">
		<script>
		   window.alert("<c:out value="${addressAddMessage}"/>");
		</script>
		</c:if>
		
		<div class="logout">
			<form action="logout">
				<input type="submit" value="Logout">
			</form>
		</div>
		
		<div class="editAddress">
			<form action="address_form">
				<input type="submit" value="Profile">
			</form>
		</div>
		
		<div class="register">
			<c:if test="${addAddress != null}">
				<h2>
					Add<span>Address!</span>
				</h2>
				<form:form action="user_address" commandName="address">
					<form:input path="number" placeholder="Number" />
					<form:errors path="number"></form:errors>
					<form:input path="street" placeholder="Street" />
					<form:errors path="street"></form:errors>
					<form:input path="city" placeholder="City" />
					<form:errors path="city"></form:errors>
					<form:input path="state" placeholder="State" />
					<form:errors path="state"></form:errors>
					<form:input path="pincode" placeholder="Pincode" />
					<form:errors path="pincode"></form:errors>
					<input type="submit" value="Save">
				</form:form>
			</c:if>
		</div>
		<c:if test="${advertisements != null}">
 	        <div class="location">
		     <label>Search For:</label>
		     <form action="filter" method="post">
		        <div class="myselect">
		        <select name="houseType">
                    <option>Choose House Type</option>
                    <option value="Individual">Individual</option>
                    <option value="Appartment">Appartment</option>
                </select>
                </div>
                <br>
                <div class="myselect">
                <select name="rentType">
                     <option>Choose Rent Type</option>
                     <option value="Rent">Rent</option>
                     <option value="Lease">Lease</option>
                </select>
                </div>
                <br>
                <label>Price (10k-40k):</label><br>
                <span id="slider_value" style="color:white; text-align:right;"></span>
                <br>
                <script>
                function show_value(x)
                {
                 document.getElementById("slider_value").innerHTML=x;
                }
                </script>
                <input type="range" min="10000" max="40000" name="price" value="10000" onchange="show_value(this.value);">
 				<br>
 				<input type="submit" value="Filter">
 		    </form>
		    </div>
 	        <c:if test="${sessionScope['role'] == 'seller'}">
		    <div class="home">
			<form action="seller">
				<input type="submit" value="My Posts">
			</form>
		    </div>
		    </c:if>
 	        <div class="ad" >
				<table>
				    <c:forEach var="advertisement" items="${advertisements}">
						<c:set value="${advertisement.getUser()}" var="user"/>
						<c:if test="${user.getId() != sessionScope['userId']}">
						     <tr>
							 <td>
							    <c:forEach var="image"
									items="${advertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="150px" height="75px"/>
									<br>
								</c:forEach>
						     </td>
						     <td>
							    <div class="maintitle"><c:out value="${advertisement.getTitle()}" /></div>
							    <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'House Type :'}"/>
								<span><c:out value="${advertisement.getHouseType()}" /></span></div>
								<div class="title" style="padding:2px;"><c:out value="${'Rent Type :'}"/>
								<span><c:out value="${advertisement.getRentType()}" /></span></div>
								<c:set value="${advertisement.getFacility()}" var="facility"/>
								<div class="title" style="padding:2px;"><c:out value="${'Bed Rooms :'}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title" style="padding:2px;"><c:out value="${'Area :'}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
                                <c:set value="${advertisement.getAddress()}" var="address"/>
                                <div class="title" style="padding:3px;"><c:out value="${'Location :'}"/>
                                <span><c:out value="${address.getCity()}"/></span></div>
							</td>
							<td style="padding:10px;">
							 <div class="title" style="padding:2px;"><c:out value="${'₹ : '}"/> 
							 <span><c:out value="${advertisement.getPrice()}" /></span>/Month</div>
							</td>
							<td style="padding:10px;">
							     <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'Availability :'}"/>
							     <span><c:out value="${advertisement.getAvailability()}" /></span></div>
							</td>
							<td>
							    <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'Posted On :'}"/>
							    <br><span><c:out value="${advertisement.getDate()}" /></span></div>
							</td>
							</tr>
							<tr >
							    <td colspan="3"></td>
							    <td style="padding:1px; text-align:right;">
							    <form action="review_form">
						            <input type="hidden" value="${advertisement.getAdvertisementId()}" name="advertisementId">
						            <input type="submit" value="Add Review">
					            </form>
					            </td>
					            <td style="padding:1px;">
							    <form action="view_seller">
						            <input type="hidden" value="${advertisement.getAdvertisementId()}" name="advertisementId">
						            <input type="submit" value="More Info">
					            </form>
					            </td>
					        <tr style="border-bottom:3px solid white;">
					        <td colspan="5">
					        </td>
					        </tr>
					        <tr style="background: none;">
					        <td colspan="5" >
					         </td>
					        </tr>
						</c:if>
						</c:forEach>
				</table>
				<div class="title" style="float:right;">
		        <div>@Villa<span>Pursuit</span></div>
		        </div>
		  </div>
		</c:if>
	    <c:if test="${addReview != null}">
			<c:if test="${sessionScope['role'] == 'seller'}">
		    <div class="seller">
			<form action="seller">
				<input type="submit" value="My Posts">
			</form>
		    </div>
		    </c:if>
		    
			<div class="home">
		    <form action="home">
 		    <input type="submit" value="Home">
 	        </form>
 	        </div>
 	        
 	        <div class="ad">
				<table>
						<c:set var="advertisement" value="${reviewAdvertisement}"/>
						<tr>
							 <td>
							    <c:forEach var="image"
									items="${advertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="150px" height="75px"/>
									<br>
								</c:forEach>
						     </td>
						     <td>
							    <div class="maintitle"><c:out value="${advertisement.getTitle()}" /></div>
							    <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'House Type :'}"/>
								<span><c:out value="${advertisement.getHouseType()}" /></span></div>
								<div class="title" style="padding:2px;"><c:out value="${'Rent Type :'}"/>
								<span><c:out value="${advertisement.getRentType()}" /></span></div>
								<c:set value="${advertisement.getFacility()}" var="facility"/>
								<div class="title" style="padding:2px;"><c:out value="${'Bed Rooms :'}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title" style="padding:2px;"><c:out value="${'Area :'}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
                                <c:set value="${advertisement.getAddress()}" var="address"/>
                                <div class="title" style="padding:3px;"><c:out value="${'Location :'}"/>
                                <span><c:out value="${address.getCity()}"/></span></div>
							</td>
							<td style="padding:10px;">
							 <div class="title" style="padding:2px;"><c:out value="${'₹ : '}"/> 
							 <span><c:out value="${advertisement.getPrice()}" /></span>/Month</div>
							</td>
							<td style="padding:10px;">
							     <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'Availability :'}"/>
							     <span><c:out value="${advertisement.getAvailability()}" /></span></div>
							</td>
							<td>
							    <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'Posted On :'}"/>
							    <br><span><c:out value="${advertisement.getDate()}" /></span></div>
							</td>
							</tr>
							<tr>
							<td colspan="2">
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
							<td colspan="3"></td>
							</tr>
							
				</table>
				<div class="title" style="float:right;">
		        <div>@Villa<span>Pursuit</span></div>
		        </div>
		     </div>
		</c:if>
		</c:if>
		
		<c:if test="${viewSellerAdvertisement != null}">
		<c:if test="${sessionScope['role'] == 'seller'}">
		    <div class="seller">
			<form action="seller">
				<input type="submit" value="My Posts">
			</form>
		    </div>
		</c:if>
		<div class="home">
		    <form action="home">
 		    <input type="submit" value="Home">
 	        </form>
 	    </div>
		    <div class="ad">
				<table>
					    <tr>
							 <td>
							     <c:forEach var="image" items="${viewSellerAdvertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="150px" height="75px"/>
									<br></br>
								</c:forEach>
						     </td>
							 <td>
							    <div class="maintitle"><c:out value="${viewSellerAdvertisement.getTitle()}" /></div>
							    <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'House Type :'}"/>
								<span><c:out value="${viewSellerAdvertisement.getHouseType()}" /></span></div>
								<div class="title" style="padding:2px;"><c:out value="${'Rent Type :'}"/>
								<span><c:out value="${viewSellerAdvertisement.getRentType()}" /></span></div>
								<c:set value="${viewSellerAdvertisement.getFacility()}" var="facility"/>
								<div class="title" style="padding:2px;"><c:out value="${'Bed Rooms :'}"/>
                                <span><c:out value="${facility.getBedroom()}"/></span></div>
                                <div class="title" style="padding:2px;"><c:out value="${'Area :'}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
							</td>
							<td style="padding:10px;">
							 <div class="title" style="padding:2px;"><c:out value="${'₹ : '}"/> 
							 <span><c:out value="${viewSellerAdvertisement.getPrice()}" /></span>/Month</div>
							</td>
							<td style="padding:10px;">
							     <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'Availability :'}"/>
							     <span><c:out value="${viewSellerAdvertisement.getAvailability()}" /></span></div>
							</td>
							<td>
							    <div class="title" style="margin-top:10px; padding:2px;"><c:out value="${'Posted On :'}"/>
							    <br><span><c:out value="${viewSellerAdvertisement.getDate()}" /></span></div>
							</td>
							</tr>
							<tr>
						        <td colspan="3">
							        <div class="viewer"><c:out value="${'Address'}"/><br></div>
							    </td>
							    <td colspan="2">
							        <div class="viewer"><c:out value="${'Seller Detail'}"/><br></div>
							    </td>
		         		    </tr>
							<tr>
							<td colspan="3">
							    <c:set value="${viewSellerAdvertisement.getAddress()}" var="address"/>
							    <div class="title" style="padding:2px;"><c:out value="${'No: '}"/>
                                <span><c:out value="${address.getNumber()}"/>,
                                <c:out value="${address.getStreet()}"/>,<br>
                                <c:out value="${address.getCity()}"/>,
                                <c:out value="${address.getState()}"/>,
                                <c:out value="${address.getPincode()}"/>.</span>
                                </div>
							</td>
							<td colspan="2">
							    <c:set value="${viewSellerAdvertisement.getUser()}" var="seller"/>
                                <div class="title">Name: <span><c:out value="${seller.getFirstName()}"/>
                                <c:out value="${seller.getLastName()}"/></span></div>
                                <div class="title">Mobile: <span><c:out value="${seller.getMobileNumber()}"/></span></div>
                                <div class="title">Email: <span><c:out value="${seller.getEmail()}"/></span></div>
							</td>
							</tr>
							
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
		         		    
		         		    <c:if test="${viewSellerAdvertisement.getAdvertisementReviews().size() == 0}">
							<tr style="border-bottom:3px solid white">
							    <td colspan="5">
							        <div class="emptyViewer"><c:out value="${'NOT YET REVIEWED'}"/><br></div>
							    </td>
							</tr>
							</c:if>
		         		    <c:forEach var="review" items="${viewSellerAdvertisement.getAdvertisementReviews()}">
							<tr style="border-bottom:3px solid white">
							    <td colspan="3">
							    <c:out value="${review.getComment()}"/>
							    </td>
							    <td colspan="2">
							    <c:out value="${review.getRating()}"/>
							    </td>
						    </tr>
							</c:forEach>
				</table>
				<div class="title" style="float:right;">
		        <div>@Villa<span>Pursuit</span></div>
		        </div>
		    </div>
		</c:if>
</body>
</html>
