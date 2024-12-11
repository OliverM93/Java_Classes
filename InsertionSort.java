

import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] array) {
		   for (int i = 1; i < array.length; i++) {
		     int current = array[i];
		     int j = i - 1;
		      while (j >= 0 && array[j] > current) { // solange, bis die bereits sortierte Zahl noch größer als array[i] ist und der Anfang des Arrays noch nicht erreicht wurde
		       array[j+1] = array[j]; // sortierte Zahl wird nach rechts gerückt
		       j--;
		     }
		    array[j+1] = current; // einsetzen der unsortierten Zahl an der passenden Stelle
		   }
		  }
	
		  public static void main(String[] args) {
		    int[] numbers = {7, 2, 14, -7, 72};
		    System.out.println("Array in ascending order");
		    sort(numbers);
		    System.out.println(Arrays.toString(numbers));

		  }
		}