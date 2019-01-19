package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Updation
 */
@WebServlet("/Updation")
public class Updation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("UPDATE SUCCESSFUL");
		response.setContentType("text/html");   
	          
	    String n=request.getParameter("user");  
	    //String p=request.getParameter("pwd");
	    String nick=request.getParameter("nick");  
	    //String city=request.getParameter("city");  
	    
	    try{  
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost/mydb";
			String username = "root";
			String password = "root";
			Connection con=DriverManager.getConnection(url, username, password);  
		      
		Statement ps=con.createStatement(); 
		String sql = "update users set nickname='"+nick+"' where username='"+n+"'";  
		//ps.setString(1,n);  
		      
		int stt = ps.executeUpdate(sql);  
	 
		System.out.println(stt);
		
		          
		}catch(Exception e){System.out.println(e);}  
	}

}
