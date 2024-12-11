
public class BinarySearch {

		//rekursiv
	
	public static int numberSearchSortedList(int[] numbers, int left, int right, int target) {
		
			//base case if not in list
		if (left > right) {
			return -1;
		}
		
		int mid = left + (right-left)/2;
			
			//base case if found
		if(numbers[mid] == target) {
			return mid;
			
		} 
			//recursive cases
		if(numbers[mid] < target) {
			return numberSearchSortedList(numbers, mid+1, right, target);
		
		}
		
		if(numbers[mid] > target) {
			return numberSearchSortedList(numbers, left, mid-1, target);
		}
		return -1;
	}

	
	
		// iterativ
	
	public static int numberSearchSortedList(int[] numbers, int target) {
	
			int leftBoundary = 0;
			int rightBoundary = numbers.length - 1;
		
		while(leftBoundary <= rightBoundary) {
			
			int mid = leftBoundary + (rightBoundary - leftBoundary)/2;
			
			if(target == numbers[mid] ) {
				return mid;
			}
			if(target < numbers[mid]) {
				rightBoundary = mid-1;
			}
			
			if(target > numbers[mid]) {
				leftBoundary = mid +1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,7,9,11,14,16,18,19,23,28,37,49,57,67,87};
		
				//rekursiv
		int returnValue = numberSearchSortedList(arr, 0, arr.length-1, 37);
		
		if(returnValue == -1) {
			System.out.println("The number is not in the list");
		} else {
			int searchedNumber = arr[returnValue];
			System.out.println("Number " + searchedNumber  + " is in the list at index: " + returnValue);
		}
		
				//iterativ
		int returnNumber = numberSearchSortedList(arr, 57);
		
		if(returnNumber == -1) {
			System.out.println("The number is not in the list");
		} else {
			int desiredNumber = arr[returnNumber];
			System.out.println("Number " + desiredNumber  + " is in the list at index: " + returnNumber);
		}
	}
}	
