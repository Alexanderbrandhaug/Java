package test_project;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import project_reservation.Hotel;
import project_reservation.Reservation;
import project_reservation.WriteRead;

public class TestWriteRead {
	private WriteRead writer = new WriteRead();
	private Hotel hotel = new Hotel();
	private Reservation reservation;
	private List <Reservation> testList = new ArrayList<Reservation>();
 	
	
	@BeforeEach
	public void setup() {
		reservation = new Reservation(0, "Alex test", "test@gmail.com","99223388",LocalDate.of(2022,01,12), LocalDate.of(2022,01,15), 0);
		reservation.setPrice();
		hotel.addBooking(reservation);
		testList.add(reservation);
	
}
	@Test
	public void testSaveToFile() throws FileNotFoundException {
		writer.writeToFile("testdoc", testList);
		writer.getBookingsFromFile("testdoc");
		Assertions.assertEquals(testList, hotel.getAllBookings());
		reservation = new Reservation(2, "Alex test", "test@gmail.com","99223388",LocalDate.of(2022,01,11), LocalDate.of(2022,01,15), 0);
		hotel.addBooking(reservation);
		testList.add(reservation);
		writer.writeToFile("testdoc", testList);
		writer.getBookingsFromFile("testdoc");
		Assertions.assertEquals(testList, hotel.getAllBookings());
		testList.clear();
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			writer.writeToFile("testdoc", testList);
		});
		
		
	}
	
	@Test
	public void testLoadFromFile() throws FileNotFoundException {
	reservation = new Reservation(0, "Alex test", "test@gmail.com","99223388",LocalDate.of(2022,01,11), LocalDate.of(2022,01,19), 0);
	reservation.setPrice();
	testList.add(reservation);
	writer.writeToFile("testdoc", testList);
	writer.getBookingsFromFile("testdoc");
	Assertions.assertEquals(testList.toString().trim(), writer.hotel.getAllBookings().toString().trim());
	Assertions.assertThrows(FileNotFoundException.class, () ->{
		writer.getBookingsFromFile("abcd");
	});
		
	}
}
