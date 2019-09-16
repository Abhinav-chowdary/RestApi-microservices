package com.Abhi.WebProject.ServiceClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Abhi.WebProject.Entities.BookingDetails;
import com.Abhi.WebProject.Interfaces.BookingsRepo;

@Component
public class Bookings {
	
	@Autowired
	BookingsRepo bookingsRepo;
	
	int bookingID;

	
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	public int RegisterBooking(int userId,String userName, String date) throws ParseException {
		
		System.out.println("im here");
		try {
		bookingID = bookingsRepo.findByBookingMax();
		bookingID += bookingID ;
		}finally {
			if(bookingID <= 0) {
				bookingID = 1;
			}
		}
		
		BookingDetails bookingDetails = new BookingDetails(userId, userName, sd.parse(date) , "confirmed", bookingID);
		bookingsRepo.save(bookingDetails);
		
		return bookingID;
	}

	
	public Optional<BookingDetails> Appointments(int bookingID) {
		
		return bookingsRepo.findById(bookingID);
	}
	
	public void DelBooking(int bookingID) {
		
		bookingsRepo.deleteById(bookingID);
	
	}
}
