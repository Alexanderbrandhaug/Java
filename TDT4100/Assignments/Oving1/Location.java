package stateandbehavior;

public class Location {
	private int x, y;
	
	
	
	
	
	public Location() {
		this.x = 0;
		this.y = 0;
	}

	public int up() {
		return this.y --;
		
		
	}

	public int down() {
		return this.y ++;
		
	}
	
	public int left() {
		return this.x --;
	}
	
	public int right() {
		return this.x ++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "Keeps track of (X, Y) as you move either up: " + up() + " or down: "+down() + " or left: "+ left() + " or right: " + right() +" and returns the (X,Y) position " + getX()+ " , " + getY();
	}
	
public static void main(String[] args) {
	Location loc = new Location();
//	loc.up();
//	loc.down();
//	loc.getX();
//	loc.getY();
	loc.x = 10;
	loc.y = 15;
	System.out.println(loc);
}

}



