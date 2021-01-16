package stateandbehavior;

public class Location {
	private int x;
	private int y;
	
	
	
	
	public Location() {
		this.x = 0;
		this.y = 0;
	}

	public void up() {
		this.y --;
		
		
	}

	public void down() {
		this.y ++;
		
	}
	
	public void left() {
		this.x --;
	}
	
	public void right() {
		this.x ++;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
public static void main(String[] args) {
	Location loc = new Location();
	loc.up();
	loc.down();
	loc.getX();
	loc.getY();
}

}



