package ArrayBased;

public class MaximumSubArraySum {

	public static void main(String[] args) {

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(solution(nums));

	}
	//Approach: use kadane's Algorithm, if sum <0; make it 0,as -ve value don't contribute in getting max sum.
	// make 2 variables sum and maxSum, keep adding to sum on every iteration. and if sum> maxSum, assign sum to maxSum
	private static int solution(int[] nums) {
		
		int sum =0;
		int maxSum = nums[0];
		
		for(int num : nums) {
		
			sum += num;
			
			if(sum > maxSum) {
				
				maxSum = sum;
			}
	
			if(sum<0) {
				
				sum = 0;
			}
		}
		
		return maxSum;
	}

}
