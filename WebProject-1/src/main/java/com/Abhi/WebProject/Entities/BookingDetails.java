package com.Abhi.WebProject.Entities;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class BookingDetails {
		
	private int 	userId;
	private String 	userName;
	private	Date	date;
	private	String	bookingStatus;
	@Id
	private	int		bookingID;
	
	public BookingDetails(){}
	
	public BookingDetails(int userId, String userName, Date date, String bookingStatus, int bookingID) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.date = date;
		this.bookingStatus = bookingStatus;
		this.bookingID= bookingID;
	}
	
	public BookingDetails DefaultBookingDetails(){
		BookingDetails bookingDetails = new BookingDetails(0,"Default",new Date(),"UnKonwn",0);
		return bookingDetails;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
}
