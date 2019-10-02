package com.Abhi.WebProject.ServiceClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Abhi.WebProject.Entities.BookingDetails;
import com.Abhi.WebProject.Interfaces.BookingsRepo;
import com.opengamma.strata.collect.Unchecked;

@Component
public class BookingService {
	
	Integer bookingId;
	boolean success= false;
	
	@Autowired
	BookingsRepo bookingsRepo;
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

	public Integer RegisterBooking(int userId,String userName, String date){
		
		return Unchecked.wrap(() -> {
			bookingId = bookingsRepo.findTopByBookingID().get(0).get("_id");
			bookingId = (bookingId <= 0)? bookingId=1 : ++bookingId;
			System.out.println(bookingId);
			BookingDetails bookingDetails = new BookingDetails(userId, userName, sd.parse(date) , "confirmed", bookingId);
				bookingsRepo.save(bookingDetails);
			return bookingId;
		});
	}

	public Optional<BookingDetails> Appointments(int bookingID) {	
		return bookingsRepo.findById(bookingID);
	}
	
	public void DelBooking(int bookingID) {
		bookingsRepo.deleteById(bookingID);
	}
}
