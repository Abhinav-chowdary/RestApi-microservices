package com.Abhi.WebProject.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppointymentBooking {
	
	@Autowired
	RestTemplate restTemp;
	
	public String Booking(String date, int bookingID){
		
	restTemp.postForObject("/"+date+"/"+bookingID, "Booked", String.class);
		
		return "Booking Successfull";
	}
}
