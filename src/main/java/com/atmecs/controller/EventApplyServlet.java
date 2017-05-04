package com.atmecs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.model.EventModel;

@WebServlet("/EventApplyServlet")
public class EventApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status = new EventModel().getEventApply(request, response);
		
		if(status)
			request.setAttribute("info", "You have Successfully Applied.");
		else
			request.setAttribute("info", "You have Problem Applied.");
		
		request.getRequestDispatcher("EventServlet").forward(request, response);
	}

}
