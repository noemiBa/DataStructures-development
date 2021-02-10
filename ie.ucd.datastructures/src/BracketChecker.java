/* This class uses a Stack to check whether the opening brackets and the closing brackets in a String
 * are evenly balanced.
 * 
 */
public class BracketChecker {
	
	public static boolean checkParentheses(String in) {
		LinkedStack<Character> stack = new LinkedStack<Character>();
		String opening = "{[(";
		String closing = "}])";
		boolean isBalanced = false; 
		
		char [] characters = in.toCharArray(); //turn the String to a charArray
		
		for (char c : characters) {
			if (c == opening.charAt(0) || c == opening.charAt(1) || c == opening.charAt(2)) {
				stack.push(c);
			}
			else if (c == closing.charAt(0) || c == closing.charAt(1) || c == closing.charAt(2)) {
				if (stack.isEmpty()) {
					return isBalanced = false;  //it means there was no opening parenthesis
				}
				if (closing.indexOf(c) != opening.indexOf(stack.pop())) {
					return isBalanced = false; //if the opening and closing parentheses do not match
				}
			}
		}
		
		if (stack.isEmpty()) { //if we've reached this point matching all the parentheses
			isBalanced = true; 
		}
		return isBalanced; 
	}
	
	public static void main(String[] args) {
		String [] inputs = {
				"[]]()()", //not correct
				"c[d]", //correct
				"a{b[c]d}e", //correct
				"a{b(c]d}e", //not correct
				"a{b[c]d}e}", //not correct
				"a{b(c)", //not correct
				"][]][][[]][]][][[[", //not correct
				"(((abc))((d)))))",
		};
		
		for (String input : inputs) {
			System.out.println("isBalanced? " + BracketChecker.checkParentheses(input));
		}
	}
	
}
