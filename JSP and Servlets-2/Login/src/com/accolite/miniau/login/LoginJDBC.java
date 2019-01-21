package com.accolite.miniau.login;

import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginJDBC {
	
	
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost/mydb";
			String username = "root";
			String password = "root";
			Connection con=DriverManager.getConnection(url, username, password);  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from users where username=? and password=?");  
		ps.setString(1,name);  
		ps.setString(2,pass);  

		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		System.out.println(status);
		if(status==false) {
			System.out.println("Invalid login by "+name);
		}
		
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
	public static ArrayList<String> returnDetails(String name) {
		try {	
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost/mydb";
			String username = "root";
			String password = "root";
			Connection con=DriverManager.getConnection(url, username, password);  
			PreparedStatement ps1=con.prepareStatement(  
				"select * from users where username=?");
			ps1.setString(1, name);
			//ps1.executeQuery();
			ResultSet rs=ps1.executeQuery();
			rs.next();
			String user=rs.getString(1);
			String pass=rs.getString(2);
			String nickname=rs.getString(3);
			String city=rs.getString(4);
			
			ArrayList<String> arr=new ArrayList<>();
			arr.add(user);
			arr.add(pass);
			arr.add(nickname);
			arr.add(city);
			
			return arr;
			
		}
		catch(Exception e) {
			System.out.println(e);
			return null;				
		}
	}
}
