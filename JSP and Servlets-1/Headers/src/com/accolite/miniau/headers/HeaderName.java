package com.accolite.miniau.headers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderName
 */
@WebServlet("/HeaderName")
public class HeaderName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Enumeration<String> hNames = request.getHeaderNames();
		response.getWriter().println("<table border=\"1\">");
		response.getWriter().println("<th><b>Header</b></th><th><b>Header Name</b></th>");
		while(hNames.hasMoreElements()) {
		  String hName = (String)hNames.nextElement();
		  response.getWriter().println("<tr>");
		  response.getWriter().println("<td>" + hName+"</td><td>"+ request.getHeader(hName)+"</td>");
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
