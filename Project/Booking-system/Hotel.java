
package project_reservation;
import java.util.ArrayList;
import java.util.List;


		public class Hotel {
	    private List <Reservation> reservations = new ArrayList<Reservation>();
	    private int ID;
	    
	 
		public void addBookingFromFile(Reservation reservation) {
			reservations.add(reservation);
		}
		
	
			
	   
		public void addBooking(Reservation reservation) {
			if(reservations.isEmpty()) {
				ID++;
				reservation.setId(ID);
		
				reservations.add(isBooked(reservation));
				
			}
			
			else {
				
		
			ID = getLatestBooking().getId()+1;
			reservation.setId(ID);
			reservations.add(isBooked(reservation));
		
			
			
			}
			
		}
		
		
		public Reservation getBookingObj(Reservation reservation) {
			return reservation;
			
			
		}
		public void setIdWhenLoad(int i) {
			this.ID = i;
		}
		
	
		
		public int getNumberOfBookings() { // returns the number of all current bookings. 
			return reservations.size();
		}
			
		public Reservation getBooking(int i) {
			for(Reservation ele: reservations) {
				if(ele.getId() == i) {
					return ele;
				}
			}
			return null;
		}
		
		public void deleteBooking(int i) {
			 if(reservations.size() == 1) {
				 reservations.remove(getBooking(i));
				 ID = 0;
			 } else {
			reservations.remove(getBooking(i));
			ID = getLatestBooking().getId();
 
		
 
		}
		}
 
		public Reservation getLatestBooking() {
			return reservations.stream()
					.filter((reservation) -> reservation.getId() == reservation.getId())
					.max((reservation1, reservation2) -> reservation1.getId() - reservation2.getId())
					.get();
		}
	
		

	
		
		public Reservation isBooked(Reservation reservation) {
			boolean available = true;
			for(int i = 0; i < reservations.size(); i++) {
			Reservation oldReservations = reservations.get(i);
			if(oldReservations.getFromDate().isEqual(reservation.getFromDate()) && oldReservations.getToDate().isEqual(reservation.getToDate())) {
				available = false;
				
		
		}
		}
		if (!available) {
			throw new IllegalArgumentException("We are already booked on that given date");
	
		}
			return reservation;
		
		}
		
			public List<Reservation> getAllBookings() { 
				List<Reservation> copy = new ArrayList<Reservation>();
				copy.addAll(reservations);
				return copy;
 			
 				
		
		}
			public void clearList() {
				reservations.clear();
			}
		
				
        }
