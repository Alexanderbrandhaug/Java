
package test_project;

import project_reservation.Hotel;
import project_reservation.Reservation;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelTest {
	
	private Hotel hotel;
	private Reservation reservation;
	private List <Reservation> testList = new ArrayList<Reservation>();
	
	@BeforeEach
	public void setup() {
		reservation = new Reservation(0, "Alex test", "test@gmail.com","99223388",LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		hotel = new Hotel();
		hotel.addBooking(reservation);
		testList.add(reservation);
	}
	
	
	@Test
	public void testAddBookings() {
		reservation = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			hotel.addBooking(reservation);
			
		});
	
	}
	
	@Test
	public void testDeleteBookings() {
		Assertions.assertEquals(1, hotel.getNumberOfBookings());
		reservation = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,16), 0);
		hotel.addBooking(reservation);
		Assertions.assertEquals(2, hotel.getNumberOfBookings());
		hotel.deleteBooking(1);
		Assertions.assertEquals(1, hotel.getNumberOfBookings());
		hotel.deleteBooking(0);
		hotel.deleteBooking(5);
		Assertions.assertEquals(1, hotel.getNumberOfBookings());
		
	}
	@Test
	public void testReservationList() {
		reservation = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,16), 0);
		hotel.addBooking(reservation);
		testList.add(reservation);
		Assertions.assertEquals(testList, hotel.getAllBookings());
		
	}
	 @Test
	 public void testGetBooking() {
		 reservation = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,16), 0);
		 Reservation res1 = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,11), LocalDate.of(2022,01,16), 0);
		 Reservation res2 = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,10), LocalDate.of(2022,01,16), 0);
		 hotel.addBooking(reservation);
		 hotel.addBooking(res1);
		 hotel.addBooking(res2);
		 Assertions.assertEquals(reservation, hotel.getBooking(2));
		 Assertions.assertEquals(res2, hotel.getBooking(4));
		 hotel.deleteBooking(1);
		 Assertions.assertEquals(res2, hotel.getBooking(4));
		 
		 
	 }
	 @Test
	 public void testGetLatestBooking() {
		 reservation = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,16), 0);
		 Reservation res1 = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,11), LocalDate.of(2022,01,16), 0);
		 Reservation res2 = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,10), LocalDate.of(2022,01,16), 0);
		 hotel.addBooking(reservation);
		 hotel.addBooking(res1);
		 hotel.addBooking(res2);
		 Assertions.assertEquals(res2, hotel.getLatestBooking());
		 hotel.deleteBooking(4);
		 Assertions.assertEquals(res1, hotel.getLatestBooking());
		 
	 }
	 
	 @Test
	 public void testID() {
		 Assertions.assertEquals(1, reservation.getId());
		 Reservation res = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,16), 0);
		 hotel.addBooking(res);
		 Assertions.assertEquals(2, res.getId());
		 hotel.deleteBooking(1);
		 Reservation res1 = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,18), 0);
		 hotel.addBooking(res1);
		 Assertions.assertEquals(3, res1.getId());
		 hotel.deleteBooking(3);
		 Reservation res2 = new Reservation(0, "Alex test", "test@gmail.com", "99283455",LocalDate.of(2022,01,12), LocalDate.of(2022,01,20), 0);
		 hotel.addBooking(res2);
		 Assertions.assertEquals(3, res2.getId());
		
		 
	 }
}
