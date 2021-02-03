package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	
		private List <Card> cards = new ArrayList<Card>();
	
	
		public CardDeck(int n) {
			cardCheck(n);
			
			
			}
		
	
	
		public int getCardCount() {
			return cards.size();
			
			
			}
			
		public Card getCard(int n) {
			if (n < 0 || n> cards.size()) {
				throw new IllegalArgumentException();}	
			return cards.get(n);
			
			
		
			}
		
		public List<Card> cardCheck(int n) {
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
			return cards;	}
			
			
		
		
		public List<Card> shufflePerfectly() {
			List <Card> test2 = new ArrayList<>();
			
			for (int i = 0, j = getCardCount()/2; i < getCardCount()/2; i++, j++) {
				test2.add(cards.get(i));
				test2.add(cards.get(j));
			}	
				this.cards = test2;
			
				return test2;
			}
			
		

		
		public static void main(String[] args) {
			CardDeck test = new CardDeck(13);
			//System.out.println(test.cardCheck(13));
			System.out.println(test.shufflePerfectly());					
			
			}
			}
