<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add User Details</title>
    </head>
    <body>
               <form:form  action="insertaddress" method="post" modelAttribute="addaddress">
                <table>
                    <tr><td><form:input path="doorNumber"  placeholder="Enter door number" required="required"/></td></tr>
                    <tr><td><form:input path="street"  placeholder="Enter Street Name" required="required"/></td></tr>
                    <tr><td><form:input path="city"  placeholder="Enter city Name" required="required"/></td></tr>
                    <tr><td><form:input path="pinCode"  placeholder="Enter Pin code" required="required"/></td></tr>
                    <tr><td><form:input path="state"  placeholder="Enter State" required="required"/></td></tr>
                    <tr>
                        <td><input type="submit" value="Register"/></td>
                    </tr>
                </table>
            </form:form>
              <a href="logout">Logout</a>
            </body>
</html>