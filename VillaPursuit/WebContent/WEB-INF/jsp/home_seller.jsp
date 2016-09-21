<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${sessionScope['userId'] == null}">
	<c:redirect url="welcome" />
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Seller</title>
<link rel="stylesheet" type="text/css" href="css/home_seller.css">
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
	<div class="editAddress">
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
			<h2>
				Add<span>Address!</span>
			</h2>
			<form:form action="user_address" commandName="address">
				<form:input path="number" placeholder="Number" />
				<form:input path="street" placeholder="Street" />
				<form:input path="city" placeholder="City" />
				<form:input path="state" placeholder="State" />
				<form:input path="pincode" placeholder="Pincode" />
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
				<c:forEach var="advertisement" items="${sellerAdvertisements}">
					<tr>
							 <td>
							     <c:forEach var="image" items="${advertisement.getImages()}">
									<img src="upload/<c:out value="${image.getImagePath()}"/>" width="150px" height="75px"/>
									<br></br>
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
						        <td colspan="5">
							        <div class="viewer"><c:out value="${'Address'}"/><br></div>
							    </td>
		         		    </tr>
							<tr>
							<td colspan="5">
							    <c:set value="${advertisement.getAddress()}" var="address"/>
							    <div class="title" style="padding:2px;"><c:out value="${'No: '}"/>
                                <span><c:out value="${address.getNumber()}"/>,
                                <c:out value="${address.getStreet()}"/>,<br>
                                <c:out value="${address.getCity()}"/>,
                                <c:out value="${address.getState()}"/>,
                                <c:out value="${address.getPincode()}"/>.</span>
                                </div>
							</td>
							</tr>
				    <tr>
						<td colspan="5">
							<div class="viewer">
								<c:out value="${'Viewer Details'}" />
								<br>
							</div>
						</td>
					</tr>
					<c:if test="${advertisement.getAdvertisementViewer().size() == 0}">
						<tr>
							<td colspan="5">
								<div class="emptyViewer">
									<c:out value="${'NO ONE VIEWED'}" />
									<br>
								</div>
							</td>
						</tr>
					</c:if>
					<c:forEach var="viewer"
						items="${advertisement.getAdvertisementViewer()}">
						<tr>
							<td colspan="5">
								<div class="title">
									Name:<span><c:out value="${viewer.getFirstName()}" /> <c:out
											value="${viewer.getLastName()}" /></span>
								</div>
								<div class="title">
									Mobile:<span><c:out value="${viewer.getMobileNumber()}" /></span>
								</div>
								<div class="title">
									Email:<span><c:out value="${viewer.getEmail()}" /></span>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5">
							<div class="viewer">
								<c:out value="${'Buyer Reviews'}" />
								<br>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<div class="viewer">
								<c:out value="${'Comments'}" />
								<br>
							</div>
						</td>
						<td colspan="2">
							<div class="viewer">
								<c:out value="${'Ratings'}" />
								<br>
							</div>
						</td>
					</tr>
					<c:if test="${advertisement.getAdvertisementReviews().size() == 0}">
						<tr>
							<td colspan="5">
								<div class="emptyViewer">
									<c:out value="${'NOT YET REVIEWED'}" />
									<br>
								</div>
							</td>
						</tr>
					</c:if>
					<c:forEach var="review"
						items="${advertisement.getAdvertisementReviews()}">
						<tr>
							<td colspan="3"><c:out value="${review.getComment()}" /></td>
							<td colspan="2"><c:out value="${review.getRating()}" /></td>
						</tr>
					</c:forEach>
					<tr style="background: none;">
					        <td colspan="5" >
					         </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>

</body>
</html>
