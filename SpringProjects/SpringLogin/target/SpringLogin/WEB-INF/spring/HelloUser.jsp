<html>
  <body>
    <p>Welcome ${sessionScope.username}</p>
        <form action="${pageContext.request.contextPath}/User/Logout" method="get">  
            <input type="submit" value="logout"/>
        </form>
  </body>
</html>