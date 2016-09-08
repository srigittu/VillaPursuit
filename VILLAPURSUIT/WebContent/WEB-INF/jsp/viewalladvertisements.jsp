<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>view all advertisements</title>
    </head>
    <body>
    <h1>Advertisements</h1>
        <table>
                <tr>
                    <th>Title</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="advertisement" items="${advertisements}">
                    <tr>
                        <td><c:out value="${advertisement.title}"></c:out></td>
                        <td><c:out value="${advertisement.status}"></c:out></td>
                        <td><a href="insertanreview?advertisementId=${advertisement.getAdvertisementId()}">Add review</a>
                        <td><a href="viewallreviews?advertisementId=${advertisement.getAdvertisementId()}">View all reviews</a>
                </c:forEach>
        </table>
         <a href="logout">Logout</a>
    </body>
</html>                                  