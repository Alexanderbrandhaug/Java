package project_reservation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




	public class Reservation {
	private String name, email;
	private String phoneNumber;
	private LocalDate toDate;
	private LocalDate fromDate;
	private int price;
	private int id;
	

	
		public Reservation(int id, String name, String email, String phoneNumber, LocalDate fromDate, LocalDate toDate, int price) {
			setEmail(email);
			setName(name);
			setPhoneNumber(phoneNumber);
			this.name = name;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.fromDate = fromDate;
			this.toDate = toDate;
			this.id=id;
			
	
		
	}
		public void setPrice() {
			price = 899;
			long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);
			this.price = (int) daysBetween * price; 
		
		}
		public void setDateFromFile(LocalDate fromDate, LocalDate toDate) {
			this.fromDate = fromDate;
			this.toDate = toDate;
		}
		
		public int getPrice() {
			return price;
		}
		
		public int getId() {
			 return id;
		}

		
		public void setId(int id) {
			this.id = id;
		
		}

		public void setName(String name) {
			if (checkName(name) && name.length() >= 2 && checkForSpaces(name) && !name.endsWith(" ")) {
				this.name = name.toLowerCase();
					
				}	else 
				throw new IllegalArgumentException("Invalid name format");
			}
				
		public boolean checkForSpaces(String name) {
			Pattern pattern = Pattern.compile("\\s");
			Matcher matcher = pattern.matcher(name);
			boolean found = matcher.find();
					if (found) {
						return true;
			}
		
		return false;
		}
	
		public boolean checkName(String name) {
			if (name == null) {
				return false;
	}
		// sjekker om det er tall i navnet, og om det er mellomrom. returnerer false hvis ja
			for (int i = 0; i <= name.length(); i++) {
				if (name.matches(".*\\d.*")) {
					return false;
					
				
	}
	
	}
	
			return true;
	
	
	}	
	
		public void setPhoneNumber(String phoneNumber2) { //sjekker om GSM starter på 9 eller 4, og om lengden er 8. 
			if ((String.valueOf(phoneNumber2).charAt(0) == '9' || String.valueOf(phoneNumber2).charAt(0) == '4') && String.valueOf(phoneNumber2).length() == 8) {
				this.phoneNumber = phoneNumber2;
			
	}
		
		else
			throw new IllegalArgumentException("Not valid number-format. Must be 8-digits long and start with 9 or 4");
	}
	
	
		public void setDate(LocalDate fromDate, LocalDate toDate) {
			if(toDate.isBefore(fromDate)) {
				throw new IllegalArgumentException("From date must be before to date ");
	}
	        
			if(fromDate.isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("You can't book a date in the past ");
			}
			
			this.fromDate = fromDate;
			this.toDate = toDate;
		
		
	}
		public void setFromDate(LocalDate fromDate) {
			if(fromDate.isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("You can't book a date in the past ");
			}
			this.fromDate = fromDate;
		}
		
		public void setToDate(LocalDate toDate) {
			if(toDate.isBefore(fromDate)) {
				throw new IllegalArgumentException("From date must be before to date ");
		}
			this.toDate = toDate;
			
		}
	
	 static boolean checkValidEmail(String email) {
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	     return email.matches(regex);
		
	 }
	
	 public void setEmail(String email) {
		 if (checkValidEmail(email) && !email.endsWith(" ")) {
			 this.email = email.toLowerCase();
	 }
		 else
			 throw new IllegalArgumentException("Invalid Email format(e.g olanordmann@gmail.com) ");
	 }
	
	

	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getFromDate() {
		return fromDate;
	}
	
	public LocalDate getToDate() {
		return toDate;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	
	
	 public String toString() {
		return String.valueOf(id) + ',' + ' ' + getName() + ',' + ' ' + getEmail() + ',' + ' ' + getPhoneNumber() + ',' + ' ' + getFromDate() + ',' + ' ' +getToDate() + ',' + ' '+ getPrice() + "";
	}
	
