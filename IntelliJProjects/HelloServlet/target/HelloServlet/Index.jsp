<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
  <body>
     <c:if test = "${Object != null}">
        <p><c:out value = "${Object}"/><p>
     </c:if>
     <c:if test = "${Object == null}">
        <p><c:out value = "Az érték null"/><p>
     </c:if>
  </body>
</html>