<html>
<body>
	<ul></ul>
	<%
		String a = request.getParameter("a");
		String b = request.getParameter("b");
	%>
	<%
		int aNumber = Integer.parseInt(a);
		int bNumber = Integer.parseInt(b);
		for (int i = aNumber; i <= bNumber; i++) {
	%>
	<li>
		<%
			out.print(i);
		%>
	</li>
	<%
		}
	%>
	</ul>
</body>
</html>