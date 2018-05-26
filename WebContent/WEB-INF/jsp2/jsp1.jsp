
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<c:choose>
<c:when test= "${not empty param.role}">
 <c:out value= "${param.role}"></c:out>
</c:when>
<c:when test= "${empty param.role}">
 <c:out value= "${param.role}">Brak parametrów</c:out>
</c:when>

</c:choose>
</body>
</html>