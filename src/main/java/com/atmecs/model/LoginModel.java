package com.atmecs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.database.DatabaseConnection;

public class LoginModel {

    private static Connection connection;   
    
	
	public LoginModel() {
		if(connection == null)
			connection=DatabaseConnection.getConnection();
	}
	
	public int getUserLogin(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			PreparedStatement statement=connection.prepareStatement("select * from USERS where EMAIL_ID=? and PASSWORD=?");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next())
			{
				String role = resultSet.getString(5);
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("empid", resultSet.getString(1));
				httpSession.setAttribute("email", email);
				httpSession.setAttribute("role", role);
				if(role.equals("role_user"))
					return 2;
				else if(role.equals("role_hr"))
					return 1;
			}
			else {
				return 0;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public void getUserLogout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("email");
		session.removeAttribute("role");
		session.invalidate();
	}
	
}
