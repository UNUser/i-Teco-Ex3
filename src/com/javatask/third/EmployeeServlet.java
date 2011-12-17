package com.javatask.third;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataProvider dataProvider;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        dataProvider = new DataProvider();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String jobTitle = request.getParameter("job_title");
			int salary = Integer.parseInt(request.getParameter("salary"));
			System.out.println(name + "\t" + jobTitle + "\t" + salary);
			
			PrintWriter out = response.getWriter();
	        out.print("<html><link rel='stylesheet' href='css/all.css' type='text/css'/><body><h2>");
	      
			if (!dataProvider.addEmployee(name, jobTitle, salary)) {
	        	out.print("<p style='color: Red'>Can't add new employee.</p>");
			} else {
				out.print("<p>Employee was added successfully.</p>");
			}
			out.print("<br></h2><hr><a href='part4.jsp'>back</a>");
			out.print("</body></html>");
			
		} catch (Exception e) {
		}
	}

}
