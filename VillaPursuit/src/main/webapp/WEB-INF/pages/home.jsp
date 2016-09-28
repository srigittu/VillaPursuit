<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Home Buyer</title>
<link rel="stylesheet" type="text/css" href="styles/home.css">
</head>

<body>

	<div class="body"></div>
	
	<div class="header">
		<div>
			Villa<span>Pursuit</span>
		</div>
	</div>
	<br>
	
	
        <c:if test="${reviewAddMessage != null}">
		<script>
		   window.alert("<c:out value="${reviewAddMessage}"/>");
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
		
		<c:if test="${advertisements.size() != 0}">
 	        <div class="location">
		     <label>Search For:</label>
		     <form action="filter_search">
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
		    <div class="ad" >
				<table>
				    <c:forEach var="advertisement" items="${advertisements}">
						     <tr>
							 <td>
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
                                <div class="title" style="padding:2px;"><c:out value="${'Area Size:'}"/>
                                <span><c:out value="${facility.getArea()}"/></span></div>
                                <c:set value="${advertisement.getAddress()}" var="address"/>
                                <div class="title" style="padding:2px;"><c:out value="${'Location :'}"/>
                                <span><c:out value="${address.getCity()}"/></span></div>
							</td>
							<td style="padding:10px;">
							 <div class="title" style="padding:2px;">&#8377;<c:out value="${' : '}"/> 
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
							    <form action="reviewForm">
						            <input type="hidden" value="${advertisement.getId()}" name="advertisementId">
						            <input type="submit" value="Add Review">
					            </form>
					            </td>
					            <td style="padding:1px;">
							    <form action="view_seller">
						            <input type="hidden" value="${advertisement.getId()}" name="advertisementId">
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
						</c:forEach>
				</table>
				<div class="title" style="float:right;">
		        <div>@Villa<span>Pursuit</span></div>
		        </div>
		  </div>
 	        </c:if>
	    <c:if test="${reviewAdvertisement != null}">
			<c:if test="${sessionScope['role'] == 'ROLE_SELLER'}">
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
		
		
		<c:if test="${sessionScope['role'] != 'ROLE_BUY'}">
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
 	    <c:if test="${viewSellerAdvertisement != null}">
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
