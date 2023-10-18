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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//String userId =request.getParameter("user Id");
		String userId =request.getParameter("userId");
		String pass = request.getParameter("password");
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
			String query = "select * from tblemployee where empid = '"+userId+"' and password = '"+pass+"'";
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				out.print("<h1>"+userId+": Welcome to Home page</h1><br>");
				out.print("<h1>Login Successfully</h1><br>");
				response.sendRedirect("Userdashboard.jsp");
			}else {
				out.print("<h1>"+userId+": please enter correct userid and password</h1<br>");
				out.print("<h1>Login Failed</h1><br>");
			
			}
			rs.close();
			st.close();
			con.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			out.print("<h1>Login Failed! because of server exception</h1><br>");

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.print("<h1>Login Failed! because of server exception</h1><br>");
			e.printStackTrace();
		}
		
		out.print("User Id: "+userId);
		out.print("Password: "+pass);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
