package com.Abhi.WebProject.POJOS;

import org.springframework.stereotype.Component;

@Component
public class Booking {

		private long id;
		private String userID;
		private String bookedDate;
		private String bookingID;

		public Booking(){}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}

		public String getBookedDate() {
			return bookedDate;
		}

		public void setBookedDate(String bookedDate) {
			this.bookedDate = bookedDate;
		}

		public String getBookingID() {
			return bookingID;
		}

		public void setBookingID(String bookingID) {
			this.bookingID = bookingID;
		}

		public Booking(long id, String userID, String bookedDate, String bookingID) {
			super();
			this.id = id;
			this.userID = userID;
			this.bookedDate = bookedDate;
			this.bookingID = bookingID;
		}

		@Override
		public String toString() {
			return "Booking [id=" + id + ", userID=" + userID + ", bookedDate=" + bookedDate + ", bookingID=" + bookingID
					+ "]";
		}
	}
