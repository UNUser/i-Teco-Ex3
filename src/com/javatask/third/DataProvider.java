
package com.javatask.third;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;


public class DataProvider {
	
	private static final String DB_NAME = "testdb";
	private boolean tableCreated;
	private boolean isConnected;
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public DataProvider() {
		tableCreated = false;
		isConnected = false;
		initDB();
	}
	
	public void initDB() {
		// once creating data base
		if (!tableCreated) {
			try {
				con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + DB_NAME + ";create=true");
				stmt = con.createStatement();
				
				System.out.print("creating table...");
				String createTable = "create table Employee (NAME varchar(50) not null, JOB_TITLE varchar(150) not null, SALARY int)";
				
				stmt.execute(createTable);
				
			} catch (SQLException e) {
				System.out.println("Error: can't create data base");
				e.printStackTrace();
			}
			tableCreated = true;
		}
	}
	
	private void connectToDB() {
		if (!isConnected) {
			try {
				con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + DB_NAME);
				stmt = con.createStatement();
				isConnected = true;
			} catch (SQLException e) {
				System.out.println("Error: can't connect to data base");
				e.printStackTrace();
			}
		}
	}
	
	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addEmployee(String name, String jobTitle, int salary) {
		
		try {
			connectToDB();
			
			Formatter formatter = new Formatter();
			Formatter query = formatter.format("insert into Employee values ('%s', '%s', %s)", name, jobTitle, salary);
			System.out.println("query : "  + query.toString());
			stmt.executeUpdate(query.toString());
			return true;
		} catch (SQLException e) {
			System.out.println("Error: can't add new employee");
			e.printStackTrace();
		}
		return false;
	}
	
	public List getAllEmployees() {
		connectToDB();
		
		List employees = new LinkedList<Employee>();
		try {
			rs = stmt.executeQuery("select * from Employee");
			while (rs.next()) {
				Employee employee = new Employee();
				
				employee.setName(rs.getString("NAME"));
				employee.setJobTitle(rs.getString("JOB_TITLE"));
				employee.setSalary(rs.getInt("SALARY"));
				
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}
}
