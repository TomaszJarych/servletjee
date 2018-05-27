<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./Mvc04" method="post">
		<div>

			<%
				String output = "";
				for (int i = 1; i <= 5; i++) {
					output += "<div>" + "<label for=\"author" + i + "\">Autor" + i + " </label>"
							+ "<input type=\"text\" name=\"author" + i + "\" id=\"author\">" + "<label for=\"title" + i
							+ "\">Tytul" + i + "</label>" + "<input type=\"text\" name=\"title" + i + "\" id=\"title" + i
							+ "\">" + " <label for=\"isbn" + i + "\">ISBN"+i+"</label>" + " <input type=\"text\" name=\"isbn" + i
							+ "\" id=\"isbn" + i + "\">" + "</div>";
				}
				output += "<input type=\"submit\" value=\"Wyslij\">";
			%>
			<%= output %>
		</div>

	</form>
</body>
</html>