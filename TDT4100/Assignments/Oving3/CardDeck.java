package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	
	private List <Card> cards = new ArrayList<Card>();
	
	
	public CardDeck(int n) {
		
		if(n > 13 && n < 0) {
			throw new IllegalArgumentException("TEST");
		}
		
		
		for (int i = 1; i <= n; i++) {
			cards.add(new Card('S', i));
		}
		for (int i = 1; i <= n; i++) {
			cards.add(new Card('H', i));
		}
		
		for (int i = 1; i <= n; i++) {
			cards.add(new Card('D', i));
		}
			
		for (int i = 1; i <= n; i++) {
			cards.add(new Card('C', i));
		}	
		
	}
	
		public int getCardCount() {
			return cards.size();
			
			
		}
		
		public Card getCard(int n) {
			if (n < 0 || n> cards.size()) {
				throw new IllegalArgumentException();}		
			return cards.get(n);
			
		
}
		
		
//		public Card shufflePerfectly() {
//			
//		}
		
		
		
		
		
		public static void main(String[] args) {
			CardDeck test = new CardDeck(3);
			
			
			
			
		}
	}


	
	

