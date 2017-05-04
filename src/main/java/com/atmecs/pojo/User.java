package com.atmecs.pojo;

public class User {
	private int emp_id;
	private String name;
	private String email_id;
	private String password;
	private String role;
	
	public User() {
		this(0,"","","","");
	}
	
	public User(int emp_id, String name, String email_id, String password, String role) {
		this.emp_id = emp_id;
		this.name = name;
		this.email_id = email_id;
		this.password = password;
		this.role = role;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [emp_id=" + emp_id + ", name=" + name + ", email_id=" + email_id + ", password=" + password
				+ ", role=" + role + "]";
	}
}
