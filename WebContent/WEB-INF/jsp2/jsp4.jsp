<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<c:choose >
<c:when test="${param.minimalAge >= 18 }">Dozwolone od lat 18</c:when>
<c:when test="${param.minimalAge <= 18 }">Dozwolone ponizej lat 18</c:when>
<c:otherwise>Brak parametru</c:otherwise>
</c:choose>

</body>
</html>