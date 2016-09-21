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
<link rel="stylesheet" type="text/css" href="css/admin.css">
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
