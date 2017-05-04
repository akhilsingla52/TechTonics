package com.atmecs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	private static Connection connection;
	
	public static Connection getConnection()
	{
		if(connection==null) {
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/TECH_TONICS", "root", "root");
			}
			catch(Exception e)
			{
				System.out.println("Error : "+e.getMessage());
			}
		}
		return connection;
	}
	public static void closeConnection()
	{
		try
		{
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
