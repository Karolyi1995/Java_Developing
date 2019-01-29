<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <body>
    <form action="${pageContext.request.contextPath}/RegisterProcess" method="post">  
        Add Username: <input type="text" name="username"/><br/><br/>  
        Password: <input type="password" name="password"/><br/><br/>  
        <input type="submit" value="register"/>
    </form>
  </body>
</html>