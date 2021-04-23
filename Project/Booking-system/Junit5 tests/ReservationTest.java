package test_project;

import project_reservation.Reservation;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;






public class ReservationTest {
	
	private Reservation reservation;

	
	@BeforeEach
	public void setup() {
		reservation = new Reservation(0, "Alex test", "test@gmail.com","99223388",LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
	}
	@Test
	public void testConstructor() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Reservation(0,"Alex", "test@gmail.com", "99223388", LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Reservation(0,"Alex ", "test@gmail.com", "99223388", LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Reservation(0,"Alex test", "testgmail.com", "99223388", LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Reservation(0,"Alex", "test@gmail.com", "9922338", LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Reservation(0,"Alex", "test@gmail.com", "992233af", LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		});
	}
	
	
	@Test
	public void testSetName() {
		reservation.setName("Alex Brandhaug");
		Assertions.assertEquals("alex brandhaug", reservation.getName());
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setName("Al");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setName("Alex 92");
		});
	
	}	
	
	@Test
	public void testEmail() {
		reservation.setEmail("test@gmail.com");
		Assertions.assertEquals("test@gmail.com", reservation.getEmail());
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setEmail("testgmail.com");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setEmail("test@gmailcom");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setEmail("test@gmail.com ");
		});
	}
	@Test
	public void testPhoneNum() {
		reservation.setPhoneNumber("99001122");
		Assertions.assertEquals("99001122", reservation.getPhoneNumber());
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setPhoneNumber("11223344");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setPhoneNumber("992233440");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setPhoneNumber("22334455");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setPhoneNumber("33223344");
		});
	}
	@Test
	public void testDates() {
		reservation.setFromDate(LocalDate.of(2021,06,12));
		Assertions.assertEquals(LocalDate.of(2021,06,12), reservation.getFromDate());
		reservation.setToDate(LocalDate.of(2021,06,15));
		Assertions.assertEquals(LocalDate.of(2021,06,15), reservation.getToDate());
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setFromDate(LocalDate.of(2020,06,12));
			
		});
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			reservation.setToDate(LocalDate.of(2021,06,11));
		
		
		});
	}
	@Test
	public void testPrice() {
		reservation.setPrice();
		Assertions.assertEquals(2697, reservation.getPrice());
		reservation.setFromDate(LocalDate.of(2022,01,14));
		reservation.setPrice();
		Assertions.assertEquals(899, reservation.getPrice());
	}
}
