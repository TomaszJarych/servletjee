<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<c:forEach items="${paramValues.role}" var="item">
<c:out value="${item}"></c:out><br/>
</c:forEach>

</body>
</html>