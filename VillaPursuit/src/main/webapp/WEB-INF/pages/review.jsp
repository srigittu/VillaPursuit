<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add review</title>
<link rel="stylesheet" type="text/css" href="styles/home.css">
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Villa<span>Pursuit</span>
		</div>
	</div>
	<br>
	<div class="logout">
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
	</div>
	<div class="editAddress">
		<form action="advertisement_form">
			<input type="submit" value="Post Ad Again">
		</form>
	</div>

	<div class="home">
		<form action="home">
			<input type="submit" value="Home">
		</form>
	</div>

	<div class="ad">
		<table>
			<c:set var="advertisement" value="${reviewAdvertisement}" />
			<td style="padding: 10px;">
				<div class="maintitle">
					<c:out value="${advertisement.getTitle()}" />
				</div>
				<div class="title" style="margin-top: 10px; padding: 2px;">
					<c:out value="${'House Type :'}" />
					<span><c:out value="${advertisement.getHouseType()}" /></span>
				</div>
				<div class="title" style="padding: 2px;">
					<c:out value="${'Rent Type :'}" />
					<span><c:out value="${advertisement.getRentType()}" /></span>
				</div> <c:set value="${advertisement.getFacility()}" var="facility" />
				<div class="title" style="padding: 2px;">
					<c:out value="${'Bed Rooms :'}" />
					<span><c:out value="${facility.getBedroom()}" /></span>
				</div>
				<div class="title" style="padding: 2px;">
					<c:out value="${'Area :'}" />
					<span><c:out value="${facility.getArea()}" /></span>
				</div> <c:set value="${advertisement.getAddress()}" var="address" />
				<div class="title" style="padding: 3px;">
					<c:out value="${'Location :'}" />
					<span><c:out value="${address.getCity()}" /></span>
				</div>
			</td>
			<td style="padding: 10px;">
				<div class="title" style="padding: 2px;">
					<c:out value="${'₹ : '}" />
					<span><c:out value="${advertisement.getPrice()}" /></span>/Month
				</div>
			</td>
			<td style="padding: 10px;">
				<div class="title" style="margin-top: 10px; padding: 2px;">
					<c:out value="${'Availability :'}" />
					<span><c:out value="${advertisement.getAvailability()}" /></span>
				</div>
			</td>
			<td>
				<div class="title" style="margin-top: 10px; padding: 2px;">
					<c:out value="${'Posted On :'}" />
					<br> <span><c:out value="${advertisement.getDate()}" /></span>
				</div>
			</td>
			</tr>
			<tr>
				<td colspan="2" style = "background:#000;opacity:0.8;"><form:form action="addReview"
						commandName="review">
						<form:input path="comment" placeholder="Comment" />
						<form:select path="rating">
							<form:option value="NONE" label="--- Rating ---" />
							<form:option value="1" label="--- * ---" />
							<form:option value="2" label="--- ** ---" />
							<form:option value="3" label="--- *** ---" />
							<form:option value="4" label="--- **** ---" />
							<form:option value="5" label="--- ***** ---" />
						</form:select>
						<br>
						<input type="hidden" value="${advertisementId}"
							name="advertisementId">
						<input type="submit" value="Submit">
					</form:form></td>
				<div></div>
	</div>
	    </table>
</body>
</html>
