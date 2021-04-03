import java.util.Scanner;
import java.io.*; 

public class WordCounter {
	public static String word; 
	public static Integer count; 
	
	public static void main(String [] args) throws IOException {
		Scanner scan = new Scanner(System.in); 
		//the pattern allows the scanner to ignore non-letters.
		scan.useDelimiter("[^a-za-Z]"); 
		ChainHashMap<String,Integer> c = new ChainHashMap<String,Integer>(); 
		
		while (scan.hasNext()) {
			word = scan.next().trim().toLowerCase(); 
			count = c.get(word); //get the previous count for this word
			
			//if this is the first instance of the word, initialise the count to 1
			if (count == null) {
				c.put(word, 1); 
			}
			else {
				c.put(word, count++); 
			}
		}
	}
}
