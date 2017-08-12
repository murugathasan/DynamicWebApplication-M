package com.tender.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tender.model.User;

public class DoLoginServlet extends HttpServlet {
	
	private static final String LOGIN = "/WEB-INF/views/login.jsp";
	private static final String LOGIN_SUCCESS = "/WEB-INF/views/login.jsp";
	
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoLoginServlet - GET request");
		
		//forward request to /WEB-INF/views/login.jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(LOGIN);	
		dispatcher.forward(request, response);
	}*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoLoginServlet - POST request");
		
		
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		User user = null;
		boolean hasError = false;
		String errorMessage = "";
		

		if(userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			
			hasError = true;
			errorMessage = "Please enter username and password";
			System.out.println("Please enter username and password");
		} else {
			if(userName.equalsIgnoreCase("muru") && password.equalsIgnoreCase("password")){
				System.out.println("login success");
				user = new User();
				user.setUsername(userName);
				user.setPassword(password);
				user.setGender("male");
			} else {
				hasError = true;
				errorMessage = "Wrong username or password";
				System.out.println("Wrong username or password");
			}
		}
		
		

        // If error, forward to /WEB-INF/views/login.jsp
		if(hasError){

			
			user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			
			// Store information in request attribute, before forward.
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("user", user);
			
			//forward request to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(LOGIN);	
			dispatcher.forward(request, response);
		} 
		
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
		else {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/userInfo");
		}
		

		

	}

}
