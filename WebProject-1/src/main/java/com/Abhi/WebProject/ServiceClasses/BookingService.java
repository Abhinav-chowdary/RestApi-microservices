package com.Abhi.WebProject.ServiceClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Abhi.WebProject.Entities.BookingDetails;
import com.Abhi.WebProject.Interfaces.BookingsRepo;

@Component
public class BookingService {
	
	@Autowired
	BookingsRepo bookingsRepo;
	
	int bookid;
	
	Optional<BookingDetails> bookingID;
	
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	public int RegisterBooking(int userId,String userName, String date) throws ParseException {
		
		System.out.println("im here");
		try {
		System.out.println(bookingsRepo.findTopByBookingID().toString());
		
		bookid = bookingsRepo.findTopByBookingID().get(0).get("_id");
		++bookid;
		
		}finally {
			if(bookid <= 0) {
				bookid=1;
			}
		}
		
		BookingDetails bookingDetails = new BookingDetails(userId, userName, sd.parse(date) , "confirmed", bookid);
		bookingsRepo.save(bookingDetails);
		
		return bookid;
	}

	
	public Optional<BookingDetails> Appointments(int bookingID) {
		
		return bookingsRepo.findById(bookingID);
	}
	
	public void DelBooking(int bookingID) {
		
		bookingsRepo.deleteById(bookingID);
	
	}
}
