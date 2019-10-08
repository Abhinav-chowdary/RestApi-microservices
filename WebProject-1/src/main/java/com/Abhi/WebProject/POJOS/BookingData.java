package com.Abhi.WebProject.POJOS;

import org.springframework.stereotype.Component;

@Component
public class BookingData {
	
	private int 	userId;
	private String 	userName;
	private	String	date;
	
	public BookingData() {}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
}
