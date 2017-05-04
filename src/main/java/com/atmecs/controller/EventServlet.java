package com.atmecs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.model.EventModel;
import com.atmecs.pojo.Event;

@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Event> al = new EventModel().getEventList(request, response);
		
		if(al==null || al.isEmpty())
			request.setAttribute("info", "No Records Found.");
		else
			request.setAttribute("list", al);
		
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");

		if(role == null)
			request.getRequestDispatcher("event.jsp").forward(request, response);
		else if(role.equals("role_user"))
			request.getRequestDispatcher("event_user.jsp").forward(request, response);
		else if(role.equals("role_hr"))
			request.getRequestDispatcher("event_hr.jsp").forward(request, response);
		else
			request.getRequestDispatcher("event.jsp").forward(request, response);
	}

}
