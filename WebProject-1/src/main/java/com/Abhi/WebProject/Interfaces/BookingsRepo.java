package com.Abhi.WebProject.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Abhi.WebProject.Entities.BookingDetails;

public interface BookingsRepo extends JpaRepository<BookingDetails, Integer>{

	
//	@Query(value="select BookingID from BOOKING_DETAILS order by BookingID desc")
//	Integer findTop1ByOrderByBookingIDDesc();
	
	@Query(value="select IFNULL(max(BOOKINGID),0) from BOOKING_DETAILS",nativeQuery = true)
	Integer findByBookingMax();

}
