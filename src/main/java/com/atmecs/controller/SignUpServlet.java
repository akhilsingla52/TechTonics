package com.atmecs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.model.SignUpModel;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status = new SignUpModel().getSignUpUser(request, response);
				
		if(status == 0) {
			request.setAttribute("info", "User Already registered.");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		else {
			request.setAttribute("info", "You have Successfully Registered! You can SignIn now");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}
}
