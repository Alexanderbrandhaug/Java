package project_reservation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class WriteRead implements WriteAndRead{
	 public Hotel hotel = new Hotel();
	
	
	 
	
	@Override
	public void writeToFile(String filename, List<Reservation> list) {
		if(list.isEmpty()) {
			throw new IllegalArgumentException("There is nothing to save");
		}
		try {
			
			PrintWriter writer = new PrintWriter(new File(filename+".txt"));
			writer.print(list.toString().replace("[", "").replace("]", ""));
			writer.close();
			hotel.getAllBookings().clear();
			System.out.println("HOTELLISTA NÅR SAVE" + hotel.getAllBookings());
			

		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void getBookingsFromFile(String filename) throws FileNotFoundException {
		hotel.getAllBookings().clear();
		Scanner scanner = new Scanner(new File(filename+".txt"));
		 String line = scanner.nextLine();
		 String[] lineInfo = line.split(","+ " ");   
		
		for (int i = 0; i < lineInfo.length; i ++)		 {
				String id = lineInfo[i++];
				
				int idint = Integer.parseInt(id);

				String name = lineInfo[i++];
				String email = lineInfo[i++];
				String phoneNum = lineInfo[i++];
				String bookedFrom = lineInfo[i++];
				String bookedFrom1 = lineInfo[i++];
				String price = lineInfo[i];
				int priceToInt = Integer.parseInt(price);
		
				LocalDate localDate = LocalDate.parse(bookedFrom);
				LocalDate localDate1 = LocalDate.parse(bookedFrom1);
				Reservation test = new Reservation(idint,name, email, phoneNum, localDate,localDate1, priceToInt);
				test.setPrice();
				
				hotel.addBookingFromFile(test);
				System.out.println(hotel.getAllBookings() + "HOTELLISTA");
				
				
				
			} 
		scanner.close();
	
	}
