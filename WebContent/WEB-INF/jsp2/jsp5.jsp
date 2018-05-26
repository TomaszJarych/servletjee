<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:forEach items="${header }" var="h">
			 ${h.key } = Header Value ${h.value }
			<br/>
	</c:forEach>

</body>
</html>