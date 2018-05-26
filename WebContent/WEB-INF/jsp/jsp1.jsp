<%@page import="java.util.Date"%>
<html>
	<body>
	<%! Date now = new Date(); %>
	<p>Aktualna data to wyrazenie  <%=new Date() %> </p>
	<p>Aktualna data to  skryplet <% out.print(new Date()); %> </p>
	<p>Aktualna data to deklaracja <% out.print(now); %> </p>
	
	</body>
</html>