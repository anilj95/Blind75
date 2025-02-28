package StringBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {

	public static void main(String[] args) {

		List<String> input = Arrays.asList("hello", "world", "leet#code");
        String encoded = encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);

	}
	
	// List of strings are given: encode it and decode back to original List of Strings
	
	private static String encode(List<String> strs) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String str :strs) {
			
			int length = str.length();
			
			sb.append(length).append("#").append(str); // we appended length and # as delimiter
		}
		
		return sb.toString();
	}
	
	// this is tricky: 
	private static List<String> decode(String strs){
		
		List<String> result = new ArrayList<>();
		
		int i = 0; // needed to keep track of position of delimiter
		
		while(i < strs.length()) {
			
			int delimiterIndex = strs.indexOf("#", i); //Finds the first occurrence of # after position i,For "5#hello...", # is at index 1
			int length = Integer.parseInt(strs.substring(i, delimiterIndex)); //s.substring(0, 1) → "5" → Integer.parseInt("5") = 5
			
			i = delimiterIndex +1; // moves forward to get index of string start point
			
			String extracted = strs.substring(i, length+i); // 5#hello -> substring(2,5+2)-> hello
			
			result.add(extracted);
			
			 i += length; // move to the next encoded section
			
		}
		
		return result;
		
	}

}
