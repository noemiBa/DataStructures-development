import java.util.Random;

public class RecursiveAlgorithms {

	public static void main(String[] args) {
		//test collatz method
		RecursiveAlgorithms.collatz(5); 
		System.out.println();
		RecursiveAlgorithms.collatz(9);
		System.out.println();
		RecursiveAlgorithms.collatz(871);

		//test isPalindrome
		String [] inputs = {"Racecar",
				"Radar",
				"Step on no pets",
				"Top spot",
				"Was it a cat I saw?",
				"eva, can I see bees in a cave?",
		        "no lemon, no melon"};

		for(String input : inputs) {
			System.out.println(RecursiveAlgorithms.isPalindrome(input) + " -> "+ input);
		}

		//test recursive and iterative bubble Sort
		Random random = new Random(20010);
		for (int n = 1000; n < 10000000;) {
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) {
				arr[i] = random.nextInt(); }
			Timer t = new Timer(); 
			RecursiveAlgorithms.iterativeBubbleSort(arr);
			System.out.println("" + n + "," + t.elapsedTime());
			n = (int) (n * 1.5);
		}
	}

	/* The method isPalindrome checks whether a given String is a palindrome. 
	 */
	public static boolean isPalindrome(String input) {
		//ignore the spaces, punctuation and whether the string is lower or upper case
		input = input.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();

		//base case --> if there no or only one character left, return true
		if(input.length() < 2) { 
			return true; 
		}

		int first = 0; 
		int last = input.length()-1;

		if(input.charAt(first) != input.charAt(last)) { 
			return false; 
		}
		else { 
			return isPalindrome(input.substring(1,input.length()-1)); }
	}


	/* Recursive implementation of the Collatz sequence, which is believed to always return 1 
	 * when given any positive integer.
	 */
	public static void collatz(int number) {
		System.out.print(number + " ");

		//base case
		if (number == 1) {
			return; 
		}

		//if the number is even, divide the number by 2. 
		if (number%2==0) {
			collatz(number/2); 
		}
		//if the number is odd, multiply the number by 3 and add 1 
		else {
			collatz(3*number+1); 
		}
	}

	/* The function uses the bubble sort algorithm in order to sort a given array. Bubble sort repeatedly steps through the array to sort
	 * comparing adjacent elements, and swapping them around if the second value is larger than the first.
	 * 
	 * @param array: the integer array to be sorted 
	 */
	public static void iterativeBubbleSort(int[] array) {
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

	public static void recursiveBubbleSort(int[] array, int length) {
		// Base case: if the length is 1, return
		if (length == 1) {
			return;   
		}

		//Move the largest element of the array to the end
		for (int i=0; i < length-1; i++){
			if (array[i] > array[i+1]) {
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}

		//Continue swapping the largest element to the end of the array recursively
		recursiveBubbleSort(array, length-1);
	}
}

