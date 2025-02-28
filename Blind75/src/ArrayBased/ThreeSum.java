package ArrayBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {


		int[] nums = {-1,0,1,2,-1,-4};
		
		System.out.println(solution(nums));

	}
	// find unique triplets:
	//Approach: fix 1st element and move for triplets, loop starts from 0 so last two element we can not go ahead so, nums.length-2
	private static List<List<Integer>> solution(int[] nums){
	
		
		Set<List<Integer>> result = new HashSet();
		
		// base check
		if( nums.length< 3 || nums == null) return null;
		
		Arrays.sort(nums);
		
		for(int i = 0; i< nums.length-2 ;i++) { // for triplets
			
			int left = i+1; // fixing 0th position and moving right for triplets
			int right = nums.length-1;

			while(left< right) {
				
				int sum = nums[i] + nums[left] + nums[right];
				
				if(sum == 0) {
					
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					
					left++;
					right--;
				}else if( sum< 0) {
					
					left++;
				}else {
					
					right --;
				}
			}
		}
		
		return new ArrayList<>(result);
	}

}
