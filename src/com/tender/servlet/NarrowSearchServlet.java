package com.tender.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class NarrowSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NarrowSearchServlet - GET request");
		
		//dispatch the request to /WEB-INF/views/narrow_search.jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/narrow_search.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NarrowSearchServlet - POST request");		
		
		String companySize = "0";
		companySize = request.getParameter("company_size");
		System.out.println("Size of the Company : " + companySize);
		request.setAttribute("companySize", companySize);
		
		
	}
	
}
