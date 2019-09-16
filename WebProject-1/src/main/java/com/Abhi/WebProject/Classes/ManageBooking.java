package com.Abhi.WebProject.Classes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.Abhi.WebProject.Entities.BookingDetails;
import com.Abhi.WebProject.ServiceClasses.Bookings;


@RestController
public class ManageBooking {
	@Autowired
	RestTemplate restTemp;
	@Autowired
	Bookings bookings;
	
	
	
	@GetMapping("/Booking/{bookingID}")
	public Optional<BookingDetails> BookingManager(@PathVariable("bookingID") int bookingID){
				
		
		return bookings.Appointments(bookingID);
	}

	@PutMapping("/updateBooking/{bookingID}")
	public String UpdateBooking(@PathVariable("bookingID") int bookingID){
		
		bookings.DelBooking(bookingID);
		
/*		try {
			restTemp.put("",bookingID);
		} catch (RestClientException e) {
//			SyslogOutputStream("error with rest call", e);
		}*/
		
		
		return "booking Cancelled";
	}
}
