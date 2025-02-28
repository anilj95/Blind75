package ArrayBased;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public static void main(String[] args) {

         int[] nums = {3,1,2,3};
         
         System.out.println(solution2(nums));

	}
	// using iteration method : TC: O(nlogn); because of sorting
	private static boolean solution1(int[] nums) {
		
		Arrays.sort(nums);
	
		for(int i = 1; i<nums.length;i++) {
	
			if( nums[i] == nums[i-1]) {
				
				return true;
			}
	
		}
		
		return false;
	}
	
	// using HashSet :
	
	private static boolean solution2(int[] nums) {
		
		Set<Integer> set = new HashSet();
		
		for(int num : nums) {
			
			if(set.contains(num)) {
				
				return true;
			}
			
			set.add(num);
		}
		
		return false;
		
	}
	
	
	
	

}
