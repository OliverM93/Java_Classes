
import java.util.Arrays;

class SelectionSort {
  public static void selectionSort (int arr[]) {

  int size = arr.length;  
  for (int i = 0; i < size - 1; i++) {
    int currentMinimumIndex = i;
    for (int j = i + 1; j < size; j++) {
      if (arr[j] < arr[currentMinimumIndex]) {
        currentMinimumIndex = j;
      }
    }
    swap(arr, i, currentMinimumIndex); // call swap() here
  }
}

  public static void swap(int[] arr, int indexOne, int indexTwo) {
    // write swap code here
    int temp = arr[indexTwo];
    arr[indexTwo] = arr[indexOne];
    arr[indexOne] = temp;
 }

  public static void main(String args[]) {
    int[] data = {2, 7, -7, 20, 67, 55, 89, -3, -456, -5};
    // provide arguments for `swap()`
    selectionSort(data);
    System.out.println("Sorted Array in Ascending Order: ");
    System.out.println(Arrays.toString(data));
  }
} 