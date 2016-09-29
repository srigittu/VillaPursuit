<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:if test="${role == null }">
    <c:redirect url="welcome" />
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller Advertisement Page</title>
<link rel="stylesheet" type="text/css" href="css/advertisement.css">
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
    <div class="logout">
        <form action="logout">
            <input type="submit" value="Logout">
        </form>
    </div>
    <div class="editAddress">
        <form action="advertisement_form">
            <input type="submit" value="Post Ad Again">
        </form>
    </div>

    <div class="home">
        <form action="home">
            <input type="submit" value="Home">
        </form>
    </div>

    <div class="ad">

        <c:if test="${advertisement != null}">
            <table>
                <tr>
                    <th colspan="4">Enter Villa Details</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
                <form:form name="advertisement" action="add_advertisement"
                    modelAttribute="advertisement">
                    <tr>
                        <td><form:input path="title" placeholder="Title" /><br>
                            <form:errors path="title"></form:errors> <form:input
                                path="status" type="hidden" value="inactive" /><br> <form:errors
                                path="status"></form:errors> <form:input path="availability"
                                placeholder="Availability" /><br> <form:errors
                                path="availability"></form:errors> <form:input path="price"
                                placeholder="Price" /><br> <form:errors path="price"></form:errors>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Post"></td>
                    </tr>
                </form:form>
            </table>
        </c:if>
    </div>
</body>
</html>
