package encapsulation;

public class Vehicle {

	private char typeOfVehicle, typeOfFuel;
	private String licensePlate;
	
	
	
	public Vehicle(char typeOfVehicle, char typeOfFuel, String licensePlate) {
		super();
		this.typeOfVehicle = typeOfVehicle;
		this.typeOfFuel = typeOfFuel;
		this.licensePlate = licensePlate;
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
 
   
   public String setRegistrationNumber(String licensePlate) {
	   this.licensePlate = licensePlate;
	   String randomSub = licensePlate.substring(0,2);
	   String prefixReg = "EL";
	   String prefixReg2 = "EK";
	   String prefixH = "HY";
	   
	   
	  
	   
	   
	   if (getVehicleType() == 'C' && getFuelType() == 'E' && (randomSub.equals(prefixReg) || randomSub.equals(prefixReg2))&& licensePlate.length() == 7)  {
		   return licensePlate;
		   
		   
	   }
        
	   if(getVehicleType() == 'C' && getFuelType() == 'H' && randomSub.equals(prefixH) && licensePlate.length() == 7) {
		   return licensePlate;
	   }
	   
	  
	   
	   
	   
	   
	   else 
		  throw new IllegalArgumentException();}
   
   
   
  
  @Override
public String toString() {
	return "Kjøretøy: " + getVehicleType()+ " Drivstoff: " + getFuelType() + " Regnr: " + setRegistrationNumber("EL12345");
}
   
   

   
       public static void main(String[] args) {
		Vehicle a = new Vehicle('C', 'E', "EK12345");
		Vehicle b = new Vehicle('C', 'E', "EK12345");
		System.out.println(a);
		b.setRegistrationNumber("EK12345");
		System.out.println(a.setRegistrationNumber("EK12345"));
		

		
		
	}
	
	
}


