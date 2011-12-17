package com.javatask.third;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SummatorServlet
 */
@WebServlet("/summator")
public class SummatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummatorServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enumeration en = request.getParameterNames();
        double[] param = new double[2];
        int paramIndex = 0;

        // find two number in request
        while (en.hasMoreElements() && paramIndex < 2) {
        	String paramName = (String) en.nextElement();
			try {
				double number = Double.parseDouble(request.getParameter(paramName));
				param[paramIndex++] = number;
			} catch (Exception e) {
			}
		}
        
        PrintWriter out = response.getWriter();
        out.print("<html><link rel='stylesheet' href='css/all.css' type='text/css'/><body><h2>");
        
        // simple validation
        if (paramIndex < 2) {
        	out.print("<p style='color: Red'>Too few numeric parameters</p>");
        } else {
        	out.print("a = " + param[0] + "<br>b = " + param[1] + "<hr> <b>sum = " 
        			+ (param[0] + param[1]) + "</b>");
        }
		
        out.print("<br></h2><hr><a href='index.jsp'>main</a>");
		out.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
