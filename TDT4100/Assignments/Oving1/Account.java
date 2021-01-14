
package stateandbehavior;

	public class Account {
	
	public double balance;
	public double interestRate;
	
	
	public void deposit(double balance) {
		if (balance >= 0)
		this.balance += balance;
		System.out.println("Your current balance is: " + balance);
		
	}
        
	
	public void setBalance(double balance) {
		this.balance = balance;
	}



	public double addInterest() {
		this.balance += (interestRate / 100) * this.balance;
		return this.balance;
		
		
	}
	
	
	public double getBalance() {
		System.out.println("Your new balance with interests are : " + this.balance);
		return this.balance;
		
	}
	
	public double getInterestRate() {
		System.out.println("Your current interest rate is: " + this.interestRate + "%");
		return this.interestRate;
	}
	
	
	public double setInterestRate(double interestRate) {
		return this.interestRate = interestRate;
	
		
	}

	public static void main(String[] args) {
		Account account = new Account();
		account.getBalance();
	
	}

}
