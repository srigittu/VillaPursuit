<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Advertisement</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
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
            <tr>
                <td></td>
                <td>
                    <div class="maintitle">
                        <c:out value="${viewAdvertisement.getTitle()}" />
                    </div>
                    <div class="title" style="margin-top: 10px; padding: 2px;">
                        <c:out value="${'House Type :'}" />
                        <span><c:out
                                value="${viewAdvertisement.getHouseType()}" /></span>
                    </div>
                    <div class="title" style="padding: 2px;">
                        <c:out value="${'Rent Type :'}" />
                        <span><c:out
                                value="${viewAdvertisement.getRentType()}" /></span>
                    </div> <c:set value="${viewAdvertisement.getFacility()}"
                        var="facility" />
                    <div class="title" style="padding: 2px;">
                        <c:out value="${'Bed Rooms :'}" />
                        <span><c:out value="${facility.getBedroom()}" /></span>
                    </div>
                    <div class="title" style="padding: 2px;">
                        <c:out value="${'Area :'}" />
                        <span><c:out value="${facility.getAreaSize()}" /></span>
                    </div>
                </td>
                <td style="padding: 10px;">
                    <div class="title" style="padding: 2px;">
                        <c:out value="${'₹ : '}" />
                        <span><c:out value="${viewAdvertisement.getPrice()}" /></span>/Month
                    </div>
                </td>
                <td style="padding: 10px;">
                    <div class="title" style="margin-top: 10px; padding: 2px;">
                        <c:out value="${'Availability :'}" />
                        <span><c:out
                                value="${viewAdvertisement.getAvailability()}" /></span>
                    </div>
                </td>
                <td>
                    <div class="title" style="margin-top: 10px; padding: 2px;">
                        <c:out value="${'Posted On :'}" />
                        <br>
                        <span><c:out value="${viewAdvertisement.getDate()}" /></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <div class="viewer">
                        <c:out value="${'Address'}" />
                        <br>
                    </div>
                </td>
                <td colspan="2">
                    <div class="viewer">
                        <c:out value="${'Seller Detail'}" />
                        <br>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="3"><c:set
                        value="${viewAdvertisement.getAddress()}" var="address" />
                    <div class="title" style="padding: 2px;">
                        <c:out value="${'No: '}" />
                        <span><c:out value="${address.getaddress()}" />, <c:out
                                value="${address.getArea()}" />,<br> <c:out
                                value="${address.getCity()}" />, <c:out
                                value="${address.getState()}" />, <c:out
                                value="${address.getPincode()}" />.</span>
                    </div></td>
                <td colspan="2"><c:set
                        value="${viewAdvertisement.getUser()}" var="seller" />
                    <div class="title">
                        Name: <span><c:out value="${seller.getFirstName()}" /> <c:out
                                value="${seller.getLastName()}" /></span>
                    </div>
                    <div class="title">
                        Mobile: <span><c:out value="${seller.getMobileNumber()}" /></span>
                    </div>
                    <div class="title">
                        Email: <span><c:out value="${seller.getEmail()}" /></span>
                    </div></td>
            </tr>

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

            <c:if
                test="${viewAdvertisement.getAdvertisementReviews().size() == 0}">
                <tr style="border-bottom: 3px solid white">
                    <td colspan="5">
                        <div class="emptyViewer">
                            <c:out value="${'NOT YET REVIEWED'}" />
                            <br>
                        </div>
                    </td>
                </tr>
            </c:if>
            <c:forEach var="review"
                items="${viewAdvertisement.getAdvertisementReviews()}">
                <tr style="border-bottom: 3px solid white">
                    <td colspan="3"><c:out value="${review.getComment()}" /></td>
                    <td colspan="2"><c:out value="${review.getRating()}" /></td>
                </tr>
            </c:forEach>
        </table>
        <div class="title" style="float: right;">
            <div>
                @Villa<span>Pursuit</span>
            </div>
        </div>
    </div>
</body>
</html>
