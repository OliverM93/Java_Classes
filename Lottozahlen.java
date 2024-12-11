
import java.util.Random;
public class Lottozahlen {
	
		//Lottozahlen drucken
	static void out(int[] a) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
		//prüft, ob zufälliggezogene Zahl bereits im Array vorhanden ist (wenn ja, wird neue gezogen)
	static boolean istVorhanden(int[] a, int x, int i) {
		for(int j = 0; j < i; j++) {
			if(a[j] == x) {
				return true;
			} 
		}
		return false;
	}
	
	static void insert(int[] a, int x, int i) {
		while(i > 0 && a[i - 1] > x) { //solange Anfang des Arrays noch nicht erreicht ist und die nächste Zahl links im Array kleiner als die neue Zufallszahl ist
			a[i] = a[i -1];			   //rücke größere Zahl nach rechts
			i--;					   //verkleinere Index und vergleiche nächste Zahl
		}
		a[i] = x;
	}

	public static void main(String[] args) {
		
		final int N = 6, Range = 49;
		int[] a = new int[N];
		Random zufallsgenerator = new Random();
		
		for(int i=0; i<a.length; i++) {
			int newNumber = zufallsgenerator.nextInt(Range) + 1; //Zufallszahl zwischen 1 und 49 in jedem Index des Array
			while(istVorhanden(a, newNumber, i)) {
				newNumber = zufallsgenerator.nextInt(Range) + 1;				
				}
			//a[i] = newNumber;
			insert(a, newNumber, i);
		} 
		
		out(a);
	}
}
