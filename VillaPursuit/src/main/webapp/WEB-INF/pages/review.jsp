<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
    <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
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
        <td colspan="2">
		    <form:form action="addReview" commandName="review">
			    <form:input path="comment" placeholder="Comment" />
			    <form:select path="rating">
                    <form:option value="NONE" label="--- Rating ---"/>
                    <form:option value="1" label="--- * ---" />
                    <form:option value="2" label="--- ** ---" />
                    <form:option value="3" label="--- *** ---" />
                    <form:option value="4" label="--- **** ---" />
                    <form:option value="5" label="--- ***** ---" />
                </form:select><br>
				<input type="hidden" value="${advertisementId}" name="advertisementId">
				<input type="submit" value="Submit">
		    </form:form>
		</td>
		<div>
	</div>
	</div>
	</body>
	</html>