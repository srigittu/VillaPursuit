<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View all reviews</title>
    </head>
    <body>
    <h1>add user</h1>
        <table>
                <tr>
                    <th>Title</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="review" items="${reviews}">
                    <tr>
                        <td><c:out value="${review.comment}"></c:out></td>
                        <td><c:out value="${review.rating}"></c:out></td>
                </c:forEach>
        </table>
         <a href="logout">Logout</a>
    </body>
</html>                                  