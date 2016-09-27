<%@ include file="/common/taglibs.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles/login.css">
</head>

<body>

<div class="body"></div>
    <div class="grad"></div>
		<div class="header">
			<div>Villa<span>Pursuit</span></div>
		</div>
		<br>
		
<div class="login">
<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)" autocomplete="off">
    <h2>Log<span>in!</span></h2>
<c:if test="${param.error != null}">
    <div class="alert alert-danger alert-dismissable">
        <fmt:message key="errors.password.mismatch"/>
    </div>
</c:if>
    <input type="text" name="j_username" id="j_username"
           placeholder="<fmt:message key="label.username"/>" required>
    <input type="password" name="j_password" id="j_password"
           placeholder="<fmt:message key="label.password"/>" required>
    <input type="submit" value="Login"><br>
<c:if test="${appConfig['rememberMeEnabled']}">
    <label for="rememberMe">
        <input type="checkbox" name="_spring_security_remember_me" id="rememberMe"/>
        <fmt:message key="login.rememberMe"/></label>
</c:if>
</form><br>

<p>
    <fmt:message key="login.signup">
        <fmt:param><c:url value="/signup"/></fmt:param>
    </fmt:message>
</p>

<c:set var="scripts" scope="request">
<%@ include file="/scripts/login.js"%>
</c:set>

<p><fmt:message key="login.passwordHint"/></p>

<p><fmt:message key="updatePassword.requestRecoveryTokenLink"/></p>
</div>
</body>