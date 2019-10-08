package com.Abhi.WebProject.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import com.Abhi.WebProject.POJOS.Booking;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppointmentBooking {
	boolean success = false;
	String response;
	String postCallResponse;
	
	@Autowired
	RestTemplate restTemp;
	
	public AppointmentBooking() {}
	
	/*Sending booking details to staff API to make the booking finalised*/
	public String BookingNewAppointment(long iD, String name, String date, int bookingID){
		
		Booking booking =  new Booking(iD, name, date, Integer.toString(bookingID));
		try {
			postCallResponse = restTemp.postForObject("URL",booking, String.class);
			success = true;
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			response = (!success)? "Booking Failed" : "Booking Successfull";
		}
		return response;
	}
}
