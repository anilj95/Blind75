package ArrayBased;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

       int[] nums = {2,7,1,5,1};
       int target = 6;
       
       int[] result = solution2(nums,target);
       
       for(int i =0; i<result.length ;i++) {
    	   
    	   System.out.print(result[i]+" "); 
       }
   
	}
	// when given array is sorted
	private static int[] solution(int[] nums, int target) {
		
		int left =0;
		int right = nums.length-1;
		
		while(left < right) {
			
			int sum = nums[left] + nums[right];
			
			if(sum == target) {
				
				return new int[] {left, right};
			}else if(sum < target) {
				
				left++;
			}else {
				
				right--;
			}
		}
		
		return null;
		
	}
	
	// when array is not sorted and contains duplicate : can not apply two pointers
	private static int[] solution2(int[] nums, int target) {
		
		Map<Integer,Integer> map = new HashMap();
		
		for(int i =0; i< nums.length; i++) {
			
			int compliment = target- nums[i];
			
			if(map.containsKey(compliment)) {
				
				return new int[] {map.get(compliment),i};
				
			}
			
			map.put(nums[i], i);
		}
		
		
		return null;
			
		
	}
	

}
