<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link rel="stylesheet" href="css/all.css" type="text/css"/>
<title>Part 3-result</title>

</head>
<body>
	<h2>

	<p>
		sum =  <%= session.getAttribute("sum") %> 
	</p>
	</h2>
	
	<hr>
	<a href="part3.jsp">back</a>
	<br>
	<a href="index.jsp">main</a>
    	
</body>
</html>