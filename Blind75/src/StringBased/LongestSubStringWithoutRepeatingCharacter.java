package StringBased;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacter {

	public static void main(String[] args) {


		String str = "abcdabcdabb";
		System.out.print(solution(str));

	}
	
	// Approach: Use Sliding window
	private static int solution(String str) {
		
		int left = 0; // keep left pointer
		int maxLength = 0;
		
		HashSet<Character> set = new HashSet(); // is using for unique element
		
		for(int i = 0; i< str.length();i++) { // using i as right side pointer
			
			if(set.contains(str.charAt(i))) { // check if same element, remove as we want unique element only
				
				set.remove(str.charAt(left)); // remove previous one not current one
				left++; // after each removal move pointer towards left -> left++
			}
			
			set.add(str.charAt(i));
			
			maxLength = Math.max(maxLength, i - left +1); // +1 because we are starting from 0, for 0th element length should be 1.
		}
		
		return maxLength;
	}

}
