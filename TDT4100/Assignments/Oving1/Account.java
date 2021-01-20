package stateandbehavior;

	public class Account {
	
	public double balance;
	public double interestRate;
	
	
	public double deposit(double balance) {
		if (balance >= 0)
		this.balance += balance;
		return balance;
		
	}
        
	

	public void addInterest() {
		this.balance += (interestRate / 100) * this.balance;
		
		
		
	}
	
	
	public double getBalance() {
		return this.balance;
		
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	
	public double setInterestRate(double interestRate) {
		 return this.interestRate = interestRate;
	
		
	}
@Override
	public String toString() {
		return "Displays the amount you currently have in your account: " + getBalance() + " lets you deposit money into it, new balance: " + deposit(1000) + " and add interest, your interest rate is:  " + setInterestRate(5.0);
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		account.setInterestRate(5.0);

		System.out.println(account);
		
	
	}

}
