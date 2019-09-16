package com.Abhi.WebProject.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import com.Abhi.WebProject.POJOS.Booking;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppointymentBooking {
	
	@Autowired
	RestTemplate restTemp;
	
	public String Booking(long iD, String name, String date, int bookingID){
		
		Booking booking =  new Booking(iD, name, date, Integer.toString(bookingID));
		
	restTemp.postForObject("URL",booking, String.class);
		
		return "Booking Successfull";
	}
}
