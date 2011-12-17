<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link rel="stylesheet" href="css/all.css" type="text/css"/>
<title>Part 3</title>

</head>
<body>
	<h2>
	<form method="post" action="">
		<p>
			<label for='a'>a: </label>
			<input name='a' type="text">
		</p>
		
		<p>
			<label for='b'>b: </label>
			<input name='b' type="text">
		</p>
	
		<p class="submit">	
			<input type="submit" value="Add">
		</p>
		
		<p>
			<% 
				try {
					double a = Double.parseDouble(request.getParameter("a"));
					double b = Double.parseDouble(request.getParameter("b"));
					
					request.getSession(true).setAttribute("sum", a + b);
					response.sendRedirect("part3-result.jsp");
					
				} catch (Exception e) {
				}
			%>
		</p>
	</form>
	</h2>
	
	<hr>
	<a href="index.jsp">main</a>
    	
</body>
</html>