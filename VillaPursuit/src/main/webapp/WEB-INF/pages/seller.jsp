<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>Home Seller</title>
<link rel="stylesheet" type="text/css" href="styles/seller.css">
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
	<div class="editAddress">
		<form action="advertisement_form">
			<input type="submit" value="Post Ad">
		</form>
	</div>

	<div class="home">
		<form action="home">
			<input type="submit" value="Home">
		</form>
	</div>

	<div class="logout">
		<form action="logout">
			<input type="submit" value="Logout">
		</form>
	</div>


</body>
</html>
