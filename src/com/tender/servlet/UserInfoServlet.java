package com.tender.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tender.model.User;

public class UserInfoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("UserInfoServlet - GET request");
		
		HttpSession session = request.getSession();
		User loginedUser = (User) session.getAttribute("user");
		
		// Not logged in
		if( loginedUser == null ) {
			System.out.println("UserInfoServlet - user session is NULL");
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		} 
		
		System.out.println("username : " + loginedUser.getUsername());
		System.out.println("password : " + loginedUser.getPassword());			
		System.out.println("gender : " + loginedUser.getGender());	
		
        // Store info in request attribute	
		request.setAttribute("user", loginedUser);
		
        // Logined, forward to /WEB-INF/views/userInfoView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/user_info_view.jsp");
        dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("UserInfoServlet - POST request");	
	}	
	
}
