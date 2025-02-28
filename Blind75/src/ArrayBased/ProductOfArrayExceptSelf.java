package ArrayBased;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {

		int[] nums = {1,2,3,4};
		
		int[] result = solution2(nums);
		
		for(int i =0; i< result.length;i++) {
			
			System.out.print(result[i]+",");
		}

	}
	//We can multiply with every element to a variable then divide that variable by each element 
	
	private static int[] solution(int[] nums) {
		
		int total = 1;
		
		for(int i : nums) {
			
			total = total*i;
		}
		
		for(int i = 0 ;i< nums.length;i++) {
			
			
			nums[i] = total/nums[i];
		}
		
		return nums;
		
	}
	//But if interviewer is not agreed to use multiply and divide operation.
	// Make two array; left and right and finally multiply them to get result
	
	private static int[] solution2(int[] nums) { // nums = {1,2,3,4}
		
		int length = nums.length;
		
		int[] leftArray = new int[length];
		int[] rightArray = new int[length];
		int[] resultArray = new int[length];
		
		// making left array
		
		leftArray[0] = 1;
		
		for(int i = 1; i< length;i++) {
			
			leftArray[i] = leftArray[i-1]*nums[i-1]; //1,1,2,6
		}
		
		// similarly for right Array
		
		rightArray[length-1] = 1;
		
		for(int i = length-2; i>=0 ;i--) { 
			
			rightArray[i] = rightArray[i+1]*nums[i+1]; ////1,4,12,24
		}
		
		// for resultant array
		
		for(int i =0; i< length;i++) {
			
			resultArray[i] = leftArray[i]*rightArray[i];
		}
		
		return resultArray;
	}

}
