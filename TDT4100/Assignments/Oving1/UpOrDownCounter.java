package stateandbehavior;

public class UpOrDownCounter {
 
    private int start;
    private int end;
    private int counter;
 
    public UpOrDownCounter(int start, int end) {
        if(start == end){
            throw new IllegalArgumentException("start and end cannot be equal");
        }
        this.start = start;
        this.end = end;
        this.counter = start;
    }
 
    public boolean count() {
        if (counter == end) {
            return false;
        } else if (start < end) {
            counter++;
        } else {
            counter--;
        }
        return counter != end;
    }
 
    public int getCounter() {
        return counter;
    }

 
  
 
    public static void main(String[] args) {
    	UpOrDownCounter upOrDownCounter = new UpOrDownCounter(0, 10);
       
    	   while (upOrDownCounter.count()) {
               System.out.println(upOrDownCounter.getCounter());
               System.out.println(upOrDownCounter.count());
            
            
        }
    {
    }
    }
}


