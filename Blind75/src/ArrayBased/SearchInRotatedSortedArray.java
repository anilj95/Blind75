package ArrayBased;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {

       int[] nums = {4,5,6,7,0,1,2};
       int target = 0;
       
       System.out.println(solution(nums,target));

	}
	// find the target in sorted and rotated array and return the index: apply binary search to get in O(logn) time
   private static int solution(int[] nums, int target) {
	   
	   int left = 0;
	   int right = nums.length-1;
	   
	   while(left <= right) {
		   
		   int mid = left + (right-left)/2;
		   
		   if(nums[mid] == target) {
			   
			   return mid;
			   
		   }else if(nums[mid] > nums[left]) {// means left array is sorted
			   
			   if( nums[left] <= target && target < nums[mid]) {// if target lies between left and mid
				   
				   right = mid-1;
			   }else {
				   
				   left = mid+1;
			   }
			   
		   }else { // means right array is sorted
			   
			   if( nums[mid] <= target && target < nums[right]) { // if target lies in between mid and right
				   
				   left = mid+1;
			   }else {
				   
				   right = mid-1;
			   }
			   
		   }
		   
	   }
	   
	   return -1;
	   
	   
   }
}
