<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Review Advertisement</title>
<link rel="stylesheet" type="text/css" href="styles/home.css">
</head>
<div class="body"></div>
<div class="header">
	<div>
		Villa<span>Pursuit</span>
	</div>
</div>
<br>
<div class="home">
	<form action="home">
		<input type="submit" value="Home">
	</form>
</div>
<div class="editAddress">
	<form action="address_form">
		<input type="submit" value="Profile">
	</form>
</div>
<div class="logout">
	<form action="logout">
		<input type="submit" value="Logout">
	</form>
</div>

<div class="ad">
	<table>
		<c:set var="advertisement" value="${reviewAdvertisement}" />
		<tr>
			<td></td>
			<td>
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
					<span><c:out value="${facility.getAreaSize()}" /></span>
				</div> <c:set value="${advertisement.getAddress()}" var="address" />
				<div class="title" style="padding: 3px;">
					<c:out value="${'Location :'}" />
					<span><c:out value="${address.getCity()}" /></span>
				</div>
			</td>
			<td style="padding: 10px;">
				<div class="title" style="padding: 2px;">
					<c:out value="${' : '}" />
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
		<tr style="background: #000; opacity: 0.4;">
			<td colspan="5"></td>
		</tr>
		<tr>
			<td colspan="5"><form:form action="addReview"
					commandName="advertisementReview">
					<form:textarea path="comment" placeholder="Comment"
						style="width: 600px; height:60px; background: #000; opacity:0.8; font-color: #00ffff;" />
					<br>
					<form:select path="rating"
						style="background: #000; opacity:0.8; font-color: #00ffff;">
						<form:option value="NONE" label="--- Rating ---" />
						<form:option value="1" label="--- * ---" />
						<form:option value="2" label="--- ** ---" />
						<form:option value="3" label="--- *** ---" />
						<form:option value="4" label="--- **** ---" />
						<form:option value="5" label="--- ***** ---" />
					</form:select>
					<br>
					<input type="hidden" value="${advertisement.getId()}"
						name="advertisementId">
					<input type="submit" value="Submit">
				</form:form></td>
		</tr>
	</table>
	<div class="title" style="float: right;">
		<div>
			@Villa<span>Pursuit</span>
		</div>
	</div>
</div>

<c:if test="${reviewAddMessage != null}">
	<script>
		window.alert("<c:out value="${reviewAddMessage}"/>");
	</script>
</c:if>
</body>
</html>
