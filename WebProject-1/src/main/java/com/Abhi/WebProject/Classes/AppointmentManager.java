package com.Abhi.WebProject.Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Abhi.WebProject.POJOS.BookingData;
import com.Abhi.WebProject.ServiceClasses.Bookings;

@RestController
public class AppointmentManager {
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Bookings bookings;
	
	SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
	Date date;
	Date currentDate;
	
	
	@GetMapping(path="/Availability/{Date}")
	public boolean AvailableSlots(@PathVariable("Date") String appdate) throws Exception {
		
		date = sd.parse("20190912");
		currentDate = sd.parse(sd.format(new Date()));
		
	if(date.compareTo(currentDate) >= 0){	//comparing date received with current date. 
											//If date is equal or grater than current date then it will check availability	
		
			
		int slotAvailablity = restTemplate.getForObject("http://L-SE-0592.europe.corp.altran.com:9123/availableslots/"
		+date,Integer.class);
			
			if(slotAvailablity > 1) {
				return true;
			}else {
				return false;
			}
				
	}else {		
		
			return false;
			
	}
	
	}
	
	@PostMapping(path="/booking")
	public int BookingManager(@RequestBody BookingData data) throws ParseException{
		
		System.out.println("lets see");
		int bookingID = bookings.RegisterBooking(data.getUserId(),data.getUserName(),data.getDate());
				
//		AppointymentBooking aB= new AppointymentBooking();
//		String message =  aB.Booking(data.getUserId(),data.getUserName(),data.getDate(),bookingID,);
		return bookingID;
	}

}
