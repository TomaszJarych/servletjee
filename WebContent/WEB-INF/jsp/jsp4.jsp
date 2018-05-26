<html>
<body>
	<%
		double km = Double.parseDouble(request.getParameter("km"));
		if (km < 0) {
			km = 0;
		}
		double mile = km * 0.62;
	%>
	<h1><%=km%>
		kilometrów to
		<%=mile%>
		mil
	</h1>

</body>
</html>