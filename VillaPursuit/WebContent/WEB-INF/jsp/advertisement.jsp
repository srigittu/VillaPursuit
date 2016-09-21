<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${role == null }">
     <c:redirect url="welcome"/>
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller Advertisement Page</title>
<link rel="stylesheet" type="text/css" href="css/advertisement.css">
</head>
<body>
    <c:if test="${sessionScope['userId'] == null}">
    <c:redirect url="welcome"/>
    </c:if>
    <c:if test="${advertisementAddMessage != null}">
		<script>
		   window.alert("<c:out value="${advertisementAddMessage}"/>");
		</script>
     </c:if>
    <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
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
                    <form:input type="file" path="images[0].imagePath" placeholder="images" /><br>
                    <form:input type="file" path="images[1].imagePath" placeholder="images"/><br>
                    </td>
                    
                    <td>
                    <form:input path="title" placeholder="Title"/><br>
                    <form:errors path="title"></form:errors>
                    <form:input path="status" type="hidden" value="inactive"/><br>
                    <form:errors path="status"></form:errors>
                    <form:input path="availability" placeholder="Availability"/><br>
                    <form:errors path="availability"></form:errors>
                    <form:input path="price" placeholder="Price"/><br>
                    <form:errors path="price"></form:errors>
                    </td>
                    </tr>
                    <td>
 			            <form:select path="houseType">
                            <form:option value="Individual" label="Individual" />
                            <form:option value="Appartment" label="Appartment" />
                        </form:select><br>
                        <form:select path="rentType">
                        <form:errors path="rentType"></form:errors>
                            <form:option value="Rent" label="Rent" />
                            <form:option value="Lease" label="Lease" />
                        </form:select><br>
                    </td>
                    <tr>
                    <td>
                    <form:checkbox path="facility.parking"/>Parking
                    <form:checkbox path="facility.drainage"/>Drainage
                    <form:checkbox path="facility.transport"/>Transport
                    </td>
                    <td>
                        <form:select path="facility.bedroom">
                        <form:errors path="facility.bedroom"></form:errors>
                            <form:option value="NONE" label="--- Bedroom ---"/>
                            <form:option value="1BHK" label="--- 1BHK ---" />
                            <form:option value="2BHK" label="--- 2BHK ---" />
                            <form:option value="3BHK" label="--- 3BHK ---" />
                        </form:select><br>
                        <form:input path="facility.area" placeholder="Area-Size"/><br>
                        <form:errors path="facility.area"></form:errors>
 			        </td>
 			        <td  colspan="2">
                    <form:input path="address.number" placeholder="Number" /><br>
                    <form:errors path="address.number"></form:errors>
                    <form:input path="address.street" placeholder="Street"/><br>
                    <form:errors path="address.street"></form:errors>
                    <form:input path="address.city" placeholder="City" /><br>
                    <form:errors path="address.city"></form:errors>
                    <form:input path="address.state" placeholder="State"/><br>
                    <form:errors path="address.state"></form:errors>
                    <form:input path="address.pincode" placeholder="Pincode"/><br>
                    <form:errors path="address.pincode"></form:errors>
 			        </td>
 			        </tr>
 			        <tr>
 			        <td></td>
 			        <td></td>
 			        <td></td>
 			        <td><input type="submit" value="Post"></td>
 			        </tr>
 			     </form:form>
 			</table>
		</c:if>
		</div>

</body>
</html>
