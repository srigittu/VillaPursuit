<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="signup.title"/></title>
    <link rel="stylesheet" type="text/css" href="styles/signup.css">
</head>

<body>
<div class="body"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
		</div>
		<br>
<div class="message">
    <div>Sign<span>up</span></div>
</div>
<div class="col-sm-7" style="position: absolute; top: calc(32% - 35px); left: calc(42% - 255px); z-index: 3; background-color: #000; opacity:0.8;">
    <spring:bind path="user.*">
        <c:if test="${not empty status.errorMessages}">
            <div class="alert alert-danger alert-dismissable">
                <a href="#" data-dismiss="alert" class="close">&times;</a>
                <c:forEach var="error" items="${status.errorMessages}">
                    <c:out value="${error}" escapeXml="false"/><br/>
                </c:forEach>
            </div>
        </c:if>
    </spring:bind>

    <form:form commandName="user" method="post" action="signup" id="signupForm" autocomplete="off"
               cssClass="well" onsubmit="return validateSignup(this)" style="padding: 5px; background-color: #000; opacity:0.8; border-color: #000">
        <spring:bind path="user.username">
        <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
            <appfuse:label styleClass="control-label" key="user.username"/>
            <form:input cssClass="form-control" path="username" id="username" autofocus="true"/>
            <form:errors path="username" cssClass="help-block"/>
        </div>
        <div class="row">
            <spring:bind path="user.password">
            <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
                <appfuse:label styleClass="control-label" key="user.password"/>
                <form:password cssClass="form-control" path="password" id="password" showPassword="true"/>
                <form:errors path="password" cssClass="help-block"/>
            </div>
            <spring:bind path="user.passwordHint">
            <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
                <appfuse:label styleClass="control-label" key="user.passwordHint"/>
                <form:input cssClass="form-control" path="passwordHint" id="passwordHint"/>
                <form:errors path="passwordHint" cssClass="help-block"/>
            </div>
        </div>
        <div class="row">
            <spring:bind path="user.firstName">
            <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
                <appfuse:label styleClass="control-label" key="user.firstName"/>
                <form:input cssClass="form-control" path="firstName" id="firstName" maxlength="50"/>
                <form:errors path="firstName" cssClass="help-block"/>
            </div>
            <spring:bind path="user.lastName">
            <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
                <appfuse:label styleClass="control-label" key="user.lastName"/>
                <form:input cssClass="form-control" path="lastName" id="lastName" maxlength="50"/>
                <form:errors path="lastName" cssClass="help-block"/>
            </div>
        </div>
        <div class="row">
            <spring:bind path="user.email">
            <div class="col-sm-6 form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
            </spring:bind>
                <appfuse:label styleClass="control-label" key="user.email"/>
                <form:input cssClass="form-control" path="email" id="email"/>
                <form:errors path="email" cssClass="help-block"/>
            </div>
            <div class="col-sm-6 form-group">
                <appfuse:label styleClass="control-label" key="user.phoneNumber"/>
                <form:input cssClass="form-control" path="phoneNumber" id="phoneNumber"/>
            </div>
            <div class="col-sm-6 form-group">
                <appfuse:label styleClass="control-label" key="user.website"/>
                <form:input cssClass="form-control" path="website" id="website"/>
            </div>
        </div>
        <div class="row" style="background: #000; opacity: 0.6; height: 20px;"></div>
        <label styleClass="control-label" style="font-size: 24px;">Address Details</label>
        <div class="form-group" style="padding: 10px;">
            <form:input cssClass="form-control" path="address.address" id="address.address" placeholder="No/Street"/>
        </div>
        <div class="row" style="padding: 10px;">
        <div class="col-sm-6 form-group">
            <form:input cssClass="form-control" path="address.area" id="address.area" placeholder="Area"/>
            <div class="row" style="background: #000; opacity: 0.6; height: 10px;"></div>
            <form:input cssClass="form-control" path="address.city" id="address.city" placeholder="City"/>
       </div>
       <div class="col-sm-6 form-group">     
            <form:input cssClass="form-control" path="address.state" id="address.state" placeholder="State"/>
            <div class="row" style="background: #000; opacity: 0.6; height: 10px;"></div>
            <form:input cssClass="form-control" path="address.pincode" id="address.pincode" placeholder="Pincode"/>
       </div>
       <div class="col-sm-6 form-group">
            <form:input cssClass="form-control" path="address.landMark" id="address.landMark" placeholder="Landmark"/>
        </div>
       </div>
        <div class="form-group" style="float: right">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.register"/>
            </button>
            <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
                <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
            </button>
        </div>
    </form:form>
</div>
</body>
<c:set var="scripts" scope="request">
<v:javascript formName="signup" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value="/scripts/validator.jsp"/>"></script>
</c:set>
