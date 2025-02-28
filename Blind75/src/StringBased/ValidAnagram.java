package StringBased;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {

       String str1 = "Anagram@1";
       String str2 = "gramanA@1";
       
       System.out.println(solution2(str1,str2));

	}
	// This Approach is only valid for lower case letters as A-a -> 65-97 -> -32, will give Array out of bound exception
	// to use this approach convert str1. to loweeCase, same with str2 as well.
	// Also this approach will not handle number and special character.
	// Approach, create char array, and increase/decrease count, at last count should be zero at each position
	private static boolean solution(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();
		
		// base check
		if( m != n) return false;
		
		int[] charArray = new int[26]; // as we have 26 alphabets only in English
		
		for(int i =0; i<m;i++) {
			
			charArray[str1.charAt(i) - 'a']++;
			charArray[str2.charAt(i) - 'a']--;
		}
		
		for(int i =0; i< charArray.length;i++) {
			
			if(charArray[i] != 0) {
				
				return false;
			}
		}
		
		return true;
	}
	
	// This Approach will handle, upper,lower, number and special characters, as we are going to use full range of ASCAII characters
	// Also we don't need to convert to Upper case and we don't need to subtract as well(b-a)++ -> 98-97 -> (1th index)++
	
	private static boolean solution2(String str1, String str2) {
		
		// base case
		
		if(str1.length() != str2.length()) return false;
		
		int[] count = new int[256]; // taking full range
		
		for(int i =0; i< str1.length(); i++) {
			
			count[str1.charAt(i)]++; // no need to subtract for A-> 65 -> 65th index -> 0++ -> 1
			count[str2.charAt(i)]--;
			
		}
		
		for( int num : count) {
			
			if( num != 0) {
				
				return false;
			}
		}
		
		return true;
	}
	
	// However, Unicode characters (e.g., á, é, ñ, €, 𝛼, 😀) have values beyond 256, and they won't fit into an int[256] array.

    //Solution: Use a HashMap<Character, Integer> Instead
	
	private static boolean solution3(String str1, String str2) {
		
		
		//base check
		if(str1.length() != str2.length()) return false;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int  i= 0; i<str1.length();i++) {
			
			map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i),0)+1);
			map.put(str2.charAt(i), map.getOrDefault(str2.charAt(i),0)-1);
			
		}
		
		for(int count : map.values()) {
			
			if(count != 0) {
				
				return false;
			}
		}
		
		return true;
	}
	
	// this is also a generic solution, where we will add and remove from StringBuilder & at last return length of StringBuilder
	
	private static boolean solution4(String str1, String str2) {
		
		//base check
		if(str1.length() != str2.length()) return false;
		
		StringBuilder sb = new StringBuilder(str1); // made sb of type str1
		
		
		for(char ch : str2.toCharArray()) {
			
			int index = sb.indexOf(""+ch);
			
			if(index != -1) {
				
				sb.deleteCharAt(index);
			}else {
				
				return false;
			}
			
		}
		
		return sb.length() == 0 ? true : false;
		
	}

}
