package com.atmecs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atmecs.database.DatabaseConnection;
import com.atmecs.pojo.Event;
import com.atmecs.pojo.User;

public class EventModel {
	private static Connection connection;
    private ResultSet rs;
    private List<Event>	al = null;
    private int empid;
    
	public EventModel() {
		if(connection == null)
			connection=DatabaseConnection.getConnection();
	}
	
	public List<Event> getEventList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		try
		{
			al = new ArrayList<>();
			
			if(session.getAttribute("empid") != null) {
				empid = Integer.parseInt((String)session.getAttribute("empid"));
				
				List<Integer> applied = new ArrayList<Integer>();
				rs=connection.createStatement().executeQuery("select * from REGISTER_EVENT where USER_LIST="+empid);
				
				while(rs.next()){
					applied.add(rs.getInt(1));
				}
				
				PreparedStatement statement=connection.prepareStatement("select * from EVENTS order by START_DATE desc");
				rs = statement.executeQuery();
				
				while(rs.next())
				{
					if(!applied.contains(rs.getInt(1))) {
						Event e = new Event();
						e.setEvent_id(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setType(rs.getString(3));
						e.setDescription(rs.getString(4));
						e.setStart_date(rs.getString(5));
						e.setEnd_date(rs.getString(6));
						e.setDuration(rs.getString(7));
						e.setPresenter(rs.getString(8));
						al.add(e);
					}
				}
				return al;
			} else {			
				PreparedStatement statement=connection.prepareStatement("select * from EVENTS order by START_DATE desc");
				rs = statement.executeQuery();
				
				while(rs.next())
				{
					Event e = new Event();
					e.setEvent_id(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setType(rs.getString(3));
					e.setDescription(rs.getString(4));
					e.setStart_date(rs.getString(5));
					e.setEnd_date(rs.getString(6));
					e.setDuration(rs.getString(7));
					e.setPresenter(rs.getString(8));
					al.add(e);
				}
				return al;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getSelectedEventList(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		try
		{
				List<User> al = new ArrayList<>();
				rs=connection.createStatement().executeQuery("select * from REGISTER_EVENT where EVENT_ID="+id);
				
				while(rs.next()){
					PreparedStatement statement=connection.prepareStatement("select * from users where EMP_ID="+rs.getInt(2));
					rs = statement.executeQuery();
					while(rs.next())
					{
						User user = new User();
						user.setEmp_id(rs.getInt(1));
						user.setName(rs.getString(2));
						user.setEmail_id(rs.getString(3));
						al.add(user);
					}
				}				
				return al;
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean getEventApply(HttpServletRequest request, HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		int empid = Integer.parseInt((String)session.getAttribute("empid"));
		
		try{				
				PreparedStatement preparedStatement=connection.prepareStatement("insert into REGISTER_EVENT values(?,?)");
				preparedStatement.setInt(1, id);
				preparedStatement.setInt(2, empid);
				if(preparedStatement.executeUpdate()!=0)
					return true;
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addEvent(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name"); 
		String type=request.getParameter("type"); 
		String description=request.getParameter("description"); 
		String startDate=request.getParameter("startDate"); 
		String endDate=request.getParameter("endDate"); 
		String duration=request.getParameter("duration"); 
		String presenter=request.getParameter("presenter"); 
		try{				
				PreparedStatement preparedStatement=connection.prepareStatement("insert into EVENTS(NAME, TYPE, DESCRIPTION, START_DATE, END_DATE, DURATION, PRESENTER) values(?,?,?,?,?,?,?)");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, type);
				preparedStatement.setString(3, description);
				preparedStatement.setString(4, startDate);
				preparedStatement.setString(5, endDate);
				preparedStatement.setString(6, duration);
				preparedStatement.setString(7, presenter);
				if(preparedStatement.executeUpdate()!=0)
					return true;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateEvent(HttpServletRequest request, HttpServletResponse response) {
		int id= Integer.parseInt(request.getParameter("id")); 
		String name=request.getParameter("name"); 
		String type=request.getParameter("type"); 
		String description=request.getParameter("description"); 
		String startDate=request.getParameter("startDate"); 
		String endDate=request.getParameter("endDate"); 
		String duration=request.getParameter("duration"); 
		String presenter=request.getParameter("presenter"); 
		try{				
				PreparedStatement preparedStatement=connection.prepareStatement("update EVENTS set NAME=?, TYPE=?, DESCRIPTION=?, START_DATE=?, END_DATE=?, DURATION=?, PRESENTER=? where EVENT_ID=?");
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, type);
				preparedStatement.setString(3, description);
				preparedStatement.setString(4, startDate);
				preparedStatement.setString(5, endDate);
				preparedStatement.setString(6, duration);
				preparedStatement.setString(7, presenter);
				preparedStatement.setInt(8, id);
				if(preparedStatement.executeUpdate()!=0)
					return true;	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteEvent(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try{				
			PreparedStatement preparedStatement=connection.prepareStatement("delete from EVENTS where EVENT_ID=?");
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()!=0) {
				PreparedStatement preparedStatement1=connection.prepareStatement("delete from REGISTER_EVENT where EVENT_ID=?");
				preparedStatement1.setInt(1, id);
				if(preparedStatement1.executeUpdate()!=0)
					return true;	
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editEvent(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		try{				
			PreparedStatement preparedStatement=connection.prepareStatement("select * from EVENTS where EVENT_ID=?");
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
			{
				Event e = new Event();
				e.setEvent_id(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setType(rs.getString(3));
				e.setDescription(rs.getString(4));
				e.setStart_date(rs.getString(5));
				e.setEnd_date(rs.getString(6));
				e.setDuration(rs.getString(7));
				e.setPresenter(rs.getString(8));
				request.setAttribute("e", e);		
			}

			return true;			
		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}

}
