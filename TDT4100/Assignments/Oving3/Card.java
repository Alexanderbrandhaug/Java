package encapsulation;

public class Card {

	private char cardType;
	private int cardNum;
	
	
	
	public Card(char cardType, int cardNum) {
		super();
		this.cardType = cardType;
		this.cardNum = cardNum;
		getFace();
		getSuit();
	}
	
	public char getSuit() {
		if (cardType == 'S' || cardType == 'H' || cardType == 'D' || cardType == 'C') {
			return cardType;}
		
			else {
			throw new IllegalArgumentException("Invalid cardtype! ");}
		}
	
		
		public int getFace() {
			if (cardNum <= 13 && cardNum > 0) {
				return cardNum;
			
		}
		
			else
				throw new IllegalArgumentException("Invalid number!");
		
	}
	
	
	
	@Override
	public String toString() {
		return  getSuit() + String.valueOf(cardNum);
	}
	
	
	
	
	
	public static void main(String[] args) {
		Card test = new Card('C', 12);
		System.out.println(test);
		
	}
}
