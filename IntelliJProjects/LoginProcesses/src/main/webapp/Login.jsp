<%@ page contentType="text/html; charset=UTF-8" %>

<html>
    <head></head>
    <body>
        <form action="${pageContext.request.contextPath}/LoginProcess" method="POST">
           Username: <input type="text" name="username" />
           Password: <input type="password" name="password" />
            <input type="submit" value="login" />
        </form>
    </body>
</html>