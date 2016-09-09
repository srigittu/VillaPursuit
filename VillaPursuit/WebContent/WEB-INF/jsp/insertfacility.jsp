<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add Facility Details</title>
    </head>
    <body>
               <form:form action="insertfacility" method="post" modelAttribute="addfacility">
                <table>
                    <td><form:input path="facilityName"  placeholder="Enter type of facility" required="required"/></td>
                    <td><form:input path="facilityValue"  placeholder="Enter value" required="required"/></td>
                    <tr>
                        <td><input type="submit" value="Register"/></td>
                    </tr>
                </table>
                 <a href="logout">Logout</a>
            </form:form>
            </body>
</html>