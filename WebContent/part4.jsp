<%@page import="com.javatask.third.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.javatask.third.DataProvider"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<link rel="stylesheet" href="css/all.css" type="text/css"/>

<title>Part 4</title>

</head>
<body>
	<h2>
	Add Employee form
	<form method="post" action="employee">
		<p>
			<label for='name'>name: </label>
			<input name='name' type="text">
		</p>
	
		<p>
			<label for='job_title'>job_title: </label>
			<input name='job_title' type="text">
		</p>
		
		<p>
			<label for='salary'>salary: </label>
			<input name='salary' type="text">
		</p>
		
		<p class="submit"> 
			<input type="submit" value="Add employee"> 
		</p>
		
	</form>
	
	<hr>
	<div>
		List of Employees
		
		<table>
			<tr>
				<th>Name</th>
				<th>Job title</th>
				<th>Salary</th>
			</tr>
		
		<%
			DataProvider dataProvider = new DataProvider();
		
			List employees = dataProvider.getAllEmployees();
			Iterator it = employees.iterator();
			
			while (it.hasNext()) { 
				Employee e = (Employee) it.next();
			%>
			    <tr>
                    <td> <%= e.getName() %> </td>
                    <td> <%= e.getJobTitle() %> </td>
                    <td> <%= e.getSalary() %> </td>
                </tr>
            	
			<% }
		%>
		</TABLE>
	</div>	
	</h2>
	
	<hr>
	<a href="index.jsp">main</a>
    	
</body>
</html>