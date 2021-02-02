package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {

	
	private List <Card> cards = new ArrayList<>();
	
	
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
			return cards;	
			
		}
		
		
		public List<Card> shufflePerfectly() {
			
			List <Card> test2 = new ArrayList<>();
			
			
			for (int i = 1; i <= cards.size()/4; i ++) {
				test2.add(new Card('S', i));
				test2.add(new Card('D', i));
				
			}
			
			List <Card> test3 = new ArrayList<>();
			for (int i = 1; i <= cards.size()/4; i ++) {
				test3.add(new Card('H', i));
				test3.add(new Card('C', i)); 
			}
			
			List <Card> merged = new ArrayList<>(test2);
			merged.addAll(test3);
			
			return merged;
						
			
		}
		
		
		
		
		
		
		
		public static void main(String[] args) {
			CardDeck test = new CardDeck(5);
			
			System.out.println(test.getCard(2));
			System.out.println(test.shufflePerfectly());
			System.out.println(test.getCardCount());
			
					
							
			
		}
	}



	

