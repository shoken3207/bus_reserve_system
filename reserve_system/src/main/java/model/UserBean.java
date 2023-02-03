package model;

import java.io.Serializable;

public class UserBean implements Serializable {
	private int userId, phone;
	private String password, email, name;
	
	public UserBean() { }
	
	public UserBean(int userId, String password, String email, String name, int phone) {
		this.setUserId(userId);
		this.setPassword(password);
		this.setEmail(email);
		this.setName(name);
		this.setPhone(phone);
	}

	public UserBean(String password, String email, String name, int phone) {
		this.setPassword(password);
		this.setEmail(email);
		this.setName(name);
		this.setPhone(phone);
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
