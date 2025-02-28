package StringBased;

public class LongestPalindromSubString {

	public static void main(String[] args) {

		String s = "babad";
		
		System.out.println(solution(s));

	}

	//Approach: treat each element as center, expand it, left side and right side, and find length, then apply substring for that length.
	
	private static String solution(String str) {
		
		int start = 0;
		int end =  0;
		
		
		for(int i = 0; i< str.length(); i++) {
			
			int evenlength = expand(str,i, i+1);
			int oddLength = expand(str,i,i);
			
			int length = Math.max(evenlength, oddLength);
			
			if(length > end-start) {
				
				start = i -(length-1)/2; // center - (length-1)/2 : towards left side: length -1 coz for even chars;  center is (i to i+1)
				end   = i + length/2; // center + length/2(towards right side)
			}
		}
		
		return str.substring(start, end+1); // +1 as substring don't include last char by default
		
	}
	
	private static int expand(String str, int start, int end) {
		
		// boundary condition and check if chars match at both side
		
		while(start>=0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
			
			start--; // move left side
			end++;   // move right side
		}
		
		return end-start-1; // -1 as for checking char is matching or not, we already moved 1 step ahead
	}
}
