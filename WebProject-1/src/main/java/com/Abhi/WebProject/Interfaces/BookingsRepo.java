package com.Abhi.WebProject.Interfaces;
import java.util.List;
import java.util.Map;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.Abhi.WebProject.Entities.BookingDetails;

@EnableMongoAuditing
public interface BookingsRepo extends MongoRepository<BookingDetails, Integer> {

	
	@Query(fields = "{_id : 1}", value = "{}",sort = "{_id :-1}")
	List<Map<String, Integer>> findTopByBookingID();
	

}
