package com.chainsys.spring.model;

public class UserInfo {
	
	private int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String password;
	private String email;
	
}
