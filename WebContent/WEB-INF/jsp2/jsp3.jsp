<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:if test="${param.minimalAge >= 18 }">Dozwolone od lat 18</c:if>
	<c:if test="${param.minimalAge <= 18 }">Dozwolone ponizej lat 18</c:if>
	<c:if test="${empty param.minimalAge}">Brak parametru</c:if>
</body>
</html>