package StringBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println(solution(strs));
	}
	
	//Approach: Sort individual string and treat as key, then save other words against that key in map and return values() of map
	// Sorting each word takes O(K log K) (where K is the length of the word).
	//For N words, total complexity is O(N K log K).
	
	private static List<List<String>> solution(String[] strs){
		// base check
		if (strs == null || strs.length == 0) return new ArrayList<>();
		
		Map<String, List<String>> map = new HashMap<>();
		
		for( String str : strs) {
			
			char[] ch = str.toCharArray();
			
			Arrays.sort(ch); // gives sorted string: for eat and ate -> aet, will treat this as key.
			
			String sorted = new String(ch); // converted back to string
			
			map.putIfAbsent(sorted, new ArrayList<>());
			map.get(sorted).add(str); // adding original string against sorted key
		}
		
		return new ArrayList<>(map.values());
	}
	
	// Solution 2: Using Character Count (Optimized for Large Inputs)
	//TC: Counting letters in a word: O(K); Total: O(N K) (faster than sorting-based O(N K log K))
	// this approach does not handle Unicodes: emozies, chines, japanies
	// To support unicode: replace int[] charCount  with map where key will be stored. 
	// we can use Trie data structure as well for Faster Insertion & Lookup.
	
	private static List<List<String>> solution2(String[] strs) {
		
		if(strs == null || strs.length == 0) return new ArrayList<>();
		
		Map<String, List<String>> map = new HashMap<>();
		
		for(String str : strs) {
			
			int[] charCount = new int[26];
			
			for(char ch : str.toCharArray()) {
				
				charCount[ch -'a']++;
			}
			
			// now for key making : //'a' = 1, 'e' = 1, 't' = 1, all others = 0 
			
			StringBuilder sb = new StringBuilder();
			
			for( int count : charCount) {
				
				sb.append(count).append("#"); //generated key: "0#1#1#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#0#1#0#0#0#0#0#"

			}
			
			String key = sb.toString();
			
			// now save key and its value
			
			map.putIfAbsent(key, new ArrayList<>());
			map.get(key).add(str); // storing original string 
		}
		
		return new ArrayList<>(map.values());
		
	}

}
