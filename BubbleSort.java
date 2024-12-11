

import java.util.Arrays;

public class BubbleSort {
	
	static void bubble(int[] arr) {
		boolean swapped;
		//run the steps n-1 times
		for(int i = 0; i < arr.length; i++) {
			swapped = false;
			//for each step, biggest item will come at last index
			for(int j = 1; j < arr.length - i; j++) {
				//swap if item is smaller than the previous item
				if(arr[j] < arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			//if no swap for a certain i (= array is sorted), abort the function
			if(swapped = false) {
				return; //oder break, in diesem Fall hätte es den gleichen Effekt
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 1};
		bubble(arr);
		System.out.println(Arrays.toString(arr));
	

	}

}
