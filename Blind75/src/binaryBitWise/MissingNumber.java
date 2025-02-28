package binaryBitWise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {
		
		int[] nums = {3,0,1,5};
		
		System.out.println(solution4(nums));

	}
	// using XOR operation properties: for more clarity: https://www.youtube.com/watch?v=-BtU_c-mm2o
	//// TC = O(n) , SC = O(1) i.e. only variable
	private static int solution(int[] nums) {
		
		int n = nums.length;
		
		int missingNumber = n; // including nth index ; i.e 3
		
		for(int i = 0; i< n; i++) { // i = 0,1,2
			
			missingNumber = missingNumber^i^nums[i]; //first loop: 3^0^3 -> 3^3^0 -> 0^0 = 0; 2nd:  0^1^0 = 1; 3rd: 1^2^1->1^1^2->0^2 = 2
		}
		
		return missingNumber; //2
		
	}
	// using simple math :sum of n natural no. = n*(n+1)/2 = Expected no.
	// TC = O(n),SC = O(1) i.e. only variable.
	private static int solution2(int[] nums) {
		
		int n = nums.length;
		
		int expectedSum = n*(n+1)/2;
		
		int actualSum = 0;
		
		for(int i =0; i< nums.length;i++) {
			
			actualSum+= nums[i];
		}
		
		return expectedSum - actualSum;
		
		
	}
	// using sorting, then compare element with index, as {3,0,1} -> (0,1,3) then check if index != nums[i] return index
	// TC = O(nlogn) as sorting takes this much time
	private static int solution3(int[] nums) {
		
		Arrays.sort(nums);
		
		for(int i =0; i<nums.length;i++) {
			
			if( i != nums[i]) {
				
				return i;
			}
		}
		
		return -1;
		
	}
	// using HashSet
	//// TC = O(n),SC = O(n) i.e. using hashSet.
	private static int solution4(int[] nums) {
		
		Set<Integer> set = new HashSet();
		
         for(int i =0; i< nums.length;i++) {
			
			set.add(nums[i]);
		}
		
		for(int i =0; i< nums.length;i++) {
			
			if( !set.contains(i)) {
				
				return i;
			}
		}
		
		return -1;
		
	}

}
