package com.Abhi.WebProject.Classes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.Abhi.WebProject.Entities.BookingDetails;
import com.Abhi.WebProject.ServiceClasses.BookingService;;


@RestController
public class ManageBooking {
	
	BookingDetails bookingData;
	boolean userSearchResponse = false;
	boolean success = false;
	String response;
	
	@Autowired
	RestTemplate restTemp;
	@Autowired
	BookingService bookingService;
	@Autowired
	BookingDetails bookingDetails;
	
	
	/*This Method takes Booking ID as input and search for Booking details in database.
	 If Booking details are unavailable , Default vales will be returned*/
	
	@CrossOrigin(origins="*")
	@GetMapping("/Booking/{bookingID}")
	public BookingDetails BookingManager(@PathVariable("bookingID") int bookingID){
		
		try {
			Optional<BookingDetails> bookingData = bookingService.Appointments(bookingID);
			userSearchResponse = (!bookingData.isPresent()) ? false: true;
			
		}catch(Exception e) {
			System.out.println();
		}finally {			
			if(!userSearchResponse) {
				bookingData = bookingDetails.DefaultBookingDetails();
			}			
		}
		
		return bookingData;
	}
	
	
	
	/*This method will take bookingID as input and remove details related to given booking ID from database.
	 * Returns "Cancellation Failed , Please try again" if failed to remove and "booking Cancelled" if successful.
	 */
	@DeleteMapping("/updateBooking/{bookingID}")
	public String CancelBooking(@PathVariable("bookingID") int bookingID){
		
		try {
			bookingService.DelBooking(bookingID);
			success=true;
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			response = (!success) ? "Cancellation Failed , Please try again" : "booking Cancelled";
		}
				
		return response;
	}
}
