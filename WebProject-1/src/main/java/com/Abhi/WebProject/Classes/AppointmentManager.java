package com.Abhi.WebProject.Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.Abhi.WebProject.POJOS.BookingData;
import com.Abhi.WebProject.ServiceClasses.BookingService;
import com.opengamma.strata.collect.Unchecked;

@RestController
public class AppointmentManager {
	
	Date date;
	Date currentDate;
	boolean success = false;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AppointmentBooking newAppointment;
	SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
	
	/* This method will accept the date and request availability of staff from StaffAvailability API. 
	If staff/slot is available it will return response (String). This method follows Swedish time Zone  */
	@GetMapping(path="/Availability/{Date}")
	public String AvailableSlots(@PathVariable("Date") String appdate){	
		return Unchecked.wrap( () -> {
			String response = null;
			sd.setTimeZone(TimeZone.getTimeZone("Europe/Stockholm"));
			date = sd.parse("20190912");
			currentDate = sd.parse(sd.format(new Date()));
			if(date.compareTo(currentDate) >= 0){	
				int slotAvailablity = restTemplate.getForObject("http://L-SE-0592.europe.corp.altran.com:9123/availableslots/"
																+date,Integer.class);			
				response = (slotAvailablity > 1) ? "AVAILABLE" : "NOTAVAILABLE";
			}else {
				response = "Please choose a valid date and try again";
				}
						return response;
		});		
	}
	
	
	/* This method will accept the booking request with details and update them in database with unique Booking-Id. 
	It will return Booking-ID(Integer)  */
	@PostMapping(path="/booking")
	public int SaveAppointmentDetails(@RequestBody BookingData data) throws ParseException, InterruptedException{
//		Unchecked.wrap( () -> {				int bookingID = 0;				int iD;				bookingID = bookingService.RegisterBooking(data.getUserId(),data.getUserName(),data.getDate());
				System.out.println(bookingID);				iD = bookingID;				//		AppointmentBooking newAppointment= new AppointmentBooking(); 		//		String message =  newAppointment.BookingNewAppointment(data.getUserId(),data.getUserName(),data.getDate(),bookingID);		
//				Supplier<String> message = (() -> {return newAppointment.BookingNewAppointment(data.getUserId(),data.getUserName(),data.getDate(),iD);});				System.out.println(bookingID+" ");
//		});
		
		return bookingID;
		
	}

}

	
	
	
	
	
	
	
	
	
	
	
	
	