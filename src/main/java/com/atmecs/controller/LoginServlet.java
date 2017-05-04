package com.atmecs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.model.LoginModel;

@WebServlet("/signin")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int status = new LoginModel().getUserLogin(request, response);
		if(status == 0) {
			request.setAttribute("info", "Incorrect Username or Password.");
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}
		else if(status == 1)
			request.getRequestDispatcher("home_hr.jsp").forward(request, response);
		else if(status == 2)
			request.getRequestDispatcher("home_user.jsp").forward(request, response);
	}
 
}
