package com.atmecs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmecs.database.DatabaseConnection;

public class SignUpModel {
	private static Connection connection;   
    
	public SignUpModel() {
		if(connection == null)
			connection=DatabaseConnection.getConnection();
	}
	
	public int getSignUpUser(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		try{
			ResultSet rs=connection.createStatement().executeQuery("select * from USERS where EMAIL_ID="+"'"+email+"'");
			
			if(rs.next()){
				return 0;
			}
			else{
				int empid=Integer.parseInt(request.getParameter("empid"));
				String name=request.getParameter("firstname") + " " + request.getParameter("lastname");
				String password=request.getParameter("password");
				String role="role_user";
				
				PreparedStatement preparedStatement=connection.prepareStatement("insert into USERS values(?,?,?,?,?)");
				preparedStatement.setInt(1, empid);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, email);
				preparedStatement.setString(4, password);
				preparedStatement.setString(5, role);
				if(preparedStatement.executeUpdate()!=0)
				{
					return 1;					 
				}
				else
				{
					System.out.println("Some problem in registration");
				}
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return 0;
	}
}
