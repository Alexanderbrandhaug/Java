package objectstructures;


import java.util.Collection;

public class Partner {

	private String name;
	private Partner partnerObj;
	

	public Partner(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public Partner getPartner() {
		return this.partnerObj;
	}
	
	public void setPartner(Partner partner) {
		Partner gammel = this.getPartner();
		if(this.partnerObj == partner) {
			
		}
		
		else {
			if(partner == null && gammel != null) {
				partnerObj = null;
				gammel.setPartner(null);
				
				
			}
			if(gammel == null && partner == null) {
				throw new IllegalArgumentException("Dont have a partner yet");
			}
			
			if(gammel == null && partner != null) {
				partnerObj = partner;
				partnerObj.setPartner(this);
			}
			
			
			if(gammel == null && partner == this) {
				throw new IllegalArgumentException("You cant partner up with yourself");
			}
			
			if(gammel != null && partner != null) {
				partnerObj = gammel;
				partnerObj.setPartner(null);
				partner.setPartner(this);
				
			}
			
			
			
		}
	}
	
		
		
	
	
	@Override
	public String toString() {
		return name;
	}

	
				
		
	}
}
