package com.atmecs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.model.EventModel;
import com.atmecs.pojo.User;

@WebServlet("/ListEventServlet")
public class ListEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> al = new EventModel().getSelectedEventList(request, response);
		
		if(al==null || al.isEmpty())
			request.setAttribute("info", "No Records Found.");
		else
			request.setAttribute("list", al);
		
		
		request.getRequestDispatcher("event_register.jsp").forward(request, response);
	}

}
