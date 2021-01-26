
package encapsulation;


public class Account {
	
	private double balance;
	private double interestRate;
	
	public Account(double balance, double interestRate) {
		checkIfNumNegative(balance);
		checkIfInterestNegative(interestRate);
		this.balance = balance;
		this.interestRate = interestRate;
		
		
	}

	
	
	public void deposit(double balance) {
		checkIfNumNegative(balance);
		this.balance += balance;
		System.out.println("Your current balance is: " + balance);
		
	}
	
	public void addInterest() {
		this.balance += (interestRate / 100) * this.balance;
		
		
	}
	
	
	public double getBalance() {
	 return this.balance;
		
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	
	public void setInterestRate(double interestRate) {
		checkIfInterestNegative(interestRate);
		System.out.println("Your new rate is: " + interestRate);
		this.interestRate = interestRate;
		
		
	}
	
	public void withdraw(double balance) {
		checkIfNumNegative(balance);
		if(this.balance - balance < 0)
			throw new IllegalArgumentException();
		
		else
		this.balance -= balance;
		
	
	}
	
	
	
 
	private void checkIfNumNegative(double balance) {
		if (balance < 0) {
			throw new IllegalArgumentException("The amount can not be negative!(balance) ");}
		}
		
	private void checkIfInterestNegative(double interestRate) {
		if (interestRate < 0) {
			throw new IllegalArgumentException("The amount can not be negaitve!(rente) ");
		}
	}
		
	
	
	
	public static void main(String[] args) {
		Account myAccount = new Account(5, 5);
		myAccount.getBalance();
		myAccount.getInterestRate();
		myAccount.setInterestRate(7);
		myAccount.getInterestRate();
		myAccount.setInterestRate(2);
		
		
	}
}
