package com.tender.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final String LOGIN = "/WEB-INF/views/login.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet - GET request");
		
		//forward request to /WEB-INF/views/login.jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(LOGIN);	
		dispatcher.forward(request, response);
	}

}
