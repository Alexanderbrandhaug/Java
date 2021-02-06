package encapsulation;

import java.util.ArrayList;

		public class Nim {
		private int pileSize;
		private ArrayList<Integer> list = new ArrayList<Integer>();
	

		public Nim(int pileSize) {
			this.pileSize = pileSize;
			list.add(pileSize);
			list.add(pileSize);
			list.add(pileSize);
				if(pileSize > 2 && pileSize < 0) {
					throw new IllegalArgumentException();
		}
		
		
		}

		public Nim() {
			list.add(10);
			list.add(10);
			list.add(10);
		}
	
	
	
	
	
		public void removePieces(int number, int targetPile) {
		if(targetPile >= 0 && targetPile <= 2 && number >= 1 && number <=10 && list.get(targetPile) >= number) {
			list.get(targetPile);
		    list.set(targetPile, list.get(targetPile)-number);
		    System.out.println(list.get(targetPile));
		    System.out.println(list);	
		}	
		else if (isGameOver() == true)
				throw new IllegalStateException();
		else {
				throw new IllegalArgumentException();
	
		}		
	
	 
	 
	 
		}
		public boolean isValidMove(int number, int targetPile) {
			if (isGameOver() == true)
				return false;
		
		if (number > 0 && number <= 10 && targetPile <=2 && targetPile >= 0 && list.get(targetPile) >= number) {
			System.out.println(true);
				return true;

		}
	
		else { 
			System.out.println(false);
				return false;
	
		}
		}
	
		public boolean isGameOver() {
			if (list.get(0)== 0 || list.get(1)== 0 || list.get(2) == 0) {
				return true;
		}
			else
				return false;
		
		
		}
	
	
	
	
		public int getPile(int targetPile) {
			return list.get(targetPile);
		}

	
	
	
		
		public static void main(String[] args) {
			
		Nim test = new Nim(10);
		test = new Nim();
		
		System.out.println(test.list);
		test.removePieces(5, 1);
		test.isValidMove(2, 1);
		//System.out.println(test.isGameOver());
		test.removePieces(5, 1);
		test.isValidMove(-2, 1);
		test.isValidMove(2, 1);
		}	
		{
		
		
		}
		}
