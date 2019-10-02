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
	
	int bookingId=0;
	boolean success= false;
	
	@Autowired
	BookingsRepo bookingsRepo;
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	public int RegisterBooking(int userId,String userName, String date) throws ParseException {
		
		try {
			bookingId = bookingsRepo.findTopByBookingID().get(0).get("_id");
			++bookingId;
		}catch(Exception e){
			System.out.println(e);
		}finally {
			if(bookingId <= 0) {
				bookingId=1;
			}
		}
		
		BookingDetails bookingDetails = new BookingDetails(userId, userName, sd.parse(date) , "confirmed", bookingId);
		
		try {
			bookingsRepo.save(bookingDetails);
			success = true;
		}catch(Exception e) {
			System.out.println(e);
		}finally{
			bookingId = (!success)? 0 : bookingId ;
		}	
		return bookingId;
	}

	public Optional<BookingDetails> Appointments(int bookingID) {	
		return bookingsRepo.findById(bookingID);
	}
	
	public void DelBooking(int bookingID) {
		bookingsRepo.deleteById(bookingID);
	}
}
