package com.atmecs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");

		if(role==null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		else if(role.equals("role_hr"))
			request.getRequestDispatcher("home_hr.jsp").forward(request, response);
		else if(role.equals("role_user"))
			request.getRequestDispatcher("home_user.jsp").forward(request, response);
		else
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
