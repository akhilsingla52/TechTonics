package com.atmecs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.model.EventModel;

@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = new EventModel().addEvent(request, response);

		if(status)
			request.setAttribute("info", "You have Successfully Added.");
		else
			request.setAttribute("info", "Some problem in add.");
		
		request.getRequestDispatcher("EventServlet").forward(request, response);
	}

}
