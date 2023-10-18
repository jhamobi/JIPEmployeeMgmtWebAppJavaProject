package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoadUsersDataServlet")
public class LoadUsersDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadUsersDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//JDBC Connection
		try {
			  Class.forName("org.postgresql.Driver");
		      String dbName = System.getProperty("employeedb");
		      String userName = System.getProperty("admin");
		      String password = System.getProperty("Yofundo01$");
		      String hostname = System.getProperty("yufondo-db.c1xosa2sqoup.ap-south-1.rds.amazonaws.com");
		      String port = System.getProperty("3306");
		      String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
		      Connection con = DriverManager.getConnection(jdbcUrl);

			Statement st = con.createStatement();
			String query = "SELECT  empid  ,firstname ,lastname,email,JoiningDate,Mobile,salary ,Address FROM tblemployee";
					
			ResultSet  rs = st.executeQuery(query);
			out.println("<body><div align='center'><h1>Users Data</h1></div></br>");
			out.println("<table border=1>");  
            out.println("<tr><th>EmpId</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Joining date</th><th>Mobile</th><th>salary</th><th>Address</th><tr>");  
            while (rs.next()) 
            {  
            	String empid = rs.getString("empid");  
                String firstname = rs.getString("firstname");  
                String lastname = rs.getString("lastname");  
                String email = rs.getString("email"); 
                String JoiningDate = rs.getString("JoiningDate");  
                String Mobile = rs.getString("Mobile"); 
                String salary = rs.getString("salary");  
                String Address = rs.getString("Address"); 
				
                out.println("<tr><td>" + empid + "</td><td>" + firstname + "</td><td>" + lastname + "</td><td>" + email + "</td><td>" + JoiningDate + "</td><td>" + Mobile +"</td><td>" + salary + "</td><td>" + Address + "</td></tr>");   
			}
			out.println("</table>");  
            out.println("</html></body>");  
            st.close();  
			con.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print("<h1>Employee data loading Failed! because of server exception</h1><br>");

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("<h1>Employee data loading Failed!! because of server exception</h1><br>");
			e.printStackTrace();
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
