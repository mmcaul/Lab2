
import framework.De;

public class Main {
	
    public static void main(String[] args) {
	
    	De de1 = new De(4);
    	De de2 = new De(5);
    	System.out.println(de1.getCurrentFace());
    	System.out.println(de2.getCurrentFace());
    	System.out.println(de1.compareTo(de2));
    	
    }
}
