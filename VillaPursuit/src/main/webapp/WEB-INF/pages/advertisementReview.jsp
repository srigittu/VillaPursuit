<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Advertisement</title>
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
            <c:set var="advertisement" value="${reviewAdvertisement}" />
            <tr>
                <td>
                </td>
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
                        <br>
                        <span><c:out value="${advertisement.getDate()}" /></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2"><form:form action="add_review"
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
                        <input type="hidden" value="${advertisement.getId()}"
                            name="advertisementId">
                        <input type="submit" value="Submit">
                    </form:form></td>
                <td colspan="3"></td>
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
