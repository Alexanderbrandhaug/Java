package encapsulation;
import java.util.regex.Pattern;

public class Vehicle {

	private char typeOfVehicle, typeOfFuel;
	private String licensePlate;
	
	
	
	public Vehicle(char typeOfVehicle, char typeOfFuel, String licensePlate) {
		this.typeOfVehicle = typeOfVehicle;
		this.typeOfFuel = typeOfFuel;
		this.licensePlate = licensePlate;
		getVehicleType();
		getFuelType();
		setRegistrationNumber(licensePlate);
		
	}
	
	
	
	public char getVehicleType() {
		if (this.typeOfVehicle == 'M') {
			return 'M';
		}
		if (this.typeOfVehicle == 'C') {
			return 'C';
		}
		else
			throw new IllegalArgumentException();
	
	}
	
	
   public char getFuelType() {
	   if (this.typeOfFuel ==  'H') {
		   return 'H';
	   }
	   if (this.typeOfFuel == 'E') {
		   return 'E';
	   }
	   if (this.typeOfFuel == 'D') {
		   return 'D';
		   
	   }
	   if (this.typeOfFuel == 'G') {
		   return 'G';
		 
	   }
	   
	   else
		   throw new IllegalArgumentException();
   }
 
   
   
   
   
	   public void setRegistrationNumber(String licensePlate) {
		   String randomSub = licensePlate.substring(0,2);
		   String prefixReg = "EL";
		   String prefixReg2 = "EK";
		   String prefixH = "HY";
	   
	   if (getVehicleType() == 'M' && licensePlate.length() == 6 && (getFuelType() == 'G' || getFuelType() == 'D')) {
		   checkLicenseMotorcycle(licensePlate);
		   this.licensePlate = licensePlate;
		   return;
	   }
	   
	  if (getVehicleType() == 'M' && getFuelType() == 'E' && ((randomSub.equals(prefixReg) || randomSub.equals(prefixReg2)) && licensePlate.length() == 6)) {
		  this.licensePlate = licensePlate;
		  return;
	  }
	   
	   
	   if (getVehicleType() == 'C' && getFuelType() == 'E' && (randomSub.equals(prefixReg) || randomSub.equals(prefixReg2))&& licensePlate.length() == 7)  {
		   this.licensePlate = licensePlate;
		   return;
		   
		   
	   }
        
	   if(getVehicleType() == 'C' && getFuelType() == 'H' && randomSub.equals(prefixH) && licensePlate.length() == 7) {
		   this.licensePlate = licensePlate;
		   return;
	   }
	   
	   if(getVehicleType() == 'C' && (getFuelType() == 'G' || getFuelType() == 'D')) {
		   checkLicenseCar(licensePlate);
		   System.out.println("test");
		   this.licensePlate = licensePlate;
		   return;
		   
	   
   }
	   
	   else {
		  throw new IllegalArgumentException();}
  
   
   
   
   
   }
	   
	   public static String checkLicenseCar(String licensePlate) {
		   boolean test = Pattern.matches("^[A-Z]{2}[0-9]{5}$", licensePlate);
		  
		  
		   if (test == true && (licensePlate.startsWith("EL") == false) && (licensePlate.startsWith("EK") == false) && (licensePlate.startsWith("HY") == false)){
			   System.out.println("testlicense");
			   return licensePlate;
		   }
		   else
			   throw new IllegalArgumentException("Not a valid licensenumber!");}

   
		   
		   
		  public static String checkLicenseMotorcycle(String licensePlate) {
    	  boolean test1 = Pattern.matches("[A-Z]{2}[0-9]{4}", licensePlate);
    	  
    	  if (test1 == true && (licensePlate.startsWith("EL") == false && licensePlate.startsWith("EK") == false && licensePlate.startsWith("HY") == false))  {
    			  return licensePlate;}
    	  else
    		  throw new IllegalArgumentException();
      }
	   
		  
		  
		  
		  
		  

		  public String getRegistrationNumber() {
			  System.out.println("Regnr: " + licensePlate);
			  return this.licensePlate;
   }

   
   
       public static void main(String[] args) {
		Vehicle a = new Vehicle('C', 'G', "HA12345");
		Vehicle b = new Vehicle ('C', 'D', "BN12345");
		
		
		b.getRegistrationNumber();
		
		System.out.println(b);
	
		

		
		
	}
	
	
}


