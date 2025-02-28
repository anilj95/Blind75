package ArrayBased;

public class MaximumSumArrayProduct {

	public static void main(String[] args) {

      int[] nums = {2,3,0,2,4};
      
      System.out.println(solution(nums));

	}
	
	private static int solution(int[] nums){
		
		
		int maxProduct = nums[0];
		
		int leftProduct = 1;
		int rightProduct = 1;
		
		for(int i = 0; i< nums.length;i++) {
			
			// making left , right = 1, if they become 0
			
			leftProduct = leftProduct == 0 ? 1: leftProduct;
			rightProduct = rightProduct == 0 ? 1: rightProduct;
			
			leftProduct*= nums[i];
			rightProduct*= nums[nums.length-1-i];
			
			maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
			
		}
		
		 return maxProduct;
	}

}
