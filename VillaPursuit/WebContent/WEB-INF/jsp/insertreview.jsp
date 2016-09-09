<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add Address Details</title>
    </head>
    <body>
               <form:form action = "insertreview" method="post" modelAttribute="addreview">
                <table>
                    <tr><td><form:input path="comment"  placeholder="Enter your comments" required="required"/></td></tr>
                    <tr><td><form:input path="rating"  placeholder="Enter your rating" required="required"/></td></tr>
                    <input type = "hidden" name = "advertisementId" value = "${advertisementId}"/>
                </table>
                <input type="submit" value="Register"/>
            </form:form>
            <a href="logout">Logout</a>
            </body>
</html>