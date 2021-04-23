package project_reservation;

import java.io.FileNotFoundException;
import java.util.List;

public interface WriteAndRead {

		public void writeToFile(String filename, List<Reservation> list);
		
		public void getBookingsFromFile(String filename) throws FileNotFoundException;
		
		
		
	
}
