<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Seller</title>
<link rel="stylesheet" type="text/css" href="styles/seller.css">
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
        <form action="advertisementForm">
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
    <c:if test="${advertisementAddMessage != null}">
        <script>
            window.alert("<c:out value="${advertisementAddMessage}"/>");
        </script>
    </c:if>
    <c:if test="${sellerAdvertisements.size() == 0}">
        <div class="message">
            <div>
                Post your First<span>Advertisement!!!</span>
            </div>
            <br>
            <button class="button" style="vertical-align: middle"
                onclick="window.location.href='advertisementForm'">
                <span>Click here</span>
            </button>
        </div>
    </c:if>
    <c:if test="${sellerAdvertisements.size() != 0}">
        <div class="ad">
            <table>
                <c:forEach var="advertisement" items="${sellerAdvertisements}">
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
                                <c:out value="${'Area Size:'}" />
                                <span><c:out value="${facility.getArea()}" /></span>
                            </div> <c:set value="${advertisement.getAddress()}" var="address" />
                            <div class="title" style="padding: 2px;">
                                <c:out value="${'Location :'}" />
                                <span><c:out value="${address.getCity()}" /></span>
                            </div>
                        </td>
                        <td style="padding: 10px;">
                            <div class="title" style="padding: 2px;">
                                &#8377;
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
                    <tr style="background: none;">
                        <td colspan="5"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>

</body>
</html>
