<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Add User Details</title>
        <style>
            
        </style>
    </head>
    <body>
    <c:if test="${Message != null}">
              <c:out value="${Message}"/>
    </c:if>
               
               <form:form  action="insertuser" method="post" modelAttribute="adduser">
                <table>
                    <tr><td><form:input path="userName"  placeholder="Enter User Name" required="required"/></td></tr>
                    <tr><td><form:input path="firstName"  placeholder="Enter First Name" required="required"/></td></tr>
                    <tr><td><form:input path="lastName"  placeholder="Enter Last Name" required="required"/></td></tr>
                    <tr><td><form:input path="mobileNumber"  placeholder="Enter Mobile Number" required="required"/></td></tr>
                    <tr><td><form:input path="email"  placeholder="Enter Email Id" required="required"/></td></tr>
                    <tr><td><form:input path="password"  placeholder="Enter Password" required="required"/></td></tr>
                    <tr>
                        <td><input type="submit" value="Register"/></td>
                    </tr>
                </table>
            </form:form>
            </body>
</html>