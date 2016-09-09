<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add Address Details</title>
    </head>
    <body>
               <form:form  action = "insertadvertisement" method="post" modelAttribute="addadvertisement">
                <table>
                    <tr><td><form:input path="title"  placeholder="Enter title of an advertisement" required="required"/></td></tr>
                    <tr><td><form:input path="status"  placeholder="Enter Status" required="required"/></td></tr>
                </table>
              <input type="submit" value="Register"/>
              </form:form>
              <a href="insertanfacility">Add Facilities in this advertisement</a>
              <a href="logout">Logout</a>
            </body>
</html>