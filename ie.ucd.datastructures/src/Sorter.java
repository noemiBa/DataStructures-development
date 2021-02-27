import java.util.Random;

public class Sorter {
	public static void xSort(int [] arr) {
	}
	public static void main(String [] args) {
		Random random = new Random(20010);
		for (int n = 1000; n < 10000000;) {
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = random.nextInt(); }
			Timer t = new Timer(); 
			Sorter.insertionSort(arr);
			final long elapsedTime = System.currentTimeMillis();
			System.out.println("" + n + "," + t.elapsedTime());
			n = (int) (n * 1.5);
		}
	}
	
	/* The function uses the bubble sort algorithm in order to sort a given array. Bubble sort repeatedly steps through the array to sort
	 * comparing adjecent elements, and swapping them around if the second value is larger than the first.
	 * 
	 * @param array: the integer array to be sorted 
	 */
	public static void bubbleSort(int [] array) {
		for (int i = 1; i<array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					//swap the two adjacent values
					int temp = array[j]; 
					array[j] = array[j+1]; 
					array[j+1] = temp; 
				}
			}
		}
	}
	/* The function uses the selection sort algorithm in order to sort a given array. Selection sort loops over indices in the array; 
	 * for each index, selection sort calls indexOfMinimum and swap. It is an in place, comparison sorting algorithm.
	 * 
	 * @param array: the integer array to be sorted 
	 */
	public static void selectionSort(int [] array) {
		int temp; 
		int min_index; 

		for (int i=0; i<array.length-1; i++) {
			min_index = i; 

			for (int j = i+1; j<array.length;j++) {
				if (array[min_index] > array[j]) {
					min_index = j;
				}
			}

			//Swap the found minimum element with the first element 
			temp = array[i]; 
			array[i] = array[min_index];
			array[min_index] = temp; 
		}

	}

	/* The function uses the insertion sort algorithm in order to sort a given array. Insertion sort is a sorting mechanism where the 
	 * sorted array is built having one item at a time. The array elements are compared with each other sequentially and swapped if necessary.
	 * 
	 * @param array: the integer array to be sorted 
	 */
	public static void insertionSort(int [] array) {
		int n = array.length;

		for (int i=0; i<n; i++) {
			int temp  = array[i];
			int j = i-1; 
			while (j >= 0 && array[j] > temp) {
				array[j+1] = array[j];
				j--; 
			}
			array[j+1]= temp; 
		}
	}

}