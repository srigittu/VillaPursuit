<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
            <h1><center>Login</center></h1>
            <form action="index" method="post">
            <center>
                <input type="text" placeholder="User Id" name="userId" required="required"/><br>  
                <input type="password" placeholder="password" name="password" required="required"/><br>
                <input type="submit"  name="button" value="Login" class="button"/><br>
             </center>
            </form>
            <center>
             <a href="insertuser">create New Account</a>
             </center>
    </body>
</html>
