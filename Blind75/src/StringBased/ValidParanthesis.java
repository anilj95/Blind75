package StringBased;

import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {

         String str = "({[]})";
         
         System.out.println(solution(str));

	}
	
	private static boolean solution(String str) {
		
		if(str.length() <= 1) return false;
		
		Stack<Character> stack = new Stack<>();
		
		for(char ch : str.toCharArray()) {
			
			if(ch == '{') {
				
				stack.push('}');
			}else if(ch == '(') {
				
				stack.push(')');
			}else if(ch == '[') {
				
				stack.push(']');
			}else if( stack.isEmpty() || stack.pop() != ch) {
				
				return false;
			}
		}
		
		return true;
		
	}

}
